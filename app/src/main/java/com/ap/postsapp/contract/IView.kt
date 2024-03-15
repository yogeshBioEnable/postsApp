package com.ap.postsapp.contract

interface IView {
    fun showMessage(message: String)

    fun showProgress(show: Boolean)
}