package by.bsuir.lab4.command;

import by.bsuir.lab4.constant.PageConstant;

public class ToLoginCommand implements Command {
    @Override
    public CommandResult execute(RequestContent requestContent) {
        return new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.LOGIN_PAGE);
    }
}
