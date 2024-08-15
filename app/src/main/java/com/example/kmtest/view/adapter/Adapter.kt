package com.example.kmtest.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kmtest.data.response.DataItem
import com.example.kmtest.databinding.ItemRowBinding
import com.example.kmtest.view.SecondActivity
import com.example.kmtest.view.ThirdActivity

class Adapter : ListAdapter<DataItem, Adapter.ArticleListViewHolder>(DIFF_CALLBACK) {
    inner class ArticleListViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: DataItem) {
            val fullName = "${article.firstName} ${article.lastName}"
            binding.itemName.text = fullName
            binding.itemEmail.text = article.email

            Glide
                .with(itemView.context)
                .load(article.avatar)
                .into(binding.imgItemPhoto)

            binding.root.setOnClickListener {
                val intent = Intent(itemView.context, ThirdActivity::class.java)
                intent.putExtra(ThirdActivity.DETAIL, article.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleListViewHolder {
        val view = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleListViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }

    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<DataItem>(){
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}