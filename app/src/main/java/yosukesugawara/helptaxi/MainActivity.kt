package yosukesugawara.helptaxi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    companion object {
        const val DEST_TEXT = "yosukesugawara.helptaxi.TEXTDATA"
        const val DETA_TEXT = "yosukesugawara.helptaxi.TEXTDATA1"
    }

    val listArrayList = arrayListOf<String>("A", "B")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next.setOnClickListener {
            val goNext = Intent(this, secondActivity::class.java)
            goNext.putExtra(DEST_TEXT, des.text.toString())
            goNext.putExtra(DETA_TEXT, det.text.toString())
            startActivity(goNext)
            onClick()

        }

        list_item.adapter = MyAdapter(this, listArrayList)
        list_item.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    fun onClick(){
//        listArrayList.add(des.text.toString())
        listArrayList.add("testC")
    }
//    override fun onItemClick(view: View, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

}


