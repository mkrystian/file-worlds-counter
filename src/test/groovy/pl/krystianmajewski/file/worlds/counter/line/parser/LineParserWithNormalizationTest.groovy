package pl.krystianmajewski.file.worlds.counter.line.parser

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LineParserWithNormalizationTest extends Specification {

    def sut = new LineParserWithNormalization()

    def "Should parse line with normalization as expected"() {
        expect:
        sut.parseLine(inputLine) == (Set) expectedResult

        where:
        inputLine                                        || expectedResult
        'Word'                                           || ['word']
        'test worlds in line'                            || ['test', 'worlds', 'in', 'line']
        'Just normal sentence, with special characters!' || ['just', 'normal', 'sentence', 'with', 'special', 'characters']
        'One word is duplicated Word'                    || ['one', 'word', 'is', 'duplicated']
        '2@ap!'                                          || ['ap']
        null                                             || []
        ''                                               || []
    }
}
