package ru.courses.servlets;

import ru.courses.store.ClientCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientDeleteServlet extends HttpServlet {
    private final ClientCache CLIENT_CACHE = ClientCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CLIENT_CACHE.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
