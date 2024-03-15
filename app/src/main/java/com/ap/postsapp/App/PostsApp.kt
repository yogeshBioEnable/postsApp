package com.ap.postsapp.App

import android.app.Application
import com.ap.postsapp.contract.IViewImpl
import com.ap.postsapp.api.PostService
import com.ap.postsapp.api.RetrofitInstance
import com.ap.postsapp.repositories.PostRepository

class PostsApp: Application() {

    lateinit var postRepository: PostRepository
    override fun onCreate() {
        super.onCreate()
        initiate()
    }

    private fun initiate() {
        val view = IViewImpl(applicationContext)
        val postService = RetrofitInstance.getInstance().create(PostService::class.java)
        postRepository = PostRepository(postService, applicationContext, view)
    }
}