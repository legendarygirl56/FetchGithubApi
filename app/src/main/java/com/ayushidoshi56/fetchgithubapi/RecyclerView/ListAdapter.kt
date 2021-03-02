package com.ayushidoshi56.fetchgithubapi.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayushidoshi56.fetchgithubapi.R
import com.ayushidoshi56.fetchgithubapi.databinding.ItemBinding
import com.ayushidoshi56.fetchgithubapi.model.ApiResponse
import com.squareup.picasso.Picasso

//Create directly by Package*right click*->New->Recycler Adapter->remove 2nd line of template
//need to make binding at end -> in fun bind()
class ListAdapter : RecyclerView.Adapter<ListAdapter.ListAdapterViewHolder>() {
    //Data
    var data: MutableList<ApiResponse> = mutableListOf()

    //ClickListener need to be implemented in activity
    var onItemClick: ((data: String) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAdapter.ListAdapterViewHolder {
        return ListAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    //Data Change or Add
    fun swapData(newData: MutableList<ApiResponse>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ListAdapter.ListAdapterViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() = data.size

    inner class ListAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemBinding.bind(itemView)
        fun bind(item: ApiResponse) = with(itemView) {
            //Bind the data with View
            binding.tv1.text=item.login
            binding.tv2.text=item.id.toString()
            Picasso.get().load(item.avatarUrl).into(binding.iv)

            setOnClickListener {
                onItemClick?.invoke(item.login.toString())
            }
        }
    }
}