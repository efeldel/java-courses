package ru.courses.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.courses.store.ClientCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientCreateServletTest extends Mockito {
    final ClientCache cache = ClientCache.getInstance();

    @Test
    public void createClient() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("petType")).thenReturn("cat");
        when(request.getParameter("petName")).thenReturn("test");

        assertTrue(cache.values().isEmpty());

        new ClientCreateServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("name");
        verify(request, atLeast(1)).getParameter("petType");
        verify(request, atLeast(1)).getParameter("petName");
        assertFalse(cache.values().isEmpty());

        cache.delete(cache.findByName("test").getId());

        assertTrue(cache.values().isEmpty());
    }
}
