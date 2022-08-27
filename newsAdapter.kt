package com.example.news_app_magang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class newsAdapter(private val data: List<News>): RecyclerView.Adapter<newsAdapter.newsHolder>() {

    class newsHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(news: News){
            val image = view.findViewById<ImageView>(R.id.image_News)
            val title = view.findViewById<TextView>(R.id.title_news)
            val content = view.findViewById<TextView>(R.id.content_news)

            title.text = news.title
            content.text = news.description

//            Glide.with(view.context).load(news.image).centerCrop().into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsHolder {
        val layoutNews = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent,false)
        return newsHolder(layoutNews)
    }

    override fun onBindViewHolder(holder: newsHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}