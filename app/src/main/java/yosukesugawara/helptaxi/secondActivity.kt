package yosukesugawara.helptaxi

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class secondActivity : AppCompatActivity() {

    var des1 = findViewById<TextView>(R.id.des1)
    var go = findViewById<ImageButton>(R.id.go)

    var destination = intent.getStringArrayExtra("desti")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        des1.text = destination.toString()

        go.setOnClickListener {
            val thirdgo = Intent(this, thirdActivity::class.java)
            startActivity(thirdgo)
        }



    }
}
