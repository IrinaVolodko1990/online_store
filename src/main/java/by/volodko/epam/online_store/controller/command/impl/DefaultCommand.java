package by.volodko.epam.online_store.controller.command.impl;

import by.volodko.epam.online_store.controller.command.Command;
import by.volodko.epam.online_store.controller.command.PagePath;
import by.volodko.epam.online_store.controller.command.Router;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        return new Router(PagePath.ERROR_404_PAGE,Router.RouterType.REDIRECT);
    }
}
