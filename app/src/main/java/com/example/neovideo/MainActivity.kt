package com.example.neovideo

import android.media.AsyncPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import com.example.neovideo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoView = binding.vistaVideo

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //val onlineUri = Uri.parse("https://www.youtube.com/watch?v=6TYkDy54q4E")
        val offlineUri = Uri.parse("android.resource://$packageName/${R.raw.hola}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(offlineUri)
        videoView.requestFocus()

        with(binding){
            btnPlay.setOnClickListener {
                videoView.start()
            }

            btnPause.setOnClickListener {
                videoView.pause()
            }
        }
    }
}