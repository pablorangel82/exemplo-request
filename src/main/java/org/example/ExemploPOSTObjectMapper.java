package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExemploPOSTObjectMapper {
    public static void main(String[] args) throws IOException {
        URL urlObj = new URL("https://jsonplaceholder.typicode.com/posts");
        HttpURLConnection conexao = (HttpURLConnection)urlObj.openConnection();
        conexao.setRequestProperty("Accept", "application/json");
        conexao.setDoOutput(true);
        conexao.setRequestMethod("POST");
        User user = new User();
        user.setId(1);
        user.setUserId(1);
        user.setTitle("delectus aut autem");
        user.setCompleted(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        conexao.getOutputStream().write(json.getBytes());

        BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        } in .close();

        System.out.println(response.toString());
    }
}
