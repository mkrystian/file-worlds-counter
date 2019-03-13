package pl.krystianmajewski.file.worlds.counter.rating.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.krystianmajewski.file.worlds.counter.model.FileWordsContainer;
import pl.krystianmajewski.file.worlds.counter.model.Rating;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingRatingCalculatorWithLimit implements RatingCalculator {

	private static final Logger log = LoggerFactory.getLogger(CountingRatingCalculatorWithLimit.class);

	private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

	private final int resultsLimit;

	public CountingRatingCalculatorWithLimit(int resultsLimit) {
		this.resultsLimit = resultsLimit;
	}

	@Override
	public List<Rating> getBestRatings(Set<String> wordsToFind, Set<FileWordsContainer> fileWordsContainers) {
		log.debug("Calculating rating. Words to find: {}, fileWordsContainer: {}", wordsToFind, fileWordsContainers);

		return fileWordsContainers.stream()
				.map(fileWorldsContainer -> calcRating(fileWorldsContainer, wordsToFind))
				.sorted(Comparator.reverseOrder())
				.limit(resultsLimit)
				.collect(Collectors.toList());
	}

	private Rating calcRating(FileWordsContainer fileWordsContainer, Set<String> wordsToFind) {
		long occurred = countOccurrences(fileWordsContainer, wordsToFind);
		int worldsToFindNumber = wordsToFind.size();
		return new Rating(fileWordsContainer.getFilename(), calcPercentage(worldsToFindNumber, occurred));
	}

	private long countOccurrences(FileWordsContainer fileWordsContainer, Set<String> wordsToFind) {
		return wordsToFind.stream()
				.map(fileWordsContainer::contains)
				.filter(Boolean::booleanValue)
				.count();
	}

	private BigDecimal calcPercentage(int worldsToFindNumber, long occurred) {
		if (worldsToFindNumber == 0) {
			log.debug("No words to find, returning rating 100%");
			return ONE_HUNDRED;
		}

		return BigDecimal.valueOf(occurred)
				.multiply(ONE_HUNDRED)
				.divide(BigDecimal.valueOf(worldsToFindNumber), RoundingMode.HALF_DOWN);
	}
}
