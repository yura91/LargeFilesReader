package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class FilesDataSourceFactory(
    private val context: Context
) : DataSource.Factory<Int, String>() {

    val newsDataSourceLiveData = MutableLiveData<FilesDataSource>()

    override fun create(): DataSource<Int, String> {
        val newsDataSource = FilesDataSource(context)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}