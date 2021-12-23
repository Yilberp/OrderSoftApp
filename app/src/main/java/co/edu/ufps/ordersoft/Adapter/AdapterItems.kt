package co.edu.ufps.ordersoft.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.dao.Productos
import co.edu.ufps.ordersoft.vistas.ItemDetailActivity
import com.squareup.picasso.Picasso

class AdapterItems(var context: Context?, val dataSet: Productos, recurso: Int):
RecyclerView.Adapter<AdapterItems.ItemViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val price: TextView
        val resource: ImageView
        val context: Context
        val id: TextView
        init {
            id = itemView.findViewById(R.id.id_item)
            context = itemView.context
            title = itemView.findViewById(R.id.item_title)
            resource = itemView.findViewById(R.id.imagen_item)
            price = itemView.findViewById(R.id.item_price)
            itemView.setOnClickListener {
                val intent = Intent(context, ItemDetailActivity::class.java)
                intent.putExtra("id",id.text)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.id.text = dataSet.productos[position].id.toString()
        holder.title.text = dataSet.productos[position].nombre
        holder.price.text = dataSet.productos[position].precio.toString()
        Picasso.get().load(dataSet.productos[position].imagen).into(holder.resource)
    }

    override fun getItemCount()= dataSet.productos.size



}