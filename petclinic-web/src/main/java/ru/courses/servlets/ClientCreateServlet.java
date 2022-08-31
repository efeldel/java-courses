package ru.courses.servlets;

import ru.courses.Cat;
import ru.courses.Client;
import ru.courses.Dog;
import ru.courses.Pet;
import ru.courses.store.ClientCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientCreateServlet extends HttpServlet {
    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("petType").equalsIgnoreCase("cat"))
            this.CLIENT_CACHE.add(new Client(req.getParameter("name"), new Cat(req.getParameter("petName"))));
        if (req.getParameter("petType").equalsIgnoreCase("dog"))
            this.CLIENT_CACHE.add(new Client(req.getParameter("name"), new Dog(req.getParameter("petName"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
