package com.blazen.server.node;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "node", path = "node")
public interface INodeRepository extends MongoRepository<Node, String> {

}
