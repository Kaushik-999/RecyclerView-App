package com.kaushik.recycleviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// callback using interface( best way to implement a callback
interface RecyclerViewItemClicked {
    fun onItemClicked(item: String)
}


//the view_holder_class created below ( here RecyclerViewAppViewHolder)
// is passed in RecyclerView.Adapter<> ( i.e RecyclerView.Adapter<RecyclerViewAppViewHolder> )
// creating the view holder
class RecyclerViewAppViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
    val recycler_view_app_item_view: TextView = itemView.findViewById(R.id.item_view)
}


class RecyclerViewAppAdapter(val items: ArrayList<String>, private val callbackListener: RecyclerViewItemClicked): RecyclerView.Adapter<RecyclerViewAppViewHolder>() {

    /*
        onCreateViewHolder:
            here the item_view is connected to the view holder
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAppViewHolder {
        // here a view required as the argument in RecyclerViewAppViewHolder()
        // but it is in the format xml
        // to change xml into view "layout inflator" is used

        // the view is created here from xml
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        //the holder is created
        val holder = RecyclerViewAppViewHolder(view)

        // clicks should be handled by the activity not the adapter
        // so a callback/listener is set here to tell the activity that the ite is clicked
        // best way to implement "callback" is by using interface
        // listener is attached to view not view_holder
        view.setOnClickListener{ //callback
            callbackListener.onItemClicked(items[holder.adapterPosition])
        }
        return holder
    }
    /*
        onBindViewHolder:
            here the data is binded to the view holder in the adapter_class( here, RecyclerViewAppAdapter )
     */
    override fun onBindViewHolder(holder: RecyclerViewAppViewHolder, position: Int) {
        // "position" arguments comes with the override function

        // the current item is selected to bind the data
        val currentItem = items[position]

        // the data (here, currentItem) is binded to the holder
        holder.recycler_view_app_item_view.text = currentItem
    }

    /*
        getItemCount:
            it returns the count of the list ( here,  val items: ArrayList<String> )
            to get info about how many view needed to be created
     */
    override fun getItemCount(): Int {
        return items.size
    }

}



