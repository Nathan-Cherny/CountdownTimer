package edu.temple.countdowntimer

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

val KEYAWESOME = "woah"
class CountdownAwesomeService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.run{
            getIntExtra(KEYAWESOME, 10).let{ startValue ->
                CoroutineScope(Dispatchers.Default).launch{
                    var startVal = startValue
                    while(startVal  > 0){
                        Log.d("countdown", startVal .toString())
                        startVal  -= 1
                        delay(1000.milliseconds)
                    }
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }
}