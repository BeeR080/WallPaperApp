package com.example.wallpaperapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.DiffUtillsPhotoCategoriesListItem
import com.example.wallpaperapp.R
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.databinding.PhotocategoriesListBinding

class MainAdapter(
    /*private var lListener:AdapterClickListener*/):
    ListAdapter<PhotoCategoriesListItem, MainAdapter.MyViewHolder>(DiffUtillsPhotoCategoriesListItem()) {


   inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = PhotocategoriesListBinding.bind(itemView)

    fun bind(photoCategoriesListItem: PhotoCategoriesListItem) = with(binding){
        mfTvTitle.text = currentList[adapterPosition].title
        mfTvDescription.text = currentList[adapterPosition].description
        mfTvTotalphotos.text = currentList[adapterPosition].total_photos.toString()
        mfTvLikes.text= currentList[adapterPosition].cover_photo.likes.toString()
    }

        init {

        }
    }




interface AdapterClickListener{
    fun onLongClick(currentItem: PhotoCategoriesListItem)
    fun checkBoxClick(currentItem: PhotoCategoriesListItem)

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(
          R.layout.photocategories_list,
          parent,
          false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentList= getItem(position)
        holder.bind(getItem(position))
    }


}