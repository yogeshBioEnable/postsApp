package com.ap.postsapp.api

import com.ap.postsapp.models.Comments
import com.ap.postsapp.models.Posts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    //https://jsonplaceholder.typicode.com/posts

    @GET("posts")
    suspend fun getPosts(): Response<Posts>

    //https://jsonplaceholder.typicode.com/posts/1/comments

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId")  postId: Int): Response<Comments>


}


// TODO
/*
*  Retrofit - Interceptor
*
*  DI - Dagger/ HILT
*
*  NavBar
*
*  RecyclerView -> DataBinding
*
* */