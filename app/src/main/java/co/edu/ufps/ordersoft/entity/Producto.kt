package co.edu.ufps.ordersoft.entity

data class Producto(
    val id:Int,
    val nombre: String,
    val imagen: String,
    val descripcion: String,
    val id_categoria: Int,
    val precio: Int
)
