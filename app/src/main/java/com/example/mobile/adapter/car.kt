package com.example.mobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.R
import de.hdodenhof.circleimageview.CircleImageView

class car (
    val context: Context,
    val imageList: ArrayList<Int>,
    val carTitle: ArrayList<String>,
    val carDesc: ArrayList<String>
) : RecyclerView.Adapter<car.carViewHolder>(){
    class carViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : CircleImageView = itemView.findViewById(R.id.profile_image)
        var title : TextView = itemView.findViewById(R.id.carTitle)
        var desc : TextView = itemView.findViewById(R.id.carDesc)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): carViewHolder {
    val itemView : View = LayoutInflater.from(context).inflate(R.layout.single_product,parent,false)
    return carViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return 3

            }

    override fun onBindViewHolder(holder: carViewHolder, position: Int) {
        holder.title.text=carTitle[position]
        holder.desc.text=carDesc[position]
        holder.image.setImageResource(imageList[position])
    }
}