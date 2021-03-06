package repo.build

import org.junit.After

import java.nio.file.FileSystems
import java.nio.file.Files
import groovy.test.GroovyAssert

/**
 */
abstract class BaseTestCase extends GroovyAssert {
    protected Sandbox sandbox
    protected RepoEnv env
    protected ActionContext context
    protected CliOptions options

    void setUp() throws Exception {
        env = new RepoEnv(createTempDir())
        def cli = CliBuilderFactory.build(null)
        options = new CliOptions(cli.parse(getArgs()))
        context = new ActionContext(env, null, options, new DefaultActionHandler())
    }

    String[] getArgs() {
        return ["-j", "4"]
    }

    static File createTempDir() {
        return Files.createTempDirectory(
                FileSystems.getDefault().getPath('target'), 'sandbox').toFile()
    }

    @After
    public void shutDown() {
        try {
            context.close()
        } catch (RuntimeException e) {
            e.printStackTrace()
        }
    }

}
