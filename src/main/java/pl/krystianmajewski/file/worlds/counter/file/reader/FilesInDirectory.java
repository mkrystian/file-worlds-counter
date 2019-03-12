package pl.krystianmajewski.file.worlds.counter.file.reader;

import java.io.File;
import java.util.Set;

/**
 * @author Krystian Majewski
 * @since 11.03.2019.
 */
public interface FilesInDirectory {
	Set<File> getFiles(File directory);
}
