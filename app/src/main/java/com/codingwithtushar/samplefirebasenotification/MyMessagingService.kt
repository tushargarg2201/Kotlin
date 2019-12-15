package com.codingwithtushar.samplefirebasenotification

import android.app.Notification
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.codingwithtushar.samplefirebasenotification.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyMessagingService : FirebaseMessagingService() {


    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("MyMessageService", "MyMessaging Servie message received")

        showNotification(message)
    }

    private fun showNotification(message: RemoteMessage) {
        val  builder = NotificationCompat.Builder(this, "MyNotifications")
            .setContentTitle(message.notification?.title)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText(message.notification?.body)

        val manager = NotificationManagerCompat.from(this)
        manager.notify(999, builder.build())
    }
}