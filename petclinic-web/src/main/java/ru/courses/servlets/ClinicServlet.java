package ru.courses.servlets;

import ru.courses.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClinicServlet extends HttpServlet{

    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();
    final List<Client> clients = new CopyOnWriteArrayList<Client>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "   <title>Pet Clinic</title>" +
                       // "/head" +
                        "<body>" +
                        "   <form action='" + req.getContextPath() + "/' method='post'>" +
                        "       Client Name : <input type='text' name='name'>" +
//                        "       <input type='submit' value='Submit'>" +
//                        "   </form>" +
                        "   <form action='" + req.getContextPath() + "/' method='post'>" +
                        "       Pet Name : <input type='text' name='petName'>" +
                        "<input type='radio' name='petType' value='cat'>Cat<br>" +
                        "<input type='radio' name='petType' value='dog'>Dog<br>" +
                        "       <input type='submit' value='Submit'>" +
                        "   </form>" +
                       // this.viewPets() +
                        this.viewClients() +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("petType").equalsIgnoreCase("cat"))
            this.clients.add(new Client(req.getParameter("name"), new Cat(req.getParameter("petName"))));
        if (req.getParameter("petType").equalsIgnoreCase("dog"))
            this.clients.add(new Client(req.getParameter("name"), new Dog(req.getParameter("petName"))));
        //this.pets.add(new Dog(req.getParameter("name")));
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border : 1px solid black'>");
        for (Pet pet : pets) {
            sb.append("<tr><td style='border : 1px solid black'>").append(pet.getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String viewClients() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Clients</p>");
        sb.append("<table style='border : 1px solid black'>");
        for (Client client : clients) {
            sb.append("<tr><td style='border : 1px solid black'>").append(client.getName()).append("</td>" +
                    "<td style='border : 1px solid black'>").append(client.getPet()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
