package yosukesugawara.helptaxi

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class secondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var des1 = findViewById<TextView>(R.id.des1)
        var go = findViewById<ImageButton>(R.id.go)
        var back = findViewById<ImageButton>(R.id.back)

        var destination = intent.getStringArrayExtra("desti")

        des1.text(destination)

        go.setOnClickListener {
            var thirdGo = Intent(this, thirdActivity::class.java)
            startActivity(thirdGo)
        }

        back.setOnClickListener {
            var mainBack = Intent(this, MainActivity::class.java)
            startActivity(mainBack)
        }



    }
}
