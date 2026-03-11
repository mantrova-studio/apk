package com.polihov.restaurantshell

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polihov.restaurantshell.databinding.ItemRestaurantBinding

class RestaurantAdapter(
    private val items: List<Restaurant>,
    private val onClick: (Restaurant) -> Unit
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    inner class RestaurantViewHolder(
        private val binding: ItemRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Restaurant) {
            binding.imageLogo.setImageResource(item.logoResId)
            binding.textName.text = item.name
            binding.root.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRestaurantBinding.inflate(inflater, parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
