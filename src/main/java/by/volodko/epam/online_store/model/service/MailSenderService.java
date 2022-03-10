package by.volodko.epam.online_store.model.service;

import by.volodko.epam.online_store.exception.ServiceException;

public interface MailSenderService {
    void send (String email, String subject, String message) throws ServiceException;
}
