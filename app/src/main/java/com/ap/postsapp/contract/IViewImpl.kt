package com.ap.postsapp.contract

import android.content.Context
import android.widget.Toast

class IViewImpl(private val context: Context): IView {
    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress(show: Boolean) {
        TODO("Not yet implemented")
    }
}