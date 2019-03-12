package pl.krystianmajewski.file.worlds.counter;

import pl.krystianmajewski.file.worlds.counter.model.FileWorldsContainer;
import pl.krystianmajewski.file.worlds.counter.model.Rating;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class CountingRatingCalculator implements RatingCalculator {
	@Override
	public List<Rating> getBestRatings(Set<String> wordsToFind, Set<FileWorldsContainer> fileWorldsContainers) {
		return fileWorldsContainers.stream()
				.map(fileWorldsContainer -> calcRating(fileWorldsContainer, wordsToFind))
				.sorted()
				.limit(10)
				.collect(Collectors.toList());
	}

	private Rating calcRating(FileWorldsContainer fileWorldsContainer, Set<String> wordsToFind) {
		long occurred = countOccurrences(fileWorldsContainer, wordsToFind);
		int worldsToFindNumber = wordsToFind.size();
		return new Rating(fileWorldsContainer.getFilename(), calcPercentage(worldsToFindNumber, occurred));
	}

	private long countOccurrences(FileWorldsContainer fileWorldsContainer, Set<String> wordsToFind) {
		return wordsToFind.stream()
				.map(fileWorldsContainer::contains)
				.filter(Boolean::booleanValue)
				.count();
	}

	private BigDecimal calcPercentage(int worldsToFindNumber, long occurred) {
		return BigDecimal.valueOf(occurred)
				.multiply(BigDecimal.valueOf(100))
				.divide(BigDecimal.valueOf(worldsToFindNumber), RoundingMode.HALF_DOWN);
	}
}
