package pl.krystianmajewski.file.worlds.counter;

import pl.krystianmajewski.file.worlds.counter.rating.strategy.RatingStrategy;

import java.io.File;
import java.util.Scanner;

public class Main {

	private static final String EXIT_COMMAND = ":quit";
	private static final int RESULTS_LIMIT = 10;

	public static void main(String[] args) {


		if (args.length == 0) {
			throw new IllegalArgumentException("No directory given to index");
		}

		final File indexableDirectory = new File(args[0]);
		RatingStrategy ratingStrategy = RatingStrategy.countWordsInTatFilesWithNormalization(indexableDirectory, RESULTS_LIMIT);

		final Scanner keyboard = new Scanner(System.in);

		while (true) {
			System.out.print("\nsearch>");
			final String line = keyboard.nextLine();
			if (isExitCommand(line)) {
				return;
			}
			System.out.println(ratingStrategy.getBestRatingsFor(line));
		}
	}

	private static boolean isExitCommand(String line) {
		return EXIT_COMMAND.equalsIgnoreCase(line);
	}
}
