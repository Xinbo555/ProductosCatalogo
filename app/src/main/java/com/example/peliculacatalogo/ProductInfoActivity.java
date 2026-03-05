package com.example.peliculacatalogo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.peliculacatalogo.databinding.ActivityProductInfoBinding;
import com.example.peliculacatalogo.models.Product;

public class ProductInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProductInfoBinding binding = ActivityProductInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //recuperamos el producto pasado por en indent
        Product product = getIntent().getParcelableExtra("product");

        if (product == null) {
            finish();
            return;
        }

        //modificamos el actionBar por defecto de Material3
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(product.getTitle() != null ? product.getTitle().toUpperCase() : "");
        }

        //cargamos la imagen
        Glide.with(this) // contexto
                .load(product.getImage())
                .into(binding.ivProductDetallado);

        binding.tvNombreProduct.setText(product.getTitle());
        binding.tvDescripProduct.setText(product.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Cierra la Activity y vuelve atrás
            return true;
        }
        return false;
    }
}