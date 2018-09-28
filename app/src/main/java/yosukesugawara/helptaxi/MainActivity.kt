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
        const val DETA_TEXT = "yosukesugawara.helptaxi.TEXTDATA1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next.setOnClickListener {
            val goNext = Intent(this, secondActivity::class.java)
            goNext.putExtra(DEST_TEXT, des.text.toString())
            goNext.putExtra(DETA_TEXT, det.text.toString())
            startActivity(goNext)


        }
    }

}


