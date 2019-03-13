package pl.krystianmajewski.file.worlds.counter.model;

import java.io.File;
import java.util.Objects;

public class Filename {

	public static Filename fromFile(File file) {
		return new Filename(file.getName());
	}

	private Filename(String filename) {
		this.filename = filename;
	}

	private final String filename;

	@Override
	public String toString() {
		return filename;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Filename filename1 = (Filename) o;
		return Objects.equals(filename, filename1.filename);
	}

	@Override
	public int hashCode() {
		return Objects.hash(filename);
	}
}
