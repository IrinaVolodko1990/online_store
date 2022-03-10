package by.volodko.epam.online_store.controller.command.impl;

import by.volodko.epam.online_store.controller.command.*;
import by.volodko.epam.online_store.exception.ServiceException;
import by.volodko.epam.online_store.model.entity.Product;
import by.volodko.epam.online_store.model.repository.impl.specification.FindAllProductsSpecification;
import by.volodko.epam.online_store.model.service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.volodko.epam.online_store.controller.command.RequestAttribute.PRODUCT_LIST;
import static by.volodko.epam.online_store.controller.command.Router.RouterType.FORWARD;


public class StartPageCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router;
        ProductServiceImpl service = ProductServiceImpl.getInstance();
        HttpSession session = request.getSession(true);
        boolean notAuthenticated = (boolean) session.getAttribute(SessionAttribute.NOT_AUTHENTICATED);
        request.setAttribute(RequestAttribute.NOT_AUTHENTICATED, notAuthenticated);
        List<Product> productList = null;
        try {
            productList = service.query(new FindAllProductsSpecification());
            request.setAttribute(PRODUCT_LIST, productList);
            router = new Router(PagePath.START_PAGE, FORWARD);
        } catch (ServiceException e)
        {
            request.setAttribute(RequestAttribute.EXCEPTION,e);
            router = new Router(PagePath.ERROR_PAGE, FORWARD);

        }

return router;
    }
}
