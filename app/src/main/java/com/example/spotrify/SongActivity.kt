package com.example.spotrify

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.spotrify.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer;
    private lateinit var binding: ActivitySongBinding
    private lateinit var song: Song
    private var pausedPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer()

        song = intent.getSerializableExtra("song") as Song

        binding.albumArt.setImageResource(song.albumImage)
        binding.songTitle.text = song.songTitle
        binding.artistName.text = song.artist

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.playButton.setOnClickListener { playSong() }
        binding.pauseButton.setOnClickListener { pauseSong() }
        binding.stopButton.setOnClickListener { stopSong() }
        binding.playbackSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun playSong(){
        if (!mediaPlayer.isPlaying) {
            if (pausedPosition == 0) {
                mediaPlayer = MediaPlayer.create(this, song.id)
                mediaPlayer.start()
            } else {
                mediaPlayer.start()
            }
            binding.playbackSeekBar.max = mediaPlayer.duration
            updateSeekBar()
        }
    }

    private fun updateSeekBar(){
        binding.playbackSeekBar.progress = mediaPlayer.currentPosition
        if (mediaPlayer.isPlaying) {
            val runnable = Runnable { updateSeekBar() }
            binding.playbackSeekBar.postDelayed(runnable, 1000)
        }
    }

    private fun pauseSong() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            pausedPosition = mediaPlayer.currentPosition
        }
    }

    private fun stopSong() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
            mediaPlayer = MediaPlayer()
            pausedPosition = 0
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
        pausedPosition = 0
    }

    /*override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit);
    }*/

    /*override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit);
    }*/
}