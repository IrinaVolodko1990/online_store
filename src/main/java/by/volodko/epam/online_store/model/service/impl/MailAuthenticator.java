package by.volodko.epam.online_store.model.service.impl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator{
    private final String userName = "volodko.pp.1.20@gmail.com";
    private final String password = "6593132Velcom";
    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication
                (userName, password);
    }
}
