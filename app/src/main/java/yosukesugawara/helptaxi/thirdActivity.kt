package yosukesugawara.helptaxi

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class thirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var des2 = findViewById<TextView>(R.id.des2)
        var det1 = findViewById<TextView>(R.id.det1)
        var gMapIcon = findViewById<ImageButton>(R.id.gmap)
        var menu = findViewById<ImageButton>(R.id.menu)

        var destination = intent.getStringArrayExtra("desti")
        var detail = intent.getStringArrayExtra("detai")

        des2.text = destination.toString()
        det1.text = detail.toString()

        menu.setOnClickListener {
            var menuBack = Intent(this, MainActivity::class.java)
            startActivity(menuBack)

        }
    }
}
