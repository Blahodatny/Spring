package com.blazen.server.controllers.api;

import com.blazen.server.models.node.Node;
import com.blazen.server.services.node.INodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/v1/nodes")
public class NodeController {
    private final INodeService service;

    @Autowired
    public NodeController(INodeService service) {
        this.service = service;
    }

    @PostMapping()
    ResponseEntity<?> newNode(@RequestBody Node node) {
        var saved = service.addFolder(node);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(saved.get_id().toString())
                                .toUri()
                )
                .body(saved);
    }
}