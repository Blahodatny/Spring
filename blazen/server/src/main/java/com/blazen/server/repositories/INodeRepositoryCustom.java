package com.blazen.server.repositories;

import com.blazen.server.models.node.Node;

import java.util.List;

public interface INodeRepositoryCustom {
    List<Node> findNodeChildren(String parent);
}
