package pl.krystianmajewski.file.worlds.counter.file.reader

import pl.krystianmajewski.file.worlds.counter.line.parser.LineParser
import pl.krystianmajewski.file.worlds.counter.model.FileWordsContainerMother
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FileReaderTest extends Specification {

    FileReader sut

    def lineParser = Mock(LineParser)

    def setup() {
        sut = new FileReader(lineParser)
    }

    def "Should read file given file"() {
        given:
        def directory = new File(getClass().getClassLoader().getResource("testInput.txt").getFile())

        when:
        def result = sut.readFile(directory)

        then:
        2 * lineParser.parseLine(_) >> ["result"]
        result == FileWordsContainerMother.createFileWordsContainer("testInput.txt", (Set) ["result"])
    }
}

