package com.ap.postsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ap.postsapp.R
import com.ap.postsapp.models.Posts

class PostAdapter(
    val posts: Posts
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
    }

}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById<TextView>(R.id.tv_title)
//    val tvEmail = itemView.findViewById<TextView>(R.id.tv_email)
    val tvPost: TextView = itemView.findViewById<TextView>(R.id.tv_post)
}