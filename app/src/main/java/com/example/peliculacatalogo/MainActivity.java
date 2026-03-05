package com.example.peliculacatalogo;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculacatalogo.models.Product;
import com.example.peliculacatalogo.util.ApiProduct;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProductAdapter adapter;
    private List<Product> productList = new ArrayList<>();

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

    private void loadProducts(){
        new Thread(()->{
            productList.addAll(ApiProduct.getMovies());
            Log.i("Productos actuales",productList.toString());
            runOnUiThread(()->{
                adapter.notifyItemRangeChanged(0,productList.size());
            });
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu,menu);
        return true;
    }

    //creamos la interaccion para refrescar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            productList.clear();
            adapter.notifyDataSetChanged();
            loadProducts();
        }
        return false;
    }
}