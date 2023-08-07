# GraphQL API with Spring Boot and MongoDB

## 🚀 프로젝트  소개
 - SpringBoot와 mongoDB를 사용하여 graphQL 기반의 API 서버 구축 

## 🚀 프로젝트 기본 정보
- Spring Boot 2.7.14
- JDK : open jdk 11
- DB : mongoDB

## 🚀 프로젝트 기술 스택
 - GraphQL
    : 프론트에서 필요한 정보들만 가져올 수 있게 REST 대신 GraphQL 사용
 - Spring Boot
    : Grandle 빌드 툴을 사용
 - MongoDB
   :  NoSQL 데이터베이스로 사용

## 🚀 프로젝트 패키지 기본 구조
``` 
src/main/java
└─ com.graphql.graphqlApi
    ├─ config (설정 패키지)
    │   └─ GraphQLConfiguration.java
    ├─ graphql (GraphQL 코드 관련 패키지)
    │   ├─ resolver (GraphQL Resolver 패키지)
    │   │   └─ PostMutationResolver.java
    │   │   └─ PostQueryResolver.java
    │   ├─ type (GraphQL Type 패키지)
    │   │   └─ Post.java
    │   │   └─ PostInput.java
    ├─ moudules (mongoDB 설정 패키지)
    │   └─ MongoDbModule.java
    ├─ service (GraphQL에 사용할 Service 패키지)
    │   ├─ PostService.java
    │   └─ PostServiceImpl.java

src/main/resources
├─ graphql (GraphQL 스키마 구성 파일)
│ ├─ post.graphqls
├── application.properties
```

## 🚀 Gradle 의존성 참고
```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb-reactive'
	implementation 'org.springframework.boot:spring-boot-starter-graphql'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'com.graphql-java-kickstart:graphql-java-tools:13.0.3'
	implementation 'com.google.inject:guice:5.1.0'
	implementation 'com.graphql-java:graphql-java-extended-scalars:19.0'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	annotationProcessor 'org.projectlombok:lombok'
	providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'io.projectreactor:reactor-test'
	testImplementation 'org.springframework.graphql:spring-graphql-test'
}
```

## 🚀 필요 작업
 - prayground 페이지 실행
 - 스칼라 타입 만들기
 
## 클라이언트 GraphQL 쿼리
```
query {
  getAllPosts{
    id
    name
    content
  }
}

query GetPostById {
  getPostById(id: "64d14b6d7aad3f2ab5212c39") {
    id
    name
    content
  }
}

```
```
mutation {
  createPost(post:{name: "New Post", content: "This is the content of the new post."}) {
    name
    content
    regDate
  }
}
```
---