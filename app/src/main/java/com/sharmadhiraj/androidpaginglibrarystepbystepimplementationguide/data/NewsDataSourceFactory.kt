package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable

class NewsDataSourceFactory(
    private val context: Context
) : DataSource.Factory<Int, String>() {

    val newsDataSourceLiveData = MutableLiveData<NewsDataSource>()

    override fun create(): DataSource<Int, String> {
        val newsDataSource = NewsDataSource(context)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}