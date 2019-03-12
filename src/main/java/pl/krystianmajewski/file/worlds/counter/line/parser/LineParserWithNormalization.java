package pl.krystianmajewski.file.worlds.counter.line.parser;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class LineParserWithNormalization implements LineParser {

	private static final Pattern nonNormalizedPattern = Pattern.compile("[^a-z]");

	@Override
	public Set<String> parseLine(String line) {
		return Arrays.stream(line.split(" "))
				.map(this::normalizeWord)
				.collect(Collectors.toSet());
	}

	private String normalizeWord(String nonNormalizedWord) {
		return nonNormalizedPattern.matcher(nonNormalizedWord.toLowerCase()).replaceAll("");
	}
}
