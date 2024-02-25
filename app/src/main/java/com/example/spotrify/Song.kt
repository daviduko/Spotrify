package com.example.spotrify
import java.io.Serializable

data class Song(
    val id: Int,
    val albumImage: Int,
    val songTitle: String,
    val artist: String,
) : Serializable