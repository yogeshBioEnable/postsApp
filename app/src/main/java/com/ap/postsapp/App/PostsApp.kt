package com.ap.postsapp.App

import android.app.Application
import com.ap.postsapp.contract.IViewImpl
import com.ap.postsapp.api.ApiService
import com.ap.postsapp.api.RetrofitInstance
import com.ap.postsapp.repositories.CommentRepository
import com.ap.postsapp.repositories.PostRepository

class PostsApp: Application() {

    lateinit var postRepository: PostRepository
    lateinit var commentRepository: CommentRepository

    override fun onCreate() {
        super.onCreate()
        initiate()
    }
    private fun initiate() {
        val view = IViewImpl(applicationContext)
        val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)
        postRepository = PostRepository(apiService, applicationContext, view)
        commentRepository = CommentRepository(apiService, applicationContext, view)
    }

}