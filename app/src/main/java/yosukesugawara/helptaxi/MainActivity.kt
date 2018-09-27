package yosukesugawara.helptaxi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val DEST_TEXT = "yosukesugawara.helptaxi.TEXTDATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        go.setOnClickListener {
            val goSecond = Intent(this, secondActivity::class.java)
            goSecond.putExtra(DEST_TEXT, des.text.toString())

            startActivity(goSecond)

        }
    }

}


