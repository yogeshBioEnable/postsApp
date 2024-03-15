package com.ap.postsapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ap.postsapp.repositories.CommentRepository

class CommentViewModelFactory(
    private val repository: CommentRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return CommentViewModel(repository) as T
    }

}