package com.graphql.graphqlapi.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import com.graphql.graphqlapi.graphql.type.Post;
import com.graphql.graphqlapi.graphql.type.PostInput;

public interface PostService {
	Optional<List<Post>> getAllPosts();
	Optional<Post> getPostById(ObjectId id);
    Post createPost(PostInput postInput);
    boolean deletePost(ObjectId id);
    Post updatePost(ObjectId id, PostInput postInput);
}
