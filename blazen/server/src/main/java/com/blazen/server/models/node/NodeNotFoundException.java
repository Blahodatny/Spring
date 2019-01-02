package com.blazen.server.models.node;

import org.bson.types.ObjectId;

public class NodeNotFoundException extends RuntimeException {
    public NodeNotFoundException(ObjectId id) {
        super("Could not find node: " + id);
    }
}