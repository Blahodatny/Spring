package com.blazen.server.node;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Nodes {
    @Id
    private ObjectId _id;
    private String name;

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
}