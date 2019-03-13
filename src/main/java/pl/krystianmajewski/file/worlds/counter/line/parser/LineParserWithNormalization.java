package pl.krystianmajewski.file.worlds.counter.line.parser;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;

public class LineParserWithNormalization implements LineParser {

	private static final Pattern nonNormalizedPattern = Pattern.compile("[^a-z]");

	@Override
	public Set<String> parseLine(String line) {
		if (isNull(line)) {
			return emptySet();
		}
		return Arrays.stream(line.split(" "))
				.map(this::normalizeWord)
				.filter(word -> word.length() > 0)
				.collect(Collectors.toSet());
	}

	private String normalizeWord(String nonNormalizedWord) {
		return nonNormalizedPattern.matcher(nonNormalizedWord.toLowerCase()).replaceAll("");
	}
}
