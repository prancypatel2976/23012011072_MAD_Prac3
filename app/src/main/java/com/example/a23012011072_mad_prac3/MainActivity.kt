package com.example.a23012011072_mad_prac3


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        findViewById<Button>(R.id.weburlbutton).setOnClickListener {
            Intent(
                Intent.ACTION_VIEW,
                findViewById<EditText>(R.id.weburledittextview).text.toString().toUri()
            ).also {
                startActivity(it)
            }
        }

        findViewById<Button>(R.id.phonenobutton).setOnClickListener {
            Intent(
                Intent.ACTION_DIAL,
                "tel:${findViewById<EditText>(R.id.phonenoedittextView).text}".toUri()
            ).also {
                startActivity(it)
            }
        }

        findViewById<Button>(R.id.calllogbutton).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("content://call_log")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.gallerybutton).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = "image/*"
            startActivity(intent)
        }

        findViewById<Button>(R.id.camerabutton).setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {startActivity(it)}
        }

        findViewById<Button>(R.id.alarmbutton).setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }

        findViewById<Button>(R.id.loginbutton).setOnClickListener {
            Intent(this, RegisterActivity::class.java).putExtra("username","username").putExtra("password","password").putExtra("phone no","phone no").also { startActivity(it) }
        }
    }
}