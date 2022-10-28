package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.data.*

class FilesLoadViewModel(context : Context) : ViewModel() {
    var newsList: LiveData<PagedList<String>>
    private val pageSize = 1024
    private val filesDataSourceFactory: FilesDataSourceFactory =
        FilesDataSourceFactory(context)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize)
            .setEnablePlaceholders(false)
            .build()
        newsList = LivePagedListBuilder(filesDataSourceFactory, config).build()
    }

}