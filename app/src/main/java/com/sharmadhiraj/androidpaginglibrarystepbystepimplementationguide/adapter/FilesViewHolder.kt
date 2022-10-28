package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.R
import kotlinx.android.synthetic.main.item_news.view.*

class FilesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(news: String?) {
        if (news != null) {
            itemView.txt_news_name.text = news
        }
    }

    companion object {
        fun create(parent: ViewGroup): FilesViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
            return FilesViewHolder(view)
        }
    }
}