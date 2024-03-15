package com.ap.postsapp.repositories

import android.content.Context
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ap.postsapp.api.ApiService
import com.ap.postsapp.contract.IViewImpl
import com.ap.postsapp.models.Comments
import com.ap.postsapp.utils.NetworkUtils
import java.util.logging.Handler

class CommentRepository(
    private val apiService: ApiService,
    private val context: Context,
    private val view: IViewImpl
) {
    private val commentsLiveData = MutableLiveData<Comments>()
    private val handler = android.os.Handler(Looper.getMainLooper())
    val comments: LiveData<Comments>
        get() = commentsLiveData

    suspend fun getComments(postId: Int) {
        if(NetworkUtils.isInternetAvailable(context)) {
            val result = apiService.getComments(postId)
            if(result?.body() != null) {
                commentsLiveData.postValue(result.body())
            }
            handler.post {
                view.showMessage("Successfully fetched data")
            }



        } else {
            // TODO Room Offline Mode - show data from room

            handler.post {
                view.showMessage("Internet Connection Unavailable")
            }


        }
    }


}