package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExemploPOSTJSONObject {
    public static void main(String[] args) throws IOException, JSONException {
        URL urlObj = new URL("https://jsonplaceholder.typicode.com/posts");
        HttpURLConnection conexao = (HttpURLConnection)urlObj.openConnection();
        conexao.setRequestProperty("Accept", "application/json");
        conexao.setDoOutput(true);
        conexao.setRequestMethod("POST");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("userId",1);
        jsonObject.put("title","blabla" );
        jsonObject.put("completed",true);
        String json = jsonObject.toString();
        System.out.println(json);
        conexao.getOutputStream().write(json.getBytes());
        System.out.println(conexao.getResponseCode());

        BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        } in .close();

        System.out.println(response.toString());
    }
}
