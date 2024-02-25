package com.example.spotrify

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(var songs: List<Song>) : RecyclerView.Adapter<SongViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SongViewHolder(layoutInflater.inflate(R.layout.song_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.bind(song)

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, SongActivity::class.java)
            intent.putExtra("song", song)
            context.startActivity(intent)
        }
    }
}