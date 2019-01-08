package com.blazen.server.services.node;

import com.blazen.server.models.node.Node;

import java.util.List;

public interface INodeService {
    Node createNode(Node node);

    List<Node> findNodeChildren(String parent);
}