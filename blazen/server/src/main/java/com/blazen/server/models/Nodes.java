package com.blazen.server.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Nodes {
    @Id
    private ObjectId _id;
    private String[] children;
    private String link;
    private Date date;
    private boolean isFavourite;
    private boolean isDeleted;

    public Nodes(ObjectId _id, String link) {
        this._id = _id;
        try {
            this.link = new java.net.URL(link).toURI().toString();
        } catch (java.net.MalformedURLException
                | java.net.URISyntaxException e) {
            e.printStackTrace();
        }
        isFavourite = false;
        isDeleted = false;
    }
}