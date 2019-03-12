package pl.krystianmajewski.file.worlds.counter;

import pl.krystianmajewski.file.worlds.counter.model.FileWorldsContainer;
import pl.krystianmajewski.file.worlds.counter.model.Rating;

import java.util.List;
import java.util.Set;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public interface RatingCalculator {
	List<Rating> getBestRatings(Set<String> wordsToFind, Set<FileWorldsContainer> fileWorldsContainers);
}
