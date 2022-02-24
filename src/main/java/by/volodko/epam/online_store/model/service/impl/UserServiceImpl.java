package by.volodko.epam.online_store.model.service.impl;

import by.volodko.epam.online_store.exception.RepositoryException;
import by.volodko.epam.online_store.exception.ServiceException;
import by.volodko.epam.online_store.model.entity.User;
import by.volodko.epam.online_store.model.repository.Specification;
import by.volodko.epam.online_store.model.repository.impl.UserRepositoryImpl;
import by.volodko.epam.online_store.model.repository.impl.specification.FindByLoginSpecification;
import by.volodko.epam.online_store.model.service.UserService;
import by.volodko.epam.online_store.model.util.PasswordCodec;
import by.volodko.epam.online_store.model.validator.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();
    private UserRepositoryImpl repository = UserRepositoryImpl.getInstance();
    private static UserServiceImpl instatnce;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstatnce() {
        if (instatnce == null) {
            instatnce = new UserServiceImpl();
        }
        return instatnce;
    }

    @Override
    public Optional<User> authenticate(String login, String password) throws ServiceException {
        Optional<User> user = Optional.empty();
        try {
            List<User> userList = repository.query(new FindByLoginSpecification(login));
            if (!userList.isEmpty()) {
                User tempUser = userList.get(0);
                String passwordCode = PasswordCodec.getInstance().codeString(password, login);
                if (passwordCode.equals(tempUser.getPassword())) {
                    user = Optional.of(tempUser);
                }
            }
        } catch (RepositoryException e) {
            logger.log(Level.ERROR, "Something wrong with connection to database", e);
            throw new ServiceException("Something wrong with connection to database", e);
        }

        return user;
    }

    @Override
    public boolean insert(User user) throws ServiceException {
        boolean flag = false;
        try {
            switch (user.getRole()) {
                case GUEST:
                    if (UserValidator.isValidLogin(user.getLogin()) && UserValidator.isValidPassword(user.getPassword())
                            & UserValidator.isValidEmail(user.getEmail())) {
                        String password = PasswordCodec.getInstance().codeString(user.getPassword(), user.getLogin());
                        user.setPassword(password);
                        repository.insert(user);
                        flag = true;
                    }
                    break;
                case MANAGER:
                    if (UserValidator.isValidLogin(user.getLogin()) & UserValidator.isValidPassword(user.getPassword())
                            & UserValidator.isValidEmail(user.getEmail()) & UserValidator.isValidName(user.getName())
                            & UserValidator.isValidSurname(user.getSurname()) & UserValidator.isValidPhone(user.getPhoneNumber())) {
                        String password = PasswordCodec.getInstance().codeString(user.getPassword(), user.getLogin());
                        user.setPassword(password);
                        repository.insert(user);
                        flag = true;
                    }
            }


        } catch (RepositoryException e) {
            logger.log(Level.ERROR, "Something wrong with connection to database", e);
            throw new ServiceException("Something wrong with connection to database", e);

        }

        return flag;
    }

    @Override
    public boolean update(User user) throws ServiceException {
        boolean flag = false;
        try {
            switch (user.getRole()) {
                case USER:
                    if (UserValidator.isValidName(user.getName()) & UserValidator.isValidSurname(user.getSurname())
                            & UserValidator.isValidPhone(user.getPhoneNumber())) {
                        repository.update(user);
                        flag = true;

                    }
                    break;
                case MANAGER:
                    repository.update(user);
                    flag = true;
                    break;
            }
        } catch (RepositoryException e) {
            logger.log(Level.ERROR, "Something wrong with connection to database", e);
            throw new ServiceException("Something wrong with connection to database", e);
        }
        return flag;
    }

    @Override
    public List<User> query(Specification specification) throws ServiceException {
        try {
            return repository.query(specification);
        } catch (RepositoryException e) {
            logger.log(Level.ERROR, "Something wrong with connection to database", e);
            throw new ServiceException("Something wrong with connection to database", e);
        }
    }
}
