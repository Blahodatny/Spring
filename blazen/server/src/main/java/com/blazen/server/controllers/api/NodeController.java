package com.blazen.server.controllers.api;

import com.blazen.server.models.node.Node;
import com.blazen.server.services.node.INodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/nodes")
public class NodeController {
    private final INodeService service;

    @Autowired
    public NodeController(INodeService service) {
        this.service = service;
    }

    @PostMapping()
    ResponseEntity<?> newNode(@RequestBody Node node) throws URISyntaxException {
//        System.out.println(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(node.get_id().hashCode()).toUri());
        return ResponseEntity
                .created(new URI("blazen.con"))
                .body(service.addFolder(node));
    }
}