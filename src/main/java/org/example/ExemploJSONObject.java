package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ExemploJSONObject {
    public static void main(String[] args) throws IOException, JSONException {
        URL urlObj = new URL("http://universities.hipolabs.com/");
        HttpURLConnection conexao = (HttpURLConnection)urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int responseCode = conexao.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

//            System.out.println(response.toString());
//
            JSONObject jsonObject = new JSONObject(response.toString());
            String example  = jsonObject.getString("example");
            String github  = jsonObject.getString("github");
//            System.out.println("Exemplo: "+ example);
//            System.out.println("End github: "+github);
            Hipolabs h = new Hipolabs();
            h.setExample(example);
            h.setGithub(github);
            System.out.println(h);
        } else {
            System.out.println("GET request not worked");
        }

    }
}