package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val context : Context = context


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsListViewModel(context) as T;
    }
}