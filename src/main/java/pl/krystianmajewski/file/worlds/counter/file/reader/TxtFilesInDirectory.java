package pl.krystianmajewski.file.worlds.counter.file.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TxtFilesInDirectory implements FilesInDirectory {

	private static final Logger log = LoggerFactory.getLogger(TxtFilesInDirectory.class);

	private static final String EXTENSION_SEPARATOR = ".";
	private static final String FILENAME_EXTENSION = "txt";
	private static final FilenameFilter FILENAME_FILTER = (dir, name) -> name.endsWith(EXTENSION_SEPARATOR + FILENAME_EXTENSION);

	@Override
	public Set<File> getFiles(File directory) {
		checkPreConditions(directory);
		log.debug("Reading files from directory: {}", directory.getAbsolutePath());

		return Arrays.stream(directory.listFiles(FILENAME_FILTER))
				.filter(File::isFile)
				.collect(Collectors.toSet());
	}

	private void checkPreConditions(File directory) {
		if (Objects.isNull(directory)) {
			throw new IllegalStateException("Directory File is null");
		}
	}
}
