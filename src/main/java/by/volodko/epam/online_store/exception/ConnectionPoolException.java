package by.volodko.epam.online_store.exception;

import java.security.PrivilegedActionException;

public class ConnectionPoolException extends Exception{

    public ConnectionPoolException() {
    }


    public ConnectionPoolException(String message) {
        super(message);
    }


    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }


    public ConnectionPoolException(Exception e) {
        super(e);
    }
}
