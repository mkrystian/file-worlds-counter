package pl.krystianmajewski.file.worlds.counter.file.reader

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FilesInDirectoryTest extends Specification {

    def sut = new TxtFilesInDirectory()

    def "Should return files matching patter"() {
        given:
        def directory = Mock(File)
        def notAFile = Mock(File)
        def file = Mock(File)

        when:
        def result = sut.getFiles(directory)

        then:
        1 * directory.listFiles(_) >> [notAFile, file]
        1 * notAFile.isFile() >> false
        1 * file.isFile() >> true
        result == (Set) [file]
    }

    def "Should throw exception if given null file directory"() {
        given:
        def directory = null

        when:
        sut.getFiles(directory)

        then:
        IllegalStateException exception = thrown()
    }
}
