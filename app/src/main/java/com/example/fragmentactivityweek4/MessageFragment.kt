package com.example.fragmentactivityweek4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.newsfeed_fragment.view.*

class MessageFragment : Fragment() {
    val list: ArrayList<String> = ArrayList()
    var mAdapter: NewsFeedAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.newsfeed_fragment, container, false);
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = NewsFeedAdapter(activity as MainActivity)
        for (i in 1..20) {
            list.add("test . $i")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.rvNewsFeed.layoutManager = LinearLayoutManager(activity)
        view.rvNewsFeed.adapter = mAdapter
        mAdapter?.setList(list)
    }
}