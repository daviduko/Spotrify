package com.example.spotrify

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.spotrify.databinding.SongItemLayoutBinding

class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = SongItemLayoutBinding.bind(view)

    fun bind(song: Song) {
        binding.albumImage.setImageResource(song.albumImage)
        binding.songTitle.text = song.songTitle
        binding.artistName.text = song.artist
    }
}