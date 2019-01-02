package com.blazen.server.services.node;

import com.blazen.server.models.node.Node;
import com.blazen.server.repositories.INodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements INodeService {
    private final INodeRepository repository;

    @Autowired
    public NodeServiceImpl(INodeRepository repository) {
        this.repository = repository;
    }

    public Node addFolder(Node node) {
        return repository.save(node);
    }
}