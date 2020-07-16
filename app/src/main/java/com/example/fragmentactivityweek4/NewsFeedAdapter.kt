package com.example.fragmentactivityweek4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.newfeed_item.view.*

class NewsFeedAdapter(var listener: ICommunicateFragment) :
    RecyclerView.Adapter<NewsFeedAdapter.MyViewHolder>() {
    private var list = ArrayList<String>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setList(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.newfeed_item, parent, false)
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.doSomeThing(list[position])
        }
        holder.itemView.tvItem.text = list[position]
    }

    override fun getItemCount() = list.size
}