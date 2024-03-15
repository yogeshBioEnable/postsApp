package com.ap.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ap.postsapp.App.PostsApp
import com.ap.postsapp.R
import com.ap.postsapp.repositories.PostRepository
import com.ap.postsapp.viewmodels.PostViewModel
import com.ap.postsapp.viewmodels.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var postViewModel: PostViewModel
    lateinit var postRepository: PostRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postRepository = (application as PostsApp).postRepository

        postViewModel = ViewModelProvider(this, PostViewModelFactory(postRepository)).get(PostViewModel::class.java)

        postViewModel.posts.observe(this, Observer{ posts ->
            val post1 = posts.get(0)
            Log.d("Post", "post1 = $post1 ")
        })
    }
}