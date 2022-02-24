package by.volodko.epam.online_store.controller.command.impl;

import by.volodko.epam.online_store.controller.command.Command;
import by.volodko.epam.online_store.controller.command.RequestAttribute;
import by.volodko.epam.online_store.controller.command.Router;
import by.volodko.epam.online_store.controller.command.SessionAttribute;
import by.volodko.epam.online_store.model.entity.Product;
import by.volodko.epam.online_store.model.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class StartPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        ProductServiceImpl service ;//= Pro
        HttpSession session = request.getSession(true);
        boolean notAuthenticated = (boolean) session.getAttribute(SessionAttribute.NOT_AUTHENTICATED);
        request.setAttribute(RequestAttribute.NOT_AUTHENTICATED, notAuthenticated);
        List<Product> productList = null;
//        try {
//
//        }

return null;
    }
}
