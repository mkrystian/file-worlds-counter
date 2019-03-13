package pl.krystianmajewski.file.worlds.counter.rating.calculator;

import pl.krystianmajewski.file.worlds.counter.model.FileWordsContainer;
import pl.krystianmajewski.file.worlds.counter.model.Rating;

import java.util.List;
import java.util.Set;

public interface RatingCalculator {
	List<Rating> getBestRatings(Set<String> wordsToFind, Set<FileWordsContainer> fileWordsContainers);
}
