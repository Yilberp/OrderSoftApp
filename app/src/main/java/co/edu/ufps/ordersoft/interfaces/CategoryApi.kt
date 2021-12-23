package co.edu.ufps.ordersoft.interfaces



import co.edu.ufps.ordersoft.dao.Categorias
import retrofit2.Call
import retrofit2.http.GET

interface CategoryApi {
    @GET("api/categorias")
    fun getCategorias(): Call<Categorias>
}