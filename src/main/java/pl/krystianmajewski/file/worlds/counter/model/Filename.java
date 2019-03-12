package pl.krystianmajewski.file.worlds.counter.model;

import java.io.File;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class Filename {

	public static Filename fromFile(File file){
		return new Filename(file.getName());
	}

	private Filename(String filename) {
		this.filename = filename;
	}

	private final String filename;

	@Override
	public String toString() {
		return String.format("filename %s", filename);
	}
}
