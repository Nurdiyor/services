package uz.micro.star.services1

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
//https://www.geeksforgeeks.org/services-in-android-with-example/
//https://www.vogella.com/tutorials/AndroidServices/article.html
//https://www.youtube.com/watch?v=bA7v1Ubjlzw
//https://www.raywenderlich.com/20123726-android-services-getting-started
//https://github.com/pavan5208/android_sample_foreground_service
//https://github.com/jeetdholakia/ServicesAndBackgroundTasks
class MusicService : Service() {

    // declaring object of MediaPlayer
    private lateinit var player: MediaPlayer

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        // creating a media player which
        // will play the audio of Default
        // ringtone in android device
        intent.extras?.let {
            val name = it.getString("MUSIC_NAME")
            player = MediaPlayer.create(this, resources.getIdentifier(name, "raw", packageName))
            // providing the boolean
            // value as true to play
            // the audio on loop
            player.isLooping = true
            // starting the process
            player.start()
        }
        // returns the status
        // of the program
        return START_STICKY
    }

    // execution of the service will
    // stop on calling this method
    override fun onDestroy() {
        super.onDestroy()

        // stopping the process
        player.stop()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}