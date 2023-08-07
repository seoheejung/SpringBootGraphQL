package com.graphql.graphqlapi.graphql.resolver;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.graphqlapi.graphql.type.Post;
import com.graphql.graphqlapi.graphql.type.PostInput;
import com.graphql.graphqlapi.service.PostServiceImpl;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class PostMutationResolver implements GraphQLMutationResolver {
	
	private final PostServiceImpl postService;

    @Autowired
    public PostMutationResolver(PostServiceImpl postService) {
        this.postService = postService;
    }

    public Post createPost (PostInput postInput) {
        return postService.createPost(postInput);
    }

    public boolean deletePost (ObjectId id) {
    	System.out.println("33333");
    	return postService.deletePost(id);
    }

    public Post updatePost (ObjectId id, PostInput postInput) {
        return postService.updatePost(id, postInput);
    }

}