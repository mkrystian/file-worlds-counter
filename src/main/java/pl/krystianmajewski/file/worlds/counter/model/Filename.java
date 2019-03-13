package pl.krystianmajewski.file.worlds.counter.model;

import java.io.File;
import java.util.Objects;

public class Filename {

	public static Filename fromFile(File file) {
		return new Filename(file.getName());
	}

	private Filename(String name) {
		this.name = name;
	}

	private final String name;

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Filename filename1 = (Filename) o;
		return Objects.equals(name, filename1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
