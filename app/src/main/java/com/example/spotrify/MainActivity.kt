package com.example.spotrify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotrify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val songs = listOf<Song>(
        Song(R.raw.flashing_lights, R.drawable.graduation, "Flashing Lights", "Kanye West"),
        Song(R.raw.self_care, R.drawable.mac_miller_swimming, "Self Care", "Mac Miller"),
        Song(R.raw.creep, R.drawable.pablo_honey_album, "Creep", "Radiohead"),
        Song(R.raw.no_role_modelz, R.drawable.forest_hills_drive, "No Role Modelz", "J. Cole"),
        Song(R.raw.thats_life, R.drawable.frank_sinatra, "That's Life", "Frank Sinatra"),
        Song(R.raw.bound2, R.drawable.yeezus_album, "Bound 2", "Kanye West"),
        Song(R.raw.toxicity, R.drawable.toxicity_image, "Toxicity", "System Of A Down"),
        Song(R.raw.count_me_out, R.drawable.kendrick_album, "Count Me Out", "Kendrick Lamar"),
        Song(R.raw.save_that_shit, R.drawable.come_over_when_u_r_sober, "Save That Shit", "Lil Peep"),
        Song(R.raw.transparent_soul, R.drawable.lately_i_feel_everything, "t r a n s p a r e n t s o u l", "Willow Smith"),
        Song(R.raw.kill_yourself, R.drawable.suicide_album, "Kill Yourself (Part III)", "\$uicideboy\$"),
        Song(R.raw.all_of_the_lights, R.drawable.my_dark_beautiful_dark_twisted_fantasy, "All Of The Lights (feat. Rihanna & Kid Cudi", "Kanye West"),
        Song(R.raw.cigarettte_daydreams, R.drawable.melophobia, "Cigarette Daydreams", "Cage the Elephant"),
        Song(R.raw.chamber_of_reflection, R.drawable.salad_days, "Chamber Of Reflection", "Mac DeMarco")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.songList
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SongAdapter(songs)
    }

}





