package pl.krystianmajewski.file.worlds.counter.line.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;

public class LineParserWithNormalization implements LineParser {

	private static final Logger log = LoggerFactory.getLogger(LineParserWithNormalization.class);
	private static final Pattern nonNormalizedPattern = Pattern.compile("[^a-z]");

	@Override
	public Set<String> parseLine(String line) {
		if (isNull(line)) {
			log.debug("Line is null, returning empty Set");
			return emptySet();
		}
		log.debug("Parsing line: {}", line);
		return Arrays.stream(line.split(" "))
				.map(this::normalizeWord)
				.filter(word -> word.length() > 0)
				.collect(Collectors.toSet());
	}

	private String normalizeWord(String nonNormalizedWord) {
		log.debug("Normalizing world: {}", nonNormalizedWord);
		return nonNormalizedPattern.matcher(nonNormalizedWord.toLowerCase()).replaceAll("");
	}
}
