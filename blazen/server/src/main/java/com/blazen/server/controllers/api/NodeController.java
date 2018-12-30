package com.blazen.server.controllers.api;

import com.blazen.server.repositories.INodeRepository;
import com.blazen.server.models.Nodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/node")
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