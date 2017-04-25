package repo.build.command

import groovy.transform.CompileStatic
import repo.build.ActionContext
import repo.build.DefaultParallelActionHandler
import repo.build.MavenFeature
import repo.build.CliOptions
import repo.build.RepoEnv

class ReleaseUpdateParentCommand extends AbstractCommand {
    ReleaseUpdateParentCommand() {
        super('release-update-parent', 'Update parent for each component')
    }

    public static final String ACTION_EXECUTE = 'releaseUpdateParentCommandExecute'

    void execute(RepoEnv env, CliOptions options) {
        def context = new ActionContext(env, ACTION_EXECUTE, options.getParallel(), new DefaultParallelActionHandler())
        context.withCloseable {
            def parentComponent = options.getParent()
            MavenFeature.updateParent(context,
                    options.getFeatureBranch(), parentComponent, true, false)
        }
    }
}
