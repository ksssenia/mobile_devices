package com.example.circleslist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class CircleAdapter(
    private val inflater: LayoutInflater,
    private val onClick: (MainActivity.CircleList) -> Unit,
) :
    ListAdapter<MainActivity.CircleList, CircleAdapter.ViewHolder>(UserDiffCallback) {

    class ViewHolder(
        view: View,
        val onClick: (MainActivity.CircleList) -> Unit,
    ) : RecyclerView.ViewHolder(view) {
        private val number = view.findViewById<TextView>(R.id.CircleNumber)
        private val circleCard = view.findViewById<CardView>(R.id.ColoredCircle)
        private var circleList: MainActivity.CircleList? = null

        init {
            view.setOnClickListener {
                circleList?.let {
                    onClick(it)
                }
            }
        }

        fun bind(circleList: MainActivity.CircleList) {
            this.circleList = circleList
            number.text = circleList.number.toString()
            circleCard.setCardBackgroundColor(Color.parseColor(circleList.color))
        }
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view, onClick)
    }


    object UserDiffCallback : DiffUtil.ItemCallback<MainActivity.CircleList>() {
        override fun areContentsTheSame(
            oldItem: MainActivity.CircleList,
            newItem: MainActivity.CircleList,
        ): Boolean {
            val res = oldItem.number == newItem.number && oldItem.color == newItem.color

            return res
        }

        override fun areItemsTheSame(
            oldItem: MainActivity.CircleList,
            newItem: MainActivity.CircleList,
        ): Boolean {

            val res = oldItem == newItem

            return res
        }


    }
}