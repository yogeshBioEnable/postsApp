package com.ap.postsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ap.postsapp.models.Posts
import com.ap.postsapp.repositories.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(
    private val repository: PostRepository
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPosts()
        }
    }

    // get livedata data
    val posts : LiveData<Posts>
        get() = repository.posts

}