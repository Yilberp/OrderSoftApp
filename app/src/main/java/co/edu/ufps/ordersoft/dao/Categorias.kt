package co.edu.ufps.ordersoft.dao

import co.edu.ufps.ordersoft.entity.Categoria
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class Categorias {
    @SerializedName("categorias")
    lateinit var categorias: ArrayList<Categoria>

    fun Categorias(categorias: ArrayList<Categoria>){
        this.categorias = categorias
    }

}