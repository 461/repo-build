package repo.build.command

import repo.build.*

class ExecuteCommand extends AbstractCommand {
    ExecuteCommand() {
        super('execute-command', 'Execute command')
    }

    public static final String ACTION_EXECUTE = 'executeCommandExecute'

    void execute(RepoEnv env, CliOptions options) {
        def context = new ActionContext(env, ACTION_EXECUTE, options, new DefaultActionHandler())
        context.withCloseable {
            def command = options.getGitCommand()
            GitFeature.executeGitCommand(context, command)
        }
    }
}
