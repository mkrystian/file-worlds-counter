package pl.krystianmajewski.file.worlds.counter.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class FileWordsContainer {

	private final Filename filename;
	private final Set<String> worldsSet;

	public static FileWordsContainer empty(Filename filename) {
		return new FileWordsContainer(filename, Collections.emptySet());
	}

	public FileWordsContainer(Filename filename, Set<String> worldsSet) {
		this.filename = filename;
		this.worldsSet = worldsSet;
	}

	public Filename getFilename() {
		return filename;
	}

	public boolean contains(String world) {
		return worldsSet.contains(world);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FileWordsContainer that = (FileWordsContainer) o;
		return Objects.equals(filename, that.filename) &&
				Objects.equals(worldsSet, that.worldsSet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(filename, worldsSet);
	}
}
