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
