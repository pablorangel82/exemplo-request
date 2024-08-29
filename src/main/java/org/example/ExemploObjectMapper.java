package org.example;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExemploObjectMapper {
    public static void main(String[] args) throws IOException {
        URL urlObj = new URL("http://universities.hipolabs.com/");
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
            Hipolabs hipolabs = objectMapper.readValue(response.toString(), Hipolabs.class);
            //JSONObject jsonObject = new JSONObject(response.toString());
            //JSONArray entries = jsonObject.getJSONArray("entries");
            //List<Entrada> listaEntradas = objectMapper.readValue(entries.toString(),new TypeReference<ArrayList<Entrada>>(){} );
            System.out.println("Exemplo:" + hipolabs.getExample());
            System.out.println(hipolabs);

        } else {
            System.out.println("GET request not worked");
        }

    }
}