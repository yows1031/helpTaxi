package yosukesugawara.helptaxi

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {


    val prefKey = "prefKey"
    val prefKey2 = "prefKey2"

    companion object {
        const val DEST_TEXT = "yosukesugawara.helptaxi.TEXTDATA"
        const val DETA_TEXT = "yosukesugawara.helptaxi.TEXTDATA1"
    }

    var listArrayList =  ArrayList<String>()
    var listArrayList2 = ArrayList<String>()

    lateinit var prefs : SharedPreferences

    override fun onResume() {
        super.onResume()

        listArrayList = loadArrayList(prefKey)
        listArrayList2 = loadArrayList(prefKey2)

        prefs = getSharedPreferences(prefKey, AppCompatActivity.MODE_PRIVATE)
        prefs = getSharedPreferences(prefKey2, AppCompatActivity.MODE_PRIVATE)
//        val memo : String = prefs.getString(prefKey, "")
//        des.setText(memo)
        des.setText(listArrayList.toString())
        det.setText(listArrayList2.toString())

    }

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

        listArrayList = loadArrayList(prefKey)
        listArrayList2 = loadArrayList(prefKey2)
        list_item.adapter = MyAdapter(this, listArrayList)
        list_item.adapter = MyAdapter(this, listArrayList2)
        list_item.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)



    }

    fun onClick(){

        val msgData : String = des.text.toString()
        val msgData2 : String = det.text.toString()

        listArrayList.add(msgData)
        listArrayList2.add(msgData2)
        saveArrayList(prefKey, listArrayList)
        saveArrayList(prefKey2, listArrayList2)

        list_item.adapter.notifyDataSetChanged()


    }

    // リストの保存
    fun saveArrayList(key: String, listArrayList: ArrayList<String>) {

        val shardPreferences = this.getPreferences(AppCompatActivity.MODE_PRIVATE)
        val shardPrefEditor = shardPreferences.edit()

        val jsonArray = JSONArray(listArrayList)
        shardPrefEditor.putString(key, jsonArray.toString())
        shardPrefEditor.apply()
    }

    // リストの読み込み

    fun loadArrayList(key: String) : ArrayList<String> {

        val shardPreferences = this.getPreferences(AppCompatActivity.MODE_PRIVATE)

        val jsonArray = JSONArray(shardPreferences.getString(key, "[]"));

        val arrayList : ArrayList<String> = ArrayList()

        for (i in 0 until jsonArray.length()) {
            listArrayList.add(jsonArray.get(i) as String)
            listArrayList2.add(jsonArray.get(i) as String)
        }

        return listArrayList
    }
//    override fun onItemClick(view: View, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

}


