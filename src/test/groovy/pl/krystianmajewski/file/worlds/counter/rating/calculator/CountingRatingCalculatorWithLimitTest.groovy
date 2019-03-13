package pl.krystianmajewski.file.worlds.counter.rating.calculator

import pl.krystianmajewski.file.worlds.counter.model.FileWordsContainerMother
import pl.krystianmajewski.file.worlds.counter.model.RatingMother
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CountingRatingCalculatorWithLimitTest extends Specification {

    def sut = new CountingRatingCalculatorWithLimit(2)

    def "Should count percentage rating as expected"() {
        given:
        def fileWordsContainers = FileWordsContainerMother.createFileWordsContainers(filenameWordsMap)
        def expectedRatings = RatingMother.createRatings(filenamePercentageMap)

        expect:
        sut.getBestRatings((Set) wordsToFind, fileWordsContainers) == expectedRatings

        where:
        filenameWordsMap                                                                   | wordsToFind                  || filenamePercentageMap
        ['file1': (Set) ['first', 'second']]                                               | ['first']                    || ['file1': BigDecimal.valueOf(100)]
        ['file1': (Set) []]                                                                | ['first']                    || ['file1': BigDecimal.valueOf(0)]
        ['file1': (Set) ['first', 'second']]                                               | []                           || ['file1': BigDecimal.valueOf(100)]
        ['file1': (Set) ['first', 'second']]                                               | ['first', 'third', 'fourth'] || ['file1': BigDecimal.valueOf(33)]
        ['file1': (Set) ['first', 'second'], 'file12': (Set) ['first'], 'file3': (Set) []] | ['first', 'second']          || ['file1': BigDecimal.valueOf(100), 'file2': BigDecimal.valueOf(50)]
    }
}
