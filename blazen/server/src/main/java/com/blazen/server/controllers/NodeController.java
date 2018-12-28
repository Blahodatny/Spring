package com.blazen.server.controllers;

import com.blazen.server.node.INodeRepository;
import com.blazen.server.node.Nodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nodes")
public class NodeController {
    private final INodeRepository repository;

    @Autowired
    public NodeController(INodeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Nodes> getAllPets() {
        return repository.findAll();
    }
}