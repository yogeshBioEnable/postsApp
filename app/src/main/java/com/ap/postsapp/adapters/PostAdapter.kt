package com.ap.postsapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ap.postsapp.PostFragment
import com.ap.postsapp.R
import com.ap.postsapp.contract.IPostListClickListener
import com.ap.postsapp.models.Posts

class PostAdapter(
    val posts: Posts,
    val postClickListener: IPostListClickListener
): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_card, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvTitle.text = posts[position].title
//        holder.tvEmail.text = posts[position].userId.toString()
        holder.tvPost.text = posts[position].body

        holder.cardPost.setOnClickListener{
//            chatListClickListener.onChatListItemClick(it,Users[position])
            postClickListener.onPostClick(it, posts[position].id) // id = postId
        }
    }

}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

//    init {
//        itemView.setOnClickListener{
//            Log.d("PostsAdapter", "clicked: ")
//
//        }
//    }

    val tvTitle: TextView = itemView.findViewById<TextView>(R.id.tv_title)
//    val tvEmail = itemView.findViewById<TextView>(R.id.tv_email)
    val tvPost: TextView = itemView.findViewById<TextView>(R.id.tv_post)

    val cardPost = itemView.findViewById<CardView>(R.id.card_post)
}