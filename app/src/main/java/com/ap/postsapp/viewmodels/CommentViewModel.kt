package com.ap.postsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ap.postsapp.models.Comments
import com.ap.postsapp.repositories.CommentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentViewModel(
    private val repository: CommentRepository
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getComments()
        }
    }

    val comments: LiveData<Comments>
        get() = repository.comments


}