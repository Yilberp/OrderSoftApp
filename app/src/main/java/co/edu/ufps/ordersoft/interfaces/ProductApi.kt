package co.edu.ufps.ordersoft.interfaces

import co.edu.ufps.ordersoft.dao.Productos
import co.edu.ufps.ordersoft.dao.Producto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("api/productos/categoria/1")
    fun getProductosCategoriaUno(): Call<Productos>

    @GET("api/productos/{id}")
    fun getProductosPorId(@Path("id") id: String): Call<Producto>
}