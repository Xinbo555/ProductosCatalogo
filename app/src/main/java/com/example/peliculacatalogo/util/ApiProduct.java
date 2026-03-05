package com.example.peliculacatalogo.util;

import android.util.Log;

import com.example.peliculacatalogo.models.Product;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiProduct {
    public static List<Product> getMovies() {
        List<Product> productList = new ArrayList<>();
        try {
            URL url = new URL("https://fakestoreapi.com/products");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            Gson gson = new Gson();
            Product[] productArray = gson.fromJson(content.toString(), Product[].class);
            productList.addAll(Arrays.asList(productArray));
            Log.i("productos", productList.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Log.i("productos", productList.toString());
        return productList;
    }
}
