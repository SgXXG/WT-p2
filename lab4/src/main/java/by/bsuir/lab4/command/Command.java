package by.bsuir.lab4.command;

@FunctionalInterface
public interface Command {
    CommandResult execute(RequestContent requestContent);
}
