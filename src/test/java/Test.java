import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.SourceDataLine;
public class Test {
	public static void main(final String[] args) throws Exception {
		AudioInputStream in = null;

		final String PATH = Test.class.getResource("/lib/ActionButton/Monster01/mp3/Monster.01.02.mp3").getFile();

		try {
			File f = new File(PATH);
			in = AudioSystem.getAudioInputStream(f);
			AudioFormat baseFormat = in.getFormat();
			System.out.println(baseFormat);
			long frames = in.getFrameLength();
			System.out.println(frames);
			double durationInSeconds = (frames+0.0) / baseFormat.getFrameRate();
			System.out.println(durationInSeconds);
			AudioFormat decodedFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
					false);
			AudioFormat outFormat = getOutFormat(in.getFormat());
			System.out.println(outFormat);
			Info info = new Info(SourceDataLine.class, outFormat);
			System.out.println(info);
			Map<?,?> map = AudioSystem.getAudioFileFormat(f).properties();
			Long micros = (Long) map.get("duration");
			int milli = (int) (micros /1000);
			int sec = (milli /1000) % 60;
			int min = (milli / 1000 ) / 60;
			System.out.println(min + ":" + sec + "." + milli);
			
			SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
			line.open();
			line.start();
			long start = System.currentTimeMillis();
			stream(getAudioInputStream(outFormat, in), line);
			System.out.println((System.currentTimeMillis() - start) / 1000d);
			line.drain();
			line.stop();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static AudioFormat getOutFormat(AudioFormat inFormat) {
		final int ch = inFormat.getChannels();
		final float rate = inFormat.getSampleRate();
		return new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
	}
	
	private static void stream(AudioInputStream in, SourceDataLine line) 
	        throws IOException {
	        final byte[] buffer = new byte[4096];
	        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
	            line.write(buffer, 0, n);
	        }
	    }
}