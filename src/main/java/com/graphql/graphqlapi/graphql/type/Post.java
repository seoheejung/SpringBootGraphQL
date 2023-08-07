package com.graphql.graphqlapi.graphql.type;

import org.bson.types.ObjectId;

public class Post {
	
	private ObjectId id;
    private String name;
    private String content;
    private String regDate;

    public Post() { }

    public Post(ObjectId id, String name, String content, String regDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.regDate = regDate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

	public void setContent(String content) {
        this.content = content;
    }

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
