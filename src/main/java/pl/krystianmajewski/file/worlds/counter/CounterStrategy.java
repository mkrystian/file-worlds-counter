package pl.krystianmajewski.file.worlds.counter;

import pl.krystianmajewski.file.worlds.counter.file.reader.FileReader;
import pl.krystianmajewski.file.worlds.counter.file.reader.FilesInDirectory;
import pl.krystianmajewski.file.worlds.counter.line.parser.LineParser;
import pl.krystianmajewski.file.worlds.counter.model.FileWorldsContainer;
import pl.krystianmajewski.file.worlds.counter.model.Rating;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class CounterStrategy {

	private final FileReader fileReader;
	private final LineParser lineParser;
	private final FilesInDirectory filesInDirectory;
	private final Set<FileWorldsContainer> fileWorldsContainers;
	private final RatingCalculator ratingCalculator;

	public CounterStrategy(FileReader fileReader, LineParser lineParser, FilesInDirectory filesInDirectory, File directory, RatingCalculator ratingCalculator) {
		this.fileReader = fileReader;
		this.lineParser = lineParser;
		this.filesInDirectory = filesInDirectory;
		this.fileWorldsContainers = readFiles(directory);
		this.ratingCalculator = ratingCalculator;
	}

	private Set<FileWorldsContainer> readFiles(File directory) {
		Set<File> files = filesInDirectory.getFiles(directory);

		return files.stream()
				.map(fileReader::readFile)
				.collect(Collectors.toSet());
	}


	public List<Rating> getBestRatingsFor(String line) {
		Set<String> wordsToFind = lineParser.parseLine(line);

		return ratingCalculator.getBestRatings(wordsToFind, Collections.unmodifiableSet(fileWorldsContainers));
	}
}
