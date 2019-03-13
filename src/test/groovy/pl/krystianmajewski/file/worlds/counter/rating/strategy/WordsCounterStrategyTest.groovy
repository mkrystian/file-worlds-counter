package pl.krystianmajewski.file.worlds.counter.rating.strategy

import pl.krystianmajewski.file.worlds.counter.file.reader.FileReader
import pl.krystianmajewski.file.worlds.counter.file.reader.FilesInDirectory
import pl.krystianmajewski.file.worlds.counter.line.parser.LineParser
import pl.krystianmajewski.file.worlds.counter.model.FileWordsContainer
import pl.krystianmajewski.file.worlds.counter.model.Filename
import pl.krystianmajewski.file.worlds.counter.rating.calculator.RatingCalculator
import spock.lang.Specification

class WordsCounterStrategyTest extends Specification {

    RatingStrategy sut

    def lineParser = Mock(LineParser)

    def ratingCalculator = Mock(RatingCalculator)
    def testWordsContainer = FileWordsContainer.empty(new Filename("testFilename.txt"))

    def setup() {
        def directory = Mock(File)
        def inputFile = Mock(File)
        def fileReader = Mock(FileReader)
        def filesInDirectory = Mock(FilesInDirectory)

        1 * filesInDirectory.getFiles(directory) >> [inputFile]
        1 * fileReader.readFile(inputFile) >> testWordsContainer

        sut = new WordsCounterStrategy(directory, fileReader, lineParser, filesInDirectory, ratingCalculator)
    }

    def "Should execute rating strategy"() {

        when:
        sut.getBestRatingsFor("Test line")

        then:
        1 * lineParser.parseLine("Test line") >> ['test', 'line']
        1 * ratingCalculator.getBestRatings(['test', 'line'].toSet(), [testWordsContainer].toSet())

    }
}
