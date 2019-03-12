package pl.krystianmajewski.file.worlds.counter;

import pl.krystianmajewski.file.worlds.counter.file.reader.FileReader;
import pl.krystianmajewski.file.worlds.counter.file.reader.TxtFilesInDirectory;
import pl.krystianmajewski.file.worlds.counter.line.parser.LineParserWithNormalization;

import java.io.File;
import java.util.Scanner;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class Main {

	public static void main(String[] args) {

		if (args.length == 0) {
			throw new IllegalArgumentException("No directory given to index");
		}

		final File indexableDirectory = new File(args[0]);

		CounterStrategy counterStrategy = new CounterStrategy(new FileReader(new LineParserWithNormalization()), new LineParserWithNormalization(), new TxtFilesInDirectory(), indexableDirectory, new CountingRatingCalculator());

		final Scanner keyboard = new Scanner(System.in);

		while (true) {
			final String line = keyboard.nextLine();
			System.out.println(counterStrategy.getBestRatingsFor(line));
		}

	}
}
