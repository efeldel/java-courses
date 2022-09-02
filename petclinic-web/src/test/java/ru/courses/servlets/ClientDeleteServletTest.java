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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientDeleteServletTest extends Mockito {
    final ClientCache cache = ClientCache.getInstance();

    @Test
    public void deleteClient() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("id")).thenReturn("1");

        assertTrue(cache.values().isEmpty());

        cache.add(new Client("test", new Cat("test")));

        assertFalse(cache.values().isEmpty());

        new ClientDeleteServlet().doGet(request, response);

       assertTrue(cache.values().isEmpty());
    }
}
