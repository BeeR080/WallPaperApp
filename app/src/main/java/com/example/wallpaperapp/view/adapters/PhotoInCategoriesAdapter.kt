package com.example.wallpaperapp.view.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.wallpaperapp.utills.DiffUtillsPhotoInCategories
import com.example.wallpaperapp.R
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

            picTvLikes.text= currentList[layoutPosition].likes.toString()
            picImage.load(currentList[layoutPosition].urls.full){
                transformations(RoundedCornersTransformation(8f))
            }

        }
        init {
            binding.picImage.setOnClickListener {
                lListener.onClick(currentList[layoutPosition])


            }
            binding.picImageDownload.setOnClickListener {
                lListener.onClickDownloadPhoto(currentList[layoutPosition])
            }
        }


    }





    interface AdapterClickListener{
        fun onClick(currentItem: PhotosInCategoriesItem)
        fun onClickDownloadPhoto(currentItem: PhotosInCategoriesItem)


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