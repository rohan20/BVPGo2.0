package com.example.rohan.bvpgo20.Models;

import com.example.rohan.bvpgo20.R;

import java.util.ArrayList;

/**
 * Created by Rohan on 07-May-16.
 */
public class Event {

    String description;
    String title;
    String image;

    public Event(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

}
