package co.edu.ufps.ordersoft.dao

import co.edu.ufps.ordersoft.entity.Producto
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class Productos {
    @SerializedName("productos")
    var productos: ArrayList<Producto> = arrayListOf()

    fun Productos(productos: ArrayList<Producto>){
        this.productos = productos
    }

}