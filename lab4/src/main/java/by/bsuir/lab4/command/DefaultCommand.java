package by.bsuir.lab4.command;

public class DefaultCommand implements Command {

    @Override
    public CommandResult execute(RequestContent requestContent) {
        return new CommandResult();
    }
}
