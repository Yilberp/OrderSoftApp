package co.edu.ufps.ordersoft.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.dao.Categorias
import com.squareup.picasso.Picasso


class AdapterCategories(var context: Context?, var myList: Categorias, recurso: Int):
    RecyclerView.Adapter<AdapterCategories.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView
        val imagen: ImageView
        val id: TextView
        init {
            id = itemView.findViewById(R.id.id_category)
            title = itemView.findViewById(R.id.name)
            imagen = itemView.findViewById(R.id.imagen)
        }
    }

    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          holder.id.text = myList.categorias[position].id.toString()
          holder.title.text = myList.categorias[position].nombre
          Picasso.get().load(myList.categorias[position].imagen).into(holder.imagen)
    }

    override fun getItemCount(): Int = myList.categorias.size




}