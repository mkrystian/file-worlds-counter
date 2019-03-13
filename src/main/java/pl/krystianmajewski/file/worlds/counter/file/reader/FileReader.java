package pl.krystianmajewski.file.worlds.counter.file.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.krystianmajewski.file.worlds.counter.line.parser.LineParser;
import pl.krystianmajewski.file.worlds.counter.model.FileWordsContainer;
import pl.krystianmajewski.file.worlds.counter.model.Filename;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

public class FileReader {

	private static final Logger log = LoggerFactory.getLogger(FileReader.class);

	private final LineParser lineParser;

	public FileReader(LineParser lineParser) {
		this.lineParser = lineParser;
	}

	public FileWordsContainer readFile(File file) {
		try {
			log.debug("Reading file: {}", file);
			return new FileWordsContainer(Filename.fromFile(file), Files.lines(file.toPath())
					.map(lineParser::parseLine)
					.flatMap(Collection::stream)
					.collect(Collectors.toSet()));
		} catch (IOException e) {
			log.error(String.format("Could not read file: %s", file), e);
			return FileWordsContainer.empty(Filename.fromFile(file));
		}
	}
}
