package com.og.videogamebacklog.URLS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.og.videogamebacklog.main.getToken;

public class getAuthentication extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAuthentication's doGet() method is invoked.");
        doAction(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAuthentication's doGet() method is invoked.");
        doWarning(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAuthentication's doGet() method is invoked.");
        doWarning(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAuthentication's doPost() method is invoked.");
        doAction(req, resp);
    }

    private void doWarning(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("Please use POST");
    }

    private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bearer = getToken.getBearer();
        resp.setContentType("text/plain");
        resp.getWriter().write(bearer);
    }
}
