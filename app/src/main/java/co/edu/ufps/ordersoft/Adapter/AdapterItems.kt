package co.edu.ufps.ordersoft.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.entity.Item
import java.util.ArrayList

class AdapterItems(var context: Context?, val dataSet: ArrayList<Item>, recurso: Int):
RecyclerView.Adapter<AdapterItems.ItemViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val price: TextView
        val resource: ImageView
        init {
            title = itemView.findViewById(R.id.item_title)
            resource = itemView.findViewById(R.id.imagen_item)
            price = itemView.findViewById(R.id.item_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  AdapterItems.ItemViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.title.text = dataSet[position].title
        holder.price.text = dataSet[position].price.toString()
        holder.resource.setImageResource(dataSet[position].resource)

    }

    override fun getItemCount()= dataSet.size



}