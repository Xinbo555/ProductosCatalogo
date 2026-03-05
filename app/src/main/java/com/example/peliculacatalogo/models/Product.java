package com.example.peliculacatalogo.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {

    private int id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    public static class Rating {
        private float rate;
        private int count;
    }

    //constructor Parcelable
    protected Product(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.price = in.readFloat();
        this.description = in.readString();
        this.category = in.readString();
        this.image = in.readString();

        rating = new Rating();
        this.rating.rate = in.readFloat();
        this.rating.count = in.readInt();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeFloat(price);
        parcel.writeString(description);
        parcel.writeString(category);
        parcel.writeString(image);

        this.rating = new Rating();
        parcel.writeFloat(rating.rate);
        parcel.writeInt(rating.count);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<>() {
        @Override
        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        @Override
        public Product[] newArray(int i) {
            return new Product[i];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public float getRate() {
        return rating.rate;
    }

    public int getCount() {
        return rating.count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

