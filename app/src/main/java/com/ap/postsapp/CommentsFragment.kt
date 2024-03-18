package com.ap.postsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ap.postsapp.App.PostsApp
import com.ap.postsapp.adapters.CommentsAdapter
import com.ap.postsapp.models.Comments
import com.ap.postsapp.repositories.CommentRepository
import com.ap.postsapp.viewmodels.CommentViewModel
import com.ap.postsapp.viewmodels.CommentViewModelFactory

class CommentsFragment : Fragment() {
    lateinit var commentViewModel: CommentViewModel
    lateinit var commentRepository: CommentRepository
    lateinit var rvComments: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View =  inflater.inflate(R.layout.fragment_comments, container, false)

        // Inflate the layout for this fragment

        val rvComments = view.findViewById<RecyclerView>(R.id.rv_comments)

        rvComments.layoutManager = LinearLayoutManager(context)

        commentRepository = (requireActivity().application as? PostsApp)!!.commentRepository


        commentViewModel = ViewModelProvider(this, CommentViewModelFactory(commentRepository, 1)).get(CommentViewModel::class.java)

        commentViewModel.comments.observe(this.viewLifecycleOwner, Observer { comments: Comments ->

            val comment = comments.get(0)
            Log.d("COMMENT", "CommentFragment: \n email: ${comment.email} \n comment : ${comment.body} ")

            // TODO Add Recycler View code
            // adapter

            rvComments.adapter = CommentsAdapter(comments)

        })

//        view.findViewById<>()
        return view
    }
}