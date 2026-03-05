package com.example.peliculacatalogo;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculacatalogo.models.Product;
import com.example.peliculacatalogo.util.ApiProduct;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProductAdapter adapter;
    private final List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvProduct = findViewById(R.id.rv_product);
        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductAdapter(productList);

        loadProducts();

        rvProduct.setAdapter(adapter);
    }

    private void loadProducts() {
        new Thread(() -> {
            productList.addAll(ApiProduct.getMovies());
            Log.i("Productos actuales", productList.toString());
            runOnUiThread(() -> {
                adapter.notifyItemRangeInserted(0, productList.size());
            });
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu, menu);
        return true;
    }

    //creamos la interaccion para refrescar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            int listSize = productList.size();
            productList.clear();
            adapter.notifyItemRangeRemoved(0, listSize);
            loadProducts();
        }
        return false;
    }
}