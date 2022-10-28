package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.R
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.adapter.FilesListAdapter
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel.FilesLoadViewModel
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel.FilesViewModelFactory
import kotlinx.android.synthetic.main.activity_news_list.*

class FilesLoadActivity : AppCompatActivity() {

    private lateinit var viewModel: FilesLoadViewModel
    private lateinit var filesListAdapter: FilesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        var scroll = false
        button.setOnClickListener {
//            if(!scroll) {
                recycler_view.scrollToPosition(recycler_view.adapter!!.itemCount - 1)
//                scroll = true
//            } /*else {
//                recycler_view.scrollToPosition(0)
//                scroll = false
            }
        viewModel = ViewModelProvider(this, FilesViewModelFactory(this)).get(FilesLoadViewModel::class.java)
        initAdapter()
    }

    private fun initAdapter() {
        filesListAdapter = FilesListAdapter()
        recycler_view.adapter = filesListAdapter
        viewModel.newsList.observe(this,
            Observer {
                filesListAdapter.submitList(it)
            })
    }
}