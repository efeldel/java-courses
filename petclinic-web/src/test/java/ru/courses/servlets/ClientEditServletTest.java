package ru.courses.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.courses.Cat;
import ru.courses.Client;
import ru.courses.store.ClientCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

public class ClientEditServletTest extends Mockito {
    final ClientCache cache = ClientCache.getInstance();

    @Test
    public void editClient() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("test1");
        when(request.getParameter("petType")).thenReturn("dog");
        when(request.getParameter("petName")).thenReturn("test2");

        when(request.getParameter("id")).thenReturn("2");

       assertTrue(cache.values().isEmpty());

        cache.add(new Client("test", new Cat("test")));

        assertFalse(cache.values().isEmpty());

        new ClientEditServlet().doPost(request, response);

        assertEquals(request.getParameter("name"), "test1");
        assertEquals(request.getParameter("petType"), "dog");
        assertEquals(request.getParameter("petName"), "test2");
        assertFalse(cache.values().isEmpty());

        cache.delete(cache.findByName("test1").getId());

        assertTrue(cache.values().isEmpty());
    }
}
