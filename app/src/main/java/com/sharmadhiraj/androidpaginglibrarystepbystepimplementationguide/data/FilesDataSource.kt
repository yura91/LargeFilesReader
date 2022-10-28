package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.data

import android.content.Context
import androidx.paging.PageKeyedDataSource

class FilesDataSource(
    private val context: Context
) : PageKeyedDataSource<Int, String>() {


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, String>
    ) {
        val str = LogFilesReader().readFiles(context, 0, params.requestedLoadSize)
        val list = mutableListOf<String>()
        if (str != null) {
            list.add(str)
            callback.onResult(
                list,
                null,
                1
            )
        } else {
            callback.onResult(
                list,
                null,
                null
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, String>) {

        val str = LogFilesReader().readFiles(context, params.key, params.requestedLoadSize)
        val list = mutableListOf<String>()
        if (str != null) {
            list.add(str)
            callback.onResult(
                list,
                params.key + 1
            )
        } else {
            callback.onResult(
                list,
                null
            )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, String>) {
    }
}