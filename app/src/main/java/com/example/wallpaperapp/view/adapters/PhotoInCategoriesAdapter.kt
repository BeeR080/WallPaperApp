package com.example.wallpaperapp.view.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.wallpaperapp.DiffUtillsPhotoCategoriesListItem
import com.example.wallpaperapp.DiffUtillsPhotoInCategories
import com.example.wallpaperapp.R
import com.example.wallpaperapp.data.PhotoCategoriesListItem
import com.example.wallpaperapp.data.PhotosInCategoriesItem
import com.example.wallpaperapp.databinding.PhotoInCategoriesListBinding


class PhotoInCategoriesAdapter(
    private var lListener: AdapterClickListener
):
    ListAdapter<PhotosInCategoriesItem,
            PhotoInCategoriesAdapter.MyViewHolder>(DiffUtillsPhotoInCategories()) {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = PhotoInCategoriesListBinding.bind(itemView)

        fun bind(photoInCategories: PhotosInCategoriesItem) = with(binding){

            picTvLikes.text= currentList[adapterPosition].likes.toString()
            picImage.load(currentList[adapterPosition].urls.full){
                transformations(RoundedCornersTransformation(8f))
            }

        }
        init {
            itemView.setOnClickListener {
                lListener.onClick(currentList[adapterPosition])
            }
        }


    }





    interface AdapterClickListener{
        fun onClick(currentItem: PhotosInCategoriesItem)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.photo_in_categories_list,
            parent,
            false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}