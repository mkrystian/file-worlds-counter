package pl.krystianmajewski.file.worlds.counter.model

import java.util.stream.Collectors

class FileWordsContainerMother {

    static Set<FileWordsContainer> createFileWordsContainers(Map<String, Set<String>> filenameWordsMap) {
        filenameWordsMap.entrySet().stream()
                .map({ entry -> createFileWordsContainer(entry.getKey(), entry.getValue()) })
                .collect(Collectors.toSet())
    }

    static FileWordsContainer createFileWordsContainer(String filename, Set<String> words) {
        new FileWordsContainer(new Filename(filename), words)
    }
}
