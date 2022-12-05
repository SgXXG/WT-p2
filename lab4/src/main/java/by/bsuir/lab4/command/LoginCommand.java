package by.bsuir.lab4.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.constant.PageConstant;
import by.bsuir.lab4.constant.RequestConstant;
import by.bsuir.lab4.entity.User;
import by.bsuir.lab4.exception.ServiceException;
import by.bsuir.lab4.message.MessageHandler;
import by.bsuir.lab4.service.UserService;
import by.bsuir.lab4.validator.LoginValidator;
import by.bsuir.lab4.validator.PasswordValidator;

import java.util.HashMap;
import java.util.Map;

public class LoginCommand implements Command {

    private static Logger log = LogManager.getLogger("login");

    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        User user;
        CommandResult commandResult;
        String login = requestContent.getRequestParameter(RequestConstant.LOGIN)[0];
        String password = requestContent.getRequestParameter(RequestConstant.PASSWORD)[0];
        Map<String, Object> requestAttributes = new HashMap<>();
        Map<String, Object> users = new HashMap<>();
        LoginValidator loginValidator = new LoginValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        if (loginValidator.isValidated(login) && passwordValidator.isValidated(password)) {
            try {
                if (userService.login(login, password).isEmpty()) {
                    users.put(RequestConstant.ERROR_LOGIN_PASS, MessageHandler.getMessage("warning.login_password",
                            (String) requestContent.getSessionAttribute(RequestConstant.LOCALE)));
                    commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.LOGIN_PAGE,
                            requestAttributes, users);
                    log.debug("Login error: can't find user");
                } else {
                    user = userService.login(login, password).get(0);
                    if (!user.isAdmin()) {
                        users.put(RequestConstant.USER, user);
                        commandResult = new CommandResult(CommandResult.ResponseType.FORWARD,
                                PageConstant.USER_MAIN_PAGE, requestAttributes, users);
                        log.debug(user + " logged in as user");
                    } else {
                        user = userService.login(login, password).get(0);
                        users.put(RequestConstant.USER, user);
                        commandResult = new CommandResult(CommandResult.ResponseType.FORWARD,
                                PageConstant.ADMIN_MAIN_PAGE, requestAttributes, users);
                        log.debug(user + " logged in as admin");
                    }
                }
            } catch (ServiceException e) {
                log.debug("Unable to log in", e);
                return new DefaultCommand().execute(requestContent);
            }
        } else {
            commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.LOGIN_PAGE);
        }
        return commandResult;
    }
}
