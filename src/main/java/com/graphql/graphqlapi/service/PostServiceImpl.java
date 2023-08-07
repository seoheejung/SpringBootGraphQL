package com.graphql.graphqlapi.service;

import com.google.inject.Inject;
import com.graphql.graphqlapi.graphql.type.Post;
import com.graphql.graphqlapi.graphql.type.PostInput;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;

import lombok.RequiredArgsConstructor;

import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
	
	@Autowired 
	private MongoCollection<Document> postCollection;
	
	@Override
	public Optional<List<Post>> getAllPosts() {
	    List<Post> posts = new ArrayList<>();
	    for (Document doc : postCollection.find()) {
	        posts.add(documentToPost(doc));
	    }
	    return Optional.ofNullable(posts.isEmpty() ? null : posts);
	}

	/* null 반환 가능 */
	@Override
	public Optional<Post> getPostById(ObjectId id) {
		Document doc = postCollection.find(Filters.eq("_id", id)).first();
        return Optional.ofNullable(doc).map(this::documentToPost);
	}

	@Override
	public Post createPost (PostInput postInput) {
		Document document = new Document()
	            .append("name", postInput.getName())
	            .append("content", postInput.getContent())
	            .append("regDate", new Date().toString());
		InsertOneResult result = postCollection.insertOne(document);
		System.out.println(result);
	    return documentToPost(document);
	}

	@Override
	public boolean deletePost (ObjectId id) {
		DeleteResult deleteResult = postCollection.deleteOne(Filters.eq("_id", id));
        return deleteResult.getDeletedCount() > 0;
	}

	@Override
	public Post updatePost(ObjectId id, PostInput postInput) {
	    List<Bson> updates = new ArrayList<>();
	    if (postInput.getName() != null) {
	        updates.add(set("name", postInput.getName()));
	    }
	    if (postInput.getContent() != null) {
	        updates.add(set("content", postInput.getContent()));
	    }
	    postCollection.updateOne(Filters.eq("_id", id), combine(updates));
	    Document document = postCollection.find(Filters.eq("_id", id)).first();
	    return documentToPost(document);
	}

	private Post documentToPost(Document document) {
        ObjectId id = document.getObjectId("_id");
        String name = document.getString("name");
        String content = document.getString("content");
        String regDate = document.getString("regDate");
        return new Post(id, name, content, regDate);
    }

}
