package com.example.peliculacatalogo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;

public class ProductInfoActivity extends AppCompatActivity {

    //todo viewbinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        //recuperamos argumentos pasados por en indent
        String nombre = getIntent().getStringExtra("product_name");
        String descripcion = getIntent().getStringExtra("description");
        String imageUrl = getIntent().getStringExtra("image_url");

        //modificamos el actionBar por defecto de Material3
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nombre.toUpperCase());

        ImageView ivProduct = findViewById(R.id.iv_product_detallado);
        TextView tvProduct = findViewById(R.id.tv_nombre_product);
        TextView tvDetalles = findViewById(R.id.tv_descrip_product);

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