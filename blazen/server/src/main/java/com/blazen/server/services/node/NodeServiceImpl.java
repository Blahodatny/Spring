package com.blazen.server.services.node;

import com.blazen.server.models.node.Node;
import com.blazen.server.repositories.INodeRepository;
import com.blazen.server.repositories.INodeRepositoryCustom;
import com.mongodb.client.model.GraphLookupOptions;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mongodb.client.model.Aggregates.graphLookup;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;


@Service
public class NodeServiceImpl implements INodeService, INodeRepositoryCustom {
    private final MongoTemplate template;
    private final INodeRepository repository;

    @Autowired
    public NodeServiceImpl(MongoTemplate template, INodeRepository repository) {
        this.template = template;
        this.repository = repository;
    }

    public Node createNode(Node node) {
        return repository.save(node);
    }

    public List<Node> findNodeChildren(String parent) {
        return template.aggregate(
                Aggregation.newAggregation(
                        (AggregationOperation) match(eq("_id", new ObjectId(parent))),
                        (AggregationOperation) graphLookup(
                                "nodes",
                                "$parent",
                                "parent",
                                "_id",
                                "children",
                                new GraphLookupOptions().maxDepth(1))
                ),
                Node.class,
                Node.class
        ).getMappedResults();
    }
}