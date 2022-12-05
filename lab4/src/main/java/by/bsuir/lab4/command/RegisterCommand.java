package by.bsuir.lab4.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.constant.PageConstant;
import by.bsuir.lab4.constant.RequestConstant;
import by.bsuir.lab4.entity.User;
import by.bsuir.lab4.exception.ServiceException;
import by.bsuir.lab4.service.UserService;
import by.bsuir.lab4.validator.*;

import java.util.HashMap;
import java.util.Map;

public class RegisterCommand implements Command {

    private static Logger log = LogManager.getLogger("register");

    private UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        String login = requestContent.getRequestParameter(RequestConstant.LOGIN)[0];
        String password = requestContent.getRequestParameter(RequestConstant.PASSWORD)[0];
        String email = requestContent.getRequestParameter(RequestConstant.EMAIL)[0];
        String firstName = requestContent.getRequestParameter(RequestConstant.FIRST_NAME)[0];
        String lastName = requestContent.getRequestParameter(RequestConstant.LAST_NAME)[0];
        String phoneNumber = requestContent.getRequestParameter(RequestConstant.PHONE_NUMBER)[0];
        String country = requestContent.getRequestParameter(RequestConstant.COUNTRY)[0];
        String birthday = requestContent.getRequestParameter(RequestConstant.BIRTHDAY)[0];
        User user;

        LoginValidator loginValidator = new LoginValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        EmailValidator emailValidator = new EmailValidator();
        BirthdayValidator birthdayValidator = new BirthdayValidator();

        if (loginValidator.isValidated(login) && passwordValidator.isValidated(password)
                && emailValidator.isValidated(email) && birthdayValidator.isValidated(birthday)) {
            try {
                user = userService.register(login, password, email, firstName, lastName, phoneNumber, country, birthday,
                        false);
            } catch (ServiceException e) {
                log.error("Unable to register user");
                return new DefaultCommand().execute(requestContent);
            }
            Map<String, Object> users = new HashMap<>();
            users.put(RequestConstant.USER, user);
            commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.LOGIN_PAGE, users);
            log.debug(user + "was successfully registered");
        } else {
            commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.LOGIN_PAGE);
        }
        return commandResult;
    }
}
