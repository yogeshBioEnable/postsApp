package com.ap.postsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.ap.postsapp.R
import com.ap.postsapp.models.Comments

class CommentsAdapter(
    private val comments: Comments

): RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comments_card, parent, false)
        return CommentsViewHolder(view)
    }

    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.tvName.text = comments[position].name
        holder.tvEmail.text = comments[position].email
        holder.tvBody.text = comments[position].body
    }
}

class CommentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvName: TextView = itemView.findViewById(R.id.tv_name)
    val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
    val tvBody: TextView = itemView.findViewById(R.id.tv_body)
}