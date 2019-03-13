package pl.krystianmajewski.file.worlds.counter.file.reader;

import java.io.File;
import java.util.Set;

public interface FilesInDirectory {
	Set<File> getFiles(File directory);
}
