package com.rpgsounds.rpgsounds;

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
