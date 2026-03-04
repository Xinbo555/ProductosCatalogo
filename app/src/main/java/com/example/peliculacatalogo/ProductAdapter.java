package com.example.peliculacatalogo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.peliculacatalogo.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProduct;
        TextView tvName;
        public ProductViewHolder(View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.iv_product);
            tvName = itemView.findViewById(R.id.tv_product);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_rv, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(currentProduct.getImage())
                .into(holder.ivProduct);
        holder.tvName.setText(currentProduct.getTitle());

        holder.ivProduct.setOnClickListener(v-> {
            Intent intent = new Intent(holder.itemView.getContext(), ProductInfoActivity.class);

            //pasamos argumentos necesarios
            intent.putExtra("product_name", currentProduct.getTitle());
            intent.putExtra("description", currentProduct.getDescription());
            intent.putExtra("image_url", currentProduct.getImage());

            //inicializamos el intent
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
