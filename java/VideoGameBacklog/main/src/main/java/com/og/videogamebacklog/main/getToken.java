package com.og.videogamebacklog.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class getToken {

    private static LocalDateTime expire;
    private static String Bearer;
    private static String clientId;
    private static String clientSecret;

    public static String getBearer() throws UnsupportedOperationException, IOException {

        if (expire == null || expire.isBefore(LocalDateTime.now())) {
            setIds();
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("https://id.twitch.tv/oauth2/token");

            // Request parameters and other properties.
            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
            params.add(new BasicNameValuePair("client_id", clientId));
            params.add(new BasicNameValuePair("client_secret", clientSecret));
            params.add(new BasicNameValuePair("grant_type", "client_credentials"));
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            // Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                try (InputStream instream = entity.getContent()) {
                    String jsonString = IOUtils.toString(instream, "UTF-8"); // assign your JSON String here
                    JSONObject obj = new JSONObject(jsonString);
                    expire = LocalDateTime.now().plusSeconds(obj.getInt("expires_in"));
                    Bearer = obj.getString("access_token");
                    return Bearer;
                }
            }
        }
        return Bearer;
    }

    private static void setIds() {
        try {
            File myObj = new File("main/src/SupportFiles/credential.txt");
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data = data + myReader.nextLine();
            }
            System.out.println(data);
            if (data != null) {
                try {
                    JSONObject obj = new JSONObject(data);
                    clientId = obj.getString("client_id");
                    clientSecret = obj.getString("client_secret");
                } catch (Exception e) {
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
