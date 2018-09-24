package yosukesugawara.helptaxi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    val des = findViewById<EditText>(R.id.des)
    val det = findViewById<EditText>(R.id.det)
    val go = findViewById<ImageButton>(R.id.go)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        go.setOnClickListener {
            val destination = des.text.toString()
            val detail = det.text.toString()

            val goSecond = Intent(this, secondActivity::class.java)
            intent.putExtra("desti",destination)
            intent.putExtra("detai",detail)
            startActivity(goSecond)

        }
    }

}


