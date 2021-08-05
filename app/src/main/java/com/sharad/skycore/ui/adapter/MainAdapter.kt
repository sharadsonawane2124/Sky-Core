package com.sharad.skycore.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sharad.skycore.R
import com.sharad.skycore.data.model.Businesses
import com.sharad.skycore.ui.adapter.MainAdapter.DataViewHolder
import com.sharad.skycore.ui.view.DetailActivity
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
class MainAdapter(private val users: ArrayList<Businesses>) :
    RecyclerView.Adapter<DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: Businesses) {
            itemView.apply {
                textViewName.text = user.name
                textViewRating.text = user.rating
                textViewUserAddress.text = user.location.display_address[0]
                if (user.is_closed)
                    textViewUserStatus.text = "Currently : Closed"
                else
                    textViewUserStatus.text = "Currently : Open"
                Glide.with(imageViewAvatar.context)
                    .load(user.image_url)
                    .into(imageViewAvatar)
                itemView.setOnClickListener(View.OnClickListener {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("url", user.url)
                    }
                    context.startActivity(intent)
                })
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: ArrayList<Businesses>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}