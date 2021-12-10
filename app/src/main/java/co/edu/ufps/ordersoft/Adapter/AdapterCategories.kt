package co.edu.ufps.ordersoft.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.entity.Category
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterCategories(var context: Context?, val dataSet: ArrayList<Category>,recurso: Int):
    RecyclerView.Adapter<AdapterCategories.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = dataSet[position].name
        holder.imagen.setImageResource(dataSet[position].imagen)
//        Picasso.get().load(dataSet[position].imagen).into(holder.imagen)
    }

    override fun getItemCount()= dataSet.size

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val imagen: ImageView
        init {
            name = itemView.findViewById(R.id.name)
            imagen = itemView.findViewById(R.id.imagen)
        }
    }

}