# MiniMint Posts REST API version 0.1

## How to Use

* copy application.properties from resources/templates to resources and adjust to match your mysql username and password
* create a database called project3 in mysql
* run AuthorizationApplication. By default API will be accessible on port 11001.

## Post

### //server:port/posts

- Create a new post.

#### Input: (post post)

```
{
    "title": "Happy Monday",
    "description": "Monday apples",
    "img": "img_url",
    "creationDate": "{{CurrentDateTime}}",
    "userId": 2
}
```

- Returns a post.

#### Output:

```    
{
    "id": 4,
    "userId": 2,
    "title": "Happy Monday",
    "description": "Monday apples",
    "img": "img_url",
    "creationDate": null,
    "upmints": 0,
    "downmints": 0,
    "commentList": null,
    "reactionList": null
}
```

### //server:port/post/{id}

- Find a post by id.

#### Input: (post post_id)

```
get call to //server:port/user/id/52
```

- Returns a post at the id

#### Output:

```    
{
    "id": 4,
    "userId": 2,
    "title": "Happy Monday",
    "description": "Monday apples",
    "img": "img_url",
    "creationDate": null,
    "upmints": 0,
    "downmints": 0,
    "commentList": [],
    "reactionList": []
}
```

### //server:port/posts/{id}

- Delete a post by id

#### Input: (delete post_id)

```
get call to //server:port/posts/4
```

- Deletes a post

#### Output:

```    
post deleted successfully
```

## Post Feed

### //server:port/postfeed

- Shows list of posts.

#### Input: (get)

```
get call to //server:port/postfeed
```

- Returns a list of posts.

#### Output:

```    
[
    {
        "id": 5,
        "userId": 2,
        "title": "Happy Monday",
        "description": "Monday bananas",
        "img": "img_url",
        "creationDate": null,
        "upmints": 0,
        "downmints": 0,
        "commentList": [],
        "reactionList": []
    },
    {
        "id": 6,
        "userId": 2,
        "title": "Happy Monday",
        "description": "Monday apples",
        "img": "img_url",
        "creationDate": null,
        "upmints": 0,
        "downmints": 0,
        "commentList": [],
        "reactionList": []
    },
    {
        "id": 7,
        "userId": 2,
        "title": "Happy Monday",
        "description": "Monday blueberries",
        "img": "img_url",
        "creationDate": null,
        "upmints": 0,
        "downmints": 0,
        "commentList": [],
        "reactionList": []
    }
]
```

### //server:port/postfeed/usersearch/{id}

- Shows list of posts by user id.

#### Input: (get)

```
get call to //server:port/postfeed/usersearch/3
```

- Returns a list of posts by user.

#### Output:

```
[
    {
        "id": 8,
        "userId": 3,
        "title": "Happy Monday",
        "description": "Monday scaries",
        "img": "img_url",
        "creationDate": null,
        "upmints": 0,
        "downmints": 0,
        "commentList": [],
        "reactionList": []
    }
]
```

### //server.port/postfeed/textsearch/{string}

- Shows list of posts by string.

#### Input: (get)

```
get call to //server:port/postfeed/usersearch/scaries
```

- Returns a list of posts by string.

#### Output:

```
[
    {
        "id": 8,
        "userId": 3,
        "title": "Happy Monday",
        "description": "Monday scaries",
        "img": "img_url",
        "creationDate": null,
        "upmints": 0,
        "downmints": 0,
        "commentList": [],
        "reactionList": []
    }
]
```

### //server.port/postfeed/datesearch/before/{ISO string}

- Shows list of posts by specfic date.

#### Input: (get)

```
get call to http://localhost:11001/postfeed/datesearch/before/2021-12-20T17:35:36.509Z
```

- Returns a list of posts by string.

#### Output:

```
[]
```

### //server.port/postfeed/datesearch/after/{ISO string}

- Shows list of posts by specfic date.

#### Input: (get)

```
get call to http://localhost:11001/postfeed/datesearch/after/2021-12-20T17:35:36.509Z
```

- Returns a list of posts by string.

#### Output:

```
[
    {
        "id": 9,
        "userId": 3,
        "title": "Happy Monday",
        "description": "Monday scaries",
        "img": "img_url",
        "creationDate": "2021-12-27T16:11:10.000+00:00",
        "upmints": 0,
        "downmints": 0,
        "commentList": [],
        "reactionList": []
    }
]
```

## Comment

### //server:port/comments/{id}

- adds comment to post.

#### Input: (post comment)

```
{
    "description": "Hello, this a comment from PostMan.",
    "date": "{{CurrentDateTime}}",
    "author": "Rory Eiffe"
}
```

- Returns comment made.

#### Output:

```    
{
    "id": 10,
    "description": "Hello, this a comment from PostMan.",
    "date": "2021-12-27T16:11:10.000+00:00",
    "author": "Rory Eiffe"
}
```

### //server:port/comments/{id}

- Gets comment from post.

#### Input: (get comment at post id)

```
get call to http://localhost:11001/comments/5
```

- Returns comment made.

#### Output:

```    
[
    {
        "id": 10,
        "description": "Hello, this a comment from PostMan.",
        "date": "2021-12-27T16:11:10.000+00:00",
        "author": "Rory Eiffe"
    }
]
```

### //server:port/comments/{id}

- Deletes comment from post.

#### Input: (delete comment at comment id)

```
get call to http://localhost:11001/comments/10
```

- Returns comment deleted.

#### Output:

```    
comment deleted successfully
```

### //server:port/comments/reply/{id}

- reply to comment

#### Input: (post)

```
{
    "description": "This is a new description",
    "date": "{{CurrentDateTime}}",
    "author": "Rory Eiffe",
    "parentComment": 17
}
```

- Returns reply made.

#### Output:

```    
{
    "id": 42,
    "description": "This is a new description",
    "date": "2021-12-27T22:16:48.000+00:00",
    "author": "Rory Eiffe",
    "parentComment": 17
}
```

### //server:port/comments/reply/{id}

- reply to comment

#### Input: (get)

```
```

- Returns replies for comment:

#### Output:

```    

[
    {
        "id": 17,
        "description": "Comment was deleted.",
        "date": "2021-12-30T17:37:15.513+00:00",
        "author": "Replier",
        "parentComment": 16
    }
]


## Reaction

### //server:port/reactions/

- adds reaction to post.

#### Input: (post reaction)

```
{
    "reaction": 3,
    "postId": 1,
    "userId": 3
}
```

- Returns reaction made.

#### Output:

```    
{
    "reactionId": 4,
    "postId": 1,
    "reaction": 3
}
```

### //server:port/reactions/reactionId/{id}

- Get reaction at id.

#### Input: (get reaction at id)

```
get call to http://localhost:11001/reactions/reactionId/4
```

- Returns reaction made at reaction id.

#### Output:

```    
{
    "reactionId": 2,
    "postId": 1,
    "reaction": 2
}
```

### //server:port/reactions/postId/{id}

- Get reaction at id.

#### Input: (get reaction at post_id)

```
get call to http://localhost:11001/reactions/postId/1
```

- Returns reaction made at reaction id.

#### Output:

```    
[
    {
        "reactionId": 4,
        "postId": 1,
        "reaction": 3
    }
]
```

### //server:port/reactions/update/{id}

- Get reaction at id.

#### Input: (put reaction at post_id)

```
get call to http://localhost:11001/reactions/update/4
```

- Updates reaction made at reaction id.

#### Output:

```    
[
    {
        "reactionId": 4,
        "postId": 1,
        "reaction": 10
    }
]
```

### //server:port/reactions/remove/{id}

- Get reaction at id.

#### Input: (put reaction at post_id)

```
get call to http://localhost:11001/reactions/remove/3
```

- Removes reaction made at reaction id.

#### Output:

```    
reaction deleted successfully
```
