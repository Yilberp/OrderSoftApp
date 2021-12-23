package co.edu.ufps.ordersoft.dao

import co.edu.ufps.ordersoft.entity.Producto
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class Producto {
    @SerializedName("producto")
    lateinit var producto: Producto

    fun Producto(producto: Producto){
        this.producto = producto
    }
}