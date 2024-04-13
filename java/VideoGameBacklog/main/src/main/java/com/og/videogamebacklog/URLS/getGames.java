package com.og.videogamebacklog.URLS;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.og.videogamebacklog.main.getToken;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class getGames extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAllGames's doGet() method is invoked.");
        doAction(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MySegetAllGamesvlet's doGet() method is invoked.");
        doWarning(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAllGames's doGet() method is invoked.");
        doWarning(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAllGames's doPost() method is invoked.");
        doAction(req, resp);
    }

    private void doWarning(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("Please use POST");
    }

    private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String games = getGames();
        resp.setContentType("text/plain");
        resp.getWriter().write(games);
    }

    public static String getGames() throws UnsupportedOperationException, IOException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://api.igdb.com/v4/games");
        String Bearer = "Bearer " + getToken.getBearer();
        // Request parameters and other properties.
        httppost.addHeader("Client-ID", "z860cn820avrt3vwnqybwpyq86v4oi");
        httppost.addHeader("Authorization", Bearer);

        // Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                String jsonString = IOUtils.toString(instream, "UTF-8"); // assign your JSON String here
                if (jsonString.charAt(0) == '[') {
                    JSONArray obj = new JSONArray(jsonString);
                    return obj.toString();
                } else {
                    JSONObject obj = new JSONObject(jsonString);
                    return obj.toString();
                }
            }
        }
        return null;
    }

}