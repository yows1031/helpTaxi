package yosukesugawara.helptaxi

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

class secondActivity : AppCompatActivity() {

    companion object {
        const val DEST_TEXT = "yosukesugawara.helptaxi.TEXTDATA"
        const val DETA_TEXT = "yosukesugawara.helptaxi.TEXTDATA1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE


        val dest1 = intent.getStringExtra(MainActivity.DEST_TEXT)
        val deta1 = intent.getStringExtra(MainActivity.DETA_TEXT)

        des1.text = dest1

        next2.setOnClickListener {
            val goNextThird = Intent(this, thirdActivity::class.java)
            goNextThird.putExtra(DEST_TEXT, dest1)
            goNextThird.putExtra(DETA_TEXT, deta1)
            startActivity(goNextThird)
        }

        back1.setOnClickListener {
            val mainBack = Intent(this, MainActivity::class.java)
            startActivity(mainBack)
        }



    }
}
