package com.example.lab3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val context: Context,   // this context
    private val mList: Array<User>  // List of user
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //only creates a new view holder if there are
    // no existing view holders that RecyclerView can reuse
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    //returns the number of items in a list
    override fun getItemCount(): Int {
        return mList.size
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = mList[i].name
        viewHolder.itemImage.setImageResource(mList[i].images)

        //by clicking on the card we go to our friend’s page
        viewHolder.itemView.setOnClickListener {
            //create intent for going to another activity
            val intent = Intent(context, InfoActivity::class.java)
            //data transfer to user page
            intent.putExtra("name", mList[i].name)
            intent.putExtra("details", mList[i].details)
            intent.putExtra("image", mList[i].images)
            //start activity  "InfoActivity"
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //find View in xml file by id
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)   // find photo
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)   //find name
    }
}