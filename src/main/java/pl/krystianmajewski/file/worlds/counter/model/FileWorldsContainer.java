package pl.krystianmajewski.file.worlds.counter.model;

import java.util.Collections;
import java.util.Set;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class FileWorldsContainer {

	private final Filename filename;
	private final Set<String> worldsSet;

	public static FileWorldsContainer empty(Filename filename) {
		return new FileWorldsContainer(filename, Collections.emptySet());
	}

	public FileWorldsContainer(Filename filename, Set<String> worldsSet) {
		this.filename = filename;
		this.worldsSet = worldsSet;
	}

	public Filename getFilename() {
		return filename;
	}

	public boolean contains(String world) {
		return worldsSet.contains(world);
	}
}
