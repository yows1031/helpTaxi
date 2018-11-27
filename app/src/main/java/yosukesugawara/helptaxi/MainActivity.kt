package yosukesugawara.helptaxi

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
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

    //lateinit var prefs : SharedPreferences

    override fun onResume() {
        super.onResume()

        listArrayList = loadArrayList(prefKey)
        Log.d("List1", listArrayList.joinToString())
        listArrayList2 = loadArrayList(prefKey2)
        Log.d("List2", listArrayList2.joinToString())
        list_item.adapter = MyAdapter(this, listArrayList, listArrayList2)

        list_item.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        des.setText(listArrayList.joinToString())
        det.setText(listArrayList2.joinToString())

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
    }

    fun onClick(){
        Log.d(localClassName, "onClick")

        val msgData : String = des.text.toString()
        val msgData2 : String = det.text.toString()

        listArrayList.add(msgData)
        Log.d("List1", listArrayList.joinToString())
        listArrayList2.add(msgData2)
        Log.d("List2", listArrayList2.joinToString())
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
        Log.d("Save", listArrayList.joinToString())
    }

    // リストの読み込み

    fun loadArrayList(key: String) : ArrayList<String> {

        val shardPreferences = this.getPreferences(AppCompatActivity.MODE_PRIVATE)


        val jsonArray = JSONArray(shardPreferences.getString(key, "[]"))

        val arrayList : ArrayList<String> = ArrayList()

        for (i in 0 until jsonArray.length()) {
            arrayList.add(jsonArray.get(i) as String)
        }

        Log.d("Load", arrayList.joinToString())

        return arrayList
    }
//    override fun onItemClick(view: View, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

}


