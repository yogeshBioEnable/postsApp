package com.ap.postsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ap.postsapp.App.PostsApp
import com.ap.postsapp.adapters.PostAdapter
import com.ap.postsapp.contract.IPostListClickListener
import com.ap.postsapp.models.Posts
import com.ap.postsapp.models.PostsItem
import com.ap.postsapp.repositories.PostRepository
import com.ap.postsapp.viewmodels.PostViewModel
import com.ap.postsapp.viewmodels.PostViewModelFactory

class PostFragment : Fragment() {
    lateinit var rvPosts: RecyclerView
    lateinit var postViewModel: PostViewModel
    lateinit var postRepository: PostRepository

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_post, container, false)

        rvPosts = view.findViewById<RecyclerView>(R.id.rv_posts)

        val listner = object: IPostListClickListener {
            override fun onPostClick(view: View, postId: Int) {
                findNavController().navigate(R.id.action_postFragment_to_commentsFragment)
            }
        }

        rvPosts.layoutManager = LinearLayoutManager(context)

        postRepository = (requireActivity().application as? PostsApp)!!.postRepository

        postViewModel = ViewModelProvider(this, PostViewModelFactory(postRepository)).get(PostViewModel::class.java)

        postViewModel.posts.observe(this.viewLifecycleOwner, Observer{ posts: Posts ->
            val post1 = posts.get(0)

            Log.d("Post", "post1 = $post1 ")
            rvPosts.adapter = PostAdapter(posts, listner)
        })



        // Navigation
//        tvSample.setOnClickListener{
////            findNavController()
//            // This will navigate fro post to comments fragments
//            findNavController().navigate(R.id.action_postFragment_to_commentsFragment)
//        }
        return view
    }

}