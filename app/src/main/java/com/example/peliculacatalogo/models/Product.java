package com.example.peliculacatalogo.models;

public class Product {
    private int id;
    private String title;
    private float price;
    private String description;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }

    private String category;
    private String image;
    private Rating rating;

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

    public int getcount() {
        return rating.count;
    }
}
class Rating {
    float rate;
    int count;
}
