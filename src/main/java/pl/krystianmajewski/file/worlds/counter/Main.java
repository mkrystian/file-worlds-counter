package pl.krystianmajewski.file.worlds.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.krystianmajewski.file.worlds.counter.rating.strategy.RatingStrategy;

import java.io.File;
import java.util.Scanner;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	private static final String EXIT_COMMAND = ":quit";
	private static final int RESULTS_LIMIT = 10;

	public static void main(String[] args) {
		preConditions(args);

		final File directoryToScan = new File(args[0]);
		RatingStrategy ratingStrategy = RatingStrategy.countWordsInTatFilesWithNormalization(directoryToScan, RESULTS_LIMIT);

		mainLoop(ratingStrategy);
	}

	private static void preConditions(String[] args) {
		if (args.length == 0) {
			log.error("App must be started with directory to scan passed as argument");
			throw new IllegalArgumentException("No directory given to index");
		}
	}

	private static void mainLoop(RatingStrategy ratingStrategy) {
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
