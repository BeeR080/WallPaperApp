package com.example.wallpaperapp.data

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import com.example.wallpaperapp.view.ACCESS_KEY
import java.io.File

class DownloadManager(
    private val context:Context
) {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

fun downloadFile(url:String,fileName:String){
  val request = DownloadManager.Request(Uri.parse(url))
      .setMimeType("image/jpg")
      .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
      .setTitle(fileName)
      .addRequestHeader("Authorization","Client-ID ${ACCESS_KEY}")
      .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, File.separator+fileName+".jpg")
       downloadManager.enqueue(request)
}

}