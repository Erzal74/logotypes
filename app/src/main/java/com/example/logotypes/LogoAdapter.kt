package com.example.logotypes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class LogoAdapter(private val logos: List<Logo>) : RecyclerView.Adapter<LogoAdapter.LogoViewHolder>() {

    class LogoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoImageView: ImageView = itemView.findViewById(R.id.logoImageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logo, parent, false)
        return LogoViewHolder(view)
    }

    override fun onBindViewHolder(holder: LogoViewHolder, position: Int) {
        val logo = logos[position]
        holder.titleTextView.text = logo.title
        holder.descriptionTextView.text = logo.description
        Picasso.get().load(logo.logoUrl).into(holder.logoImageView)
    }

    override fun getItemCount(): Int = logos.size
}
