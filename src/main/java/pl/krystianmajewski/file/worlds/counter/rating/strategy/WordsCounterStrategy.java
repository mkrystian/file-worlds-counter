package pl.krystianmajewski.file.worlds.counter.rating.strategy;

import pl.krystianmajewski.file.worlds.counter.file.reader.FileReader;
import pl.krystianmajewski.file.worlds.counter.file.reader.FilesInDirectory;
import pl.krystianmajewski.file.worlds.counter.line.parser.LineParser;
import pl.krystianmajewski.file.worlds.counter.model.FileWordsContainer;
import pl.krystianmajewski.file.worlds.counter.model.Rating;
import pl.krystianmajewski.file.worlds.counter.rating.calculator.RatingCalculator;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordsCounterStrategy implements RatingStrategy {

	private final FileReader fileReader;
	private final LineParser lineParser;
	private final FilesInDirectory filesInDirectory;
	private final Set<FileWordsContainer> fileWordsContainers;
	private final RatingCalculator ratingCalculator;

	WordsCounterStrategy(File directory,
						 FileReader fileReader,
						 LineParser lineParser,
						 FilesInDirectory filesInDirectory,
						 RatingCalculator ratingCalculator) {
		this.fileReader = fileReader;
		this.lineParser = lineParser;
		this.filesInDirectory = filesInDirectory;
		this.fileWordsContainers = Collections.unmodifiableSet(readFiles(directory));
		this.ratingCalculator = ratingCalculator;
	}

	@Override
	public List<Rating> getBestRatingsFor(String line) {
		final Set<String> wordsToFind = lineParser.parseLine(line);

		return ratingCalculator.getBestRatings(wordsToFind, fileWordsContainers);
	}

	private Set<FileWordsContainer> readFiles(File directory) {
		Set<File> files = filesInDirectory.getFiles(directory);

		return files.stream()
				.map(fileReader::readFile)
				.collect(Collectors.toSet());
	}
}
