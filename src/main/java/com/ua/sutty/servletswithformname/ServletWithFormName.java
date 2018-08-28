package com.ua.sutty.servletswithformname;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/helloForm")
public class ServletWithFormName extends HttpServlet {

    private volatile String name;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.append("<!DOCTYPE html>");
        writer.append("<html>");
        writer.append("<head>");
        writer.append("<meta charset=\"utf-8\" />");
        writer.append("<title>HTML Document</title>");
        writer.append("</head>");
        writer.append("<body>");
        writer.append("<form action=\"/helloForm\" method=\"post\">");
        writer.append("<input type=\"text\" name=\"name\">");
        writer.append("<input type=\"submit\" name=\"submit\">");
        writer.append("</form>");
        writer.append("Hello, ").append(name);
        writer.append("</body>");
        writer.append("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        doGet(req, resp);
    }
}
