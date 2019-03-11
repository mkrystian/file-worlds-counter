package pl.krystianmajewski.fileworldscounter.model;

import java.util.Set;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class WorldsContainer {

	public static WorldsContainer fromStringLine(String line){
		throw new UnsupportedOperationException("Not supported yet");
	}

	private WorldsContainer(Set<String> worldsSet) {
		this.worldsSet = worldsSet;
	}

	private Set<String> worldsSet;

	public boolean contains(String world){
		return worldsSet.contains(world);
	}
}
