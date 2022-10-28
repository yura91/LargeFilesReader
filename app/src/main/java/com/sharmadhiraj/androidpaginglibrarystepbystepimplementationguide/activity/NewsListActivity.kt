package com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.R
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.adapter.NewsListAdapter
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel.NewsListViewModel
import com.sharmadhiraj.androidpaginglibrarystepbystepimplementationguide.viewModel.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_news_list.*

class NewsListActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsListViewModel
    private lateinit var newsListAdapter: NewsListAdapter

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
        viewModel = ViewModelProvider(this, NewsViewModelFactory(this)).get(NewsListViewModel::class.java)
        initAdapter()
    }

    private fun initAdapter() {
        newsListAdapter = NewsListAdapter()
        recycler_view.adapter = newsListAdapter
        viewModel.newsList.observe(this,
            Observer {
                newsListAdapter.submitList(it)
            })
    }
}