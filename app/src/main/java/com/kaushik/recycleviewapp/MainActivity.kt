package com.kaushik.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/*
    1. first intitalize the adapter type (eg. linear layout)
    2. create the view in layout ( here item_view.kt )
    3. create view_adpater.kt file ( here, RecycelerViewAdpater.kt )
        - make the adapter class
        - make the view holder class ( the view created in step 2 is used here )
    4. After creation, link the adapter_class to the recycler_view
    5. Add on click listener

 */

class MainActivity : AppCompatActivity(), RecyclerViewItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this) // step 1

        // initialization of the adapter
        val dataForAdapter = createData()
        val adapter = RecyclerViewAppAdapter(dataForAdapter, this)

        // linking of the adapter to recycler_view
        recyclerView.adapter = adapter
    }

    // fake data creation
    private fun createData(): ArrayList<String> {
        val list = ArrayList<String>()
        for(i in 0 until 100){
            list.add("my_item $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,item,Toast.LENGTH_LONG).show()
    }


}