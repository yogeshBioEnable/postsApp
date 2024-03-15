package com.ap.postsapp.api

import com.ap.postsapp.models.Posts
import retrofit2.Response
import retrofit2.http.GET

interface PostService {
    //https://jsonplaceholder.typicode.com/posts

    @GET("posts")
    suspend fun getPosts(): Response<Posts>

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