package com.example.wallpaperapp.view.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.wallpaperapp.utills.DiffUtillsPhotoCategoriesListItem
import com.example.wallpaperapp.R
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.databinding.PhotocategoriesListBinding

class MainAdapter(
    private var lListener: AdapterClickListener
):
    ListAdapter<PhotoCategoriesListItem,
            MainAdapter.MyViewHolder>(DiffUtillsPhotoCategoriesListItem()) {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = PhotocategoriesListBinding.bind(itemView)

        fun bind(photoCategoriesListItem: PhotoCategoriesListItem) = with(binding){
            mfTvTitle.text = currentList[layoutPosition].title
            mfTvTotalphotos.text = currentList[layoutPosition].total_photos.toString()
            mfTvLikes.text= currentList[layoutPosition].cover_photo.likes.toString()
            mfTvImage.load(currentList[layoutPosition].cover_photo.urls.regular){
                transformations(RoundedCornersTransformation(8f))
            }

        }
        init {
            itemView.setOnClickListener {
                lListener.onClick(currentList[layoutPosition])
            }
        }


    }





    interface AdapterClickListener{
        fun onClick(currentItem: PhotoCategoriesListItem)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.photocategories_list,
            parent,
            false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}