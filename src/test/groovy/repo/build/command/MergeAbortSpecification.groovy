package repo.build.command

import repo.build.GitFeature
import repo.build.RepoBuild
import spock.lang.Specification

class MergeAbortSpecification extends Specification {

    def setup() {
        GroovyMock(GitFeature, global: true)
    }

    def "without args"() {
        def repoBuild = new RepoBuild('merge-abort')

        when:
        repoBuild.execute()

        then:
        1 * GitFeature.mergeAbort(_)

    }

    def "with parallel"() {
        def repoBuild = new RepoBuild('merge-abort', '-j', '2')

        when:
        repoBuild.execute()

        then:
        1 * GitFeature.mergeAbort(_)

    }

}
