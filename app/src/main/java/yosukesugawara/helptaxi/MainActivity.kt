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

    companion object {
        const val DEST_TEXT = "yosukesugawara.helptaxi.TEXTDATA"
        const val DETA_TEXT = "yosukesugawara.helptaxi.TEXTDATA1"
    }

//    val listArrayList = arrayListOf<String>("A", "B")
    var listArrayList =  ArrayList<String>()

    lateinit var prefs : SharedPreferences

    override fun onResume() {
        super.onResume()

        listArrayList = loadArrayList(prefKey)

        prefs = getSharedPreferences(prefKey, AppCompatActivity.MODE_PRIVATE)
//        val memo : String = prefs.getString(prefKey, "")
//        des.setText(memo)
        des.setText(listArrayList.toString())

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

//        test.setOnClickListener {
//            onClick()
//        }

        listArrayList = loadArrayList(prefKey)
        list_item.adapter = MyAdapter(this, listArrayList)
        list_item.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)





    }

    fun onClick(){

        val msgData : String = des.text.toString()
//        val e : SharedPreferences.Editor = prefs.edit()
//        e.putString(prefKey , msgData)
//        e.apply()

        listArrayList.add(msgData)
//        listArrayList.MyAdapter.clear();
//        MyAdapter.addAll(listArrayList);

        saveArrayList(prefKey, listArrayList)

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
        }

        return listArrayList
    }
//    override fun onItemClick(view: View, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

}


