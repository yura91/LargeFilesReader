package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FilesViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val context : Context = context


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FilesLoadViewModel(context) as T;
    }
}