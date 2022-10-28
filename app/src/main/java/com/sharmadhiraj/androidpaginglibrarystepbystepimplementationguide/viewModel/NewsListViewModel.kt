package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.data.*
import io.reactivex.disposables.CompositeDisposable

class NewsListViewModel(context : Context) : ViewModel() {
    var newsList: LiveData<PagedList<String>>
    private val pageSize = 1024
    private val newsDataSourceFactory: NewsDataSourceFactory =
        NewsDataSourceFactory(context)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize)
            .setEnablePlaceholders(false)
            .build()
        newsList = LivePagedListBuilder(newsDataSourceFactory, config).build()
    }

}