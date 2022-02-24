package by.volodko.epam.online_store.controller.command;

import javax.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface Command {
    Router execute(HttpServletRequest request);

}
