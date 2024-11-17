package com.example.logotypes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class LogoAdapter(private val data: List<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_LOGO = 1
    }

    sealed class Item {
        data class Header(val category: String) : Item()
        data class Logo(val logo: com.example.logotypes.Logo) : Item() // Use the Logo class
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is Item.Header -> TYPE_HEADER
            is Item.Logo -> TYPE_LOGO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                inflater.inflate(R.layout.item_header, parent, false)
            )
            TYPE_LOGO -> LogoViewHolder(
                inflater.inflate(R.layout.item_logo, parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = data[position]) {
            is Item.Header -> (holder as HeaderViewHolder).bind(item)
            is Item.Logo -> (holder as LogoViewHolder).bind(item.logo)
        }
    }

    override fun getItemCount() = data.size

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvHeader: TextView = view.findViewById(R.id.tvHeader)

        fun bind(item: Item.Header) {
            tvHeader.text = item.category
        }
    }

    class LogoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgLogo: ImageView = view.findViewById(R.id.imgLogo)
        private val tvName: TextView = view.findViewById(R.id.tvName)
        private val tvVariant: TextView = view.findViewById(R.id.tvVariant)

        fun bind(logo: com.example.logotypes.Logo) {
            tvName.text = logo.name
            tvVariant.text = logo.variant

            // Glide with placeholder and error image
            Glide.with(imgLogo.context)
                .load(logo.)  // URL gambar logo
                .placeholder(R.drawable.placeholder)  // Gambar placeholder
                .error(R.drawable.error_image)  // Gambar error
                .into(imgLogo)  // Menempatkan gambar di ImageView
        }
    }

}
