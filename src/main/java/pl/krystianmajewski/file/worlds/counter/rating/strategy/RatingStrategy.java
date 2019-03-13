package pl.krystianmajewski.file.worlds.counter.rating.strategy;

import pl.krystianmajewski.file.worlds.counter.file.reader.FileReader;
import pl.krystianmajewski.file.worlds.counter.file.reader.TxtFilesInDirectory;
import pl.krystianmajewski.file.worlds.counter.line.parser.LineParserWithNormalization;
import pl.krystianmajewski.file.worlds.counter.model.Rating;
import pl.krystianmajewski.file.worlds.counter.rating.calculator.CountingRatingCalculatorWithLimit;

import java.io.File;
import java.util.List;

public interface RatingStrategy {
	List<Rating> getBestRatingsFor(String line);

	static RatingStrategy countWordsInTatFilesWithNormalization(File directory, int resultsLimit) {
		return new WordsCounterStrategy(directory,
				new FileReader(new LineParserWithNormalization()),
				new LineParserWithNormalization(),
				new TxtFilesInDirectory(),
				new CountingRatingCalculatorWithLimit(resultsLimit));
	}
}
