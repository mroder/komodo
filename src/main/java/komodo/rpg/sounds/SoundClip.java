package komodo.rpg.sounds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class SoundClip {
	private String clipPath;
	private String name;
	
	public String toString() {
		return name;
	}
}
