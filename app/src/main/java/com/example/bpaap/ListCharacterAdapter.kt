package com.example.bpaap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>) :
    RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_character, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, birthday, bounty) = listCharacter[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val mContext = holder.itemView.context
            val moveDetail = Intent(mContext, CharacterDetail::class.java)
            moveDetail.putExtra(CharacterDetail.EXTRA_NAME, name)
            moveDetail.putExtra(CharacterDetail.EXTRA_DESCRIPTION, description)
            moveDetail.putExtra(CharacterDetail.EXTRA_PHOTO, photo)
            moveDetail.putExtra(CharacterDetail.EXTRA_BIRTHDAY, birthday)
            moveDetail.putExtra(CharacterDetail.EXTRA_BOUNTY, bounty)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int = listCharacter.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}