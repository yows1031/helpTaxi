package yosukesugawara.helptaxi

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_third.*

class thirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE


        var destination = intent.getStringExtra("desti")
        var detail = intent.getStringExtra("detai")

        des2.text = destination
        det1.text = detail

        menu.setOnClickListener {
            var menuBack = Intent(this, MainActivity::class.java)
            startActivity(menuBack)

        }
    }
}
