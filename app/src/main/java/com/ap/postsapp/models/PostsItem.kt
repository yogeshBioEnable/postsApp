package com.ap.postsapp.models

data class PostsItem(
    val body: String,
    val id: Int, // postId
    val title: String,
    val userId: Int
)