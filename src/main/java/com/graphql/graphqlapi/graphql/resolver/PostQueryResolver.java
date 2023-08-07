package com.graphql.graphqlapi.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.graphqlapi.graphql.type.Post;
import com.graphql.graphqlapi.service.PostServiceImpl;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver {
	
	@Autowired
    private PostServiceImpl postService;

    public Optional<List<Post>> getAllPosts() {
        return postService.getAllPosts();
    }

    public Optional<Post> getPostById(ObjectId id) {
        return postService.getPostById(id);
    }
}
