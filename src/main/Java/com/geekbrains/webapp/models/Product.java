package com.geekbrains.webapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String title;
    private double cost;

    public String toString() {
        String color = title.split(" ")[0];
        String str = String.format(
                "<h1>Product #%d</h1> <p><strong><span style=\"color: %s;\">%s</span></strong> for only <strong>%.2f $</strong></p> <br>",
                id, color, title, cost
        );

        return str;
    }
}
