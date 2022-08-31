package ru.courses.servlets;

import ru.courses.Cat;
import ru.courses.Client;
import ru.courses.Dog;
import ru.courses.store.ClientCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientEditServlet extends HttpServlet {
    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("client", this.CLIENT_CACHE.get(Integer.parseInt(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/EditClient.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("petType").equalsIgnoreCase("cat"))
            this.CLIENT_CACHE.edit(this.CLIENT_CACHE.get(Integer.parseInt(req.getParameter("id"))),req.getParameter("name"), new Cat(req.getParameter("petName")));
        if (req.getParameter("petType").equalsIgnoreCase("dog"))
            this.CLIENT_CACHE.edit(this.CLIENT_CACHE.get(Integer.parseInt(req.getParameter("id"))),req.getParameter("name"), new Dog(req.getParameter("petName")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
