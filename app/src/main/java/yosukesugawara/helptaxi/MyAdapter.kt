package yosukesugawara.helptaxi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(private val context: Context, private val myDesSet: ArrayList<String>, private val myDetSet: ArrayList<String>
): RecyclerView.Adapter<MyAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.list_row, parent, false)
        val vh: ViewHolder = ViewHolder(mView)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.let {
            it.list_des?.text = myDesSet[position]
            it.list_det?.text = myDetSet[position]
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var list_des: TextView? = itemView.findViewById(R.id.list_des) as? TextView
        var list_det: TextView? = itemView.findViewById(R.id.list_det) as? TextView

        companion object Factory {
            fun create(v: TextView): ViewHolder = ViewHolder(v)
        }
    }

    override fun getItemCount(): Int = myDesSet.size
}