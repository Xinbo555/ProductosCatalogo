package com.example.peliculacatalogo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.peliculacatalogo.databinding.ActivityProductInfoBinding;

public class ProductInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProductInfoBinding binding = ActivityProductInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_product_info);

        //recuperamos argumentos pasados por en indent
        String nombre = getIntent().getStringExtra("product_name");
        String descripcion = getIntent().getStringExtra("description");
        String imageUrl = getIntent().getStringExtra("image_url");

        //modificamos el actionBar por defecto de Material3
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(nombre != null ? nombre.toUpperCase() : "");
        }

        ImageView ivProduct = binding.ivProductDetallado;
        TextView tvProduct = binding.tvNombreProduct;
        TextView tvDetalles = binding.tvDescripProduct;

        //cargamos la imagen
        Glide.with(this) // contexto
                .load(imageUrl)
                .into(ivProduct);

        tvProduct.setText(nombre);
        tvDetalles.setText(descripcion);
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