package com.blazen.server.models.node;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "nodes")
public class Node {
    @Id
    private ObjectId _id;
    private String name;
    private ObjectId parent;
    private String link;
    private boolean isFavourite;
    private boolean isDeleted;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, String parent, String link) {
        this.name = name;
        this.parent = new ObjectId(parent);
        try {
            this.link = new java.net.URL(link).toURI().toString();
        } catch (java.net.MalformedURLException
                | java.net.URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public Node(String name, String parent) {
        this.name = name;
        this.parent = new ObjectId(parent);
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getParent() {
        return parent;
    }

    public void setParent(ObjectId parent) {
        this.parent = parent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}