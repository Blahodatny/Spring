package com.blazen.server.node;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Node {
    @Id
    private ObjectId _id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}