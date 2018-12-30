package com.blazen.server.repositories;

import com.blazen.server.models.Nodes;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "node", path = "node")
public interface INodeRepository extends MongoRepository<Nodes, String> {
    Nodes findBy_id(ObjectId _id);
}