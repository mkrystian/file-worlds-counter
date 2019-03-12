package pl.krystianmajewski.file.worlds.counter.line.parser;

import java.util.Set;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public interface LineParser {

	Set<String> parseLine(String line);
}
