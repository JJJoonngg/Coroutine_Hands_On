package kr.co.fastcampus.co.kr.coroutines.ui.main

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.fastcampus.co.kr.coroutines.model.Item

/*
* Created by JJJoonngg
*/

class FavoritesAdapter : RecyclerView.Adapter<ImageSearchViewHolder>() {
    private var items: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder =
        ImageSearchViewHolder.create({}, parent)

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }
}