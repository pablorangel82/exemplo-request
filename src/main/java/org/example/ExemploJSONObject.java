package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ExemploJSONObject {
    public static void main(String[] args) throws IOException {
        URL urlObj = new URL("https://api.publicapis.org/entries");
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

            JSONObject jsonObject = new JSONObject(response.toString());
            int total  = jsonObject.optInt("count");
            JSONArray jsonArray = jsonObject.getJSONArray("entries");
            for (int i=0; i<total; i++) {
                JSONObject entry = jsonArray.getJSONObject(i);
                Entrada entrada = new Entrada();
                entrada.setApi(entry.getString("API"));
                entrada.setHttps(entry.getBoolean("HTTPS"));
                entrada.setDescription(entry.getString("Description"));
                System.out.println(entrada);
            }
        } else {
            System.out.println("GET request not worked");
        }

    }
}