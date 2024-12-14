package com.example.mobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.adapter.car

class RecyclerActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    var imageList = ArrayList<Int>()
    var carTitle = ArrayList<String>()
    var carDesc = ArrayList<String>()

    lateinit var adapter: car
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
        recyclerView = findViewById(R.id.recyclerView)
        imageList.add(R.drawable.car)

        adapter = car(
            this@RecyclerActivity,
            imageList, carTitle,carDesc
            
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editData)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}