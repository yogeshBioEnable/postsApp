package com.ap.postsapp.contract

import android.view.View

interface IPostListClickListener {
    fun onPostClick(view: View, postId: Int)
}