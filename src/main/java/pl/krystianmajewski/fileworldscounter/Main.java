package pl.krystianmajewski.fileworldscounter;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public class Main {

	public static void main(String[] args){

		if(args.length == 0){
			throw new IllegalArgumentException("No directory given to index");
		}

		final File indexableDirectory = new File(args[0]);

		final Scanner keyboard = new Scanner(System.in);

		while (true){
			final String line = keyboard.nextLine();

		}

	}
}
