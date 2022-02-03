package by.volodko.epam.online_store.model.repository.impl;

import by.volodko.epam.online_store.exception.RepositoryException;
import by.volodko.epam.online_store.model.entity.User;
import by.volodko.epam.online_store.model.repository.Repository;
import by.volodko.epam.online_store.model.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserRepositoryImpl implements Repository<User> {
    private static final Logger logger = LogManager.getLogger();
private static final String ADD_USER_QUERY = "INSERT INTO users (login, email, password, name, last_name, phone, role_id, status_id)\" +\n" +
        "            \" VALUES (?,?,?,?,?,?,(SELECT id FROM roles WHERE role = ?),(SELECT id FROM status WHERE status = ?));";
    @Override
    public void insert(User ob) throws RepositoryException {

    }

    @Override
    public void update(User ob) throws RepositoryException {

    }

    @Override
    public List<User> query(Specification specification) throws RepositoryException {
        return null;
    }
}

