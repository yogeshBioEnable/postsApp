package com.ap.postsapp.repositories

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ap.postsapp.contract.IViewImpl
import com.ap.postsapp.api.PostService
import com.ap.postsapp.models.Posts
import com.ap.postsapp.utils.NetworkUtils

class PostRepository(
    private val postService: PostService,
    private val context: Context,
    private val view: IViewImpl

) {

    private val postsLiveData = MutableLiveData<Posts>()
    private val handler = Handler(Looper.getMainLooper())

    val posts : LiveData<Posts>

        get() = postsLiveData

    // Create fun to call api
    suspend fun getPosts() {
        if(NetworkUtils.isInternetAvailable(context)) {
            val result = postService.getPosts()

            if(result?.body() != null) {
                // add to live data
                postsLiveData.postValue(result.body())
            }
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
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