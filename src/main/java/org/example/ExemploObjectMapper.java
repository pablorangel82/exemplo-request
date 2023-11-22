package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExemploObjectMapper {
    public static void main(String[] args) throws IOException {
        URL urlObj = new URL("https://api.publicapis.org/entries");
        HttpURLConnection conexao = (HttpURLConnection)urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int responseCode = conexao.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in .close();

            ObjectMapper objectMapper = new ObjectMapper();
            RespostaJSON respostaJSON = objectMapper.readValue(response.toString(), RespostaJSON.class);
            //JSONObject jsonObject = new JSONObject(response.toString());
            //JSONArray entries = jsonObject.getJSONArray("entries");
            //List<Entrada> listaEntradas = objectMapper.readValue(entries.toString(),new TypeReference<ArrayList<Entrada>>(){} );
            for (Entrada entrada : respostaJSON.getEntries()){
                System.out.println(entrada);
            }

        } else {
            System.out.println("GET request not worked");
        }

    }
}