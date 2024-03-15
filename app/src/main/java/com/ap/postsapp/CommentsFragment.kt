package com.ap.postsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ap.postsapp.App.PostsApp
import com.ap.postsapp.models.Comments
import com.ap.postsapp.repositories.CommentRepository
import com.ap.postsapp.viewmodels.CommentViewModel
import com.ap.postsapp.viewmodels.CommentViewModelFactory

class CommentsFragment : Fragment() {

    lateinit var commentViewModel: CommentViewModel
    lateinit var commentRepository: CommentRepository


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        commentRepository = (requireActivity().application as? PostsApp)!!.commentRepository


        commentViewModel = ViewModelProvider(this, CommentViewModelFactory(commentRepository)).get(CommentViewModel::class.java)

        commentViewModel.comments.observe(this.viewLifecycleOwner, Observer { comments: Comments ->

            val comment = comments.get(0)
            Log.d("COMMENT", "CommentFragment: \n email: ${comment.email} \n comment : ${comment.body} ")

            // TODO Add Recycler View code
        })

        val view: View =  inflater.inflate(R.layout.fragment_comments, container, false)
//        view.findViewById<>()
        return view
    }
}