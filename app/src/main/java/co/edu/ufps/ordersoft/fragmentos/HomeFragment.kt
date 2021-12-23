package co.edu.ufps.ordersoft.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.ufps.ordersoft.Adapter.AdapterCategories
import co.edu.ufps.ordersoft.Adapter.AdapterItems
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.dao.Categorias
import co.edu.ufps.ordersoft.dao.Productos
import co.edu.ufps.ordersoft.entity.Producto
import co.edu.ufps.ordersoft.interfaces.CategoryApi
import co.edu.ufps.ordersoft.interfaces.ProductApi
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private  lateinit var recyclerView: RecyclerView
    private  lateinit var recyclerViewItem: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        val retrofit = Retrofit.Builder().baseUrl("https://order-soft-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrofit.create(CategoryApi::class.java)
        api.getCategorias().enqueue(object: Callback<Categorias>{
            override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
                Log.d("exitoso", "onResponse: {${response.body()}}")
                response.body()?.let { showData(it) }
            }

            override fun onFailure(call: Call<Categorias>, t: Throwable) {
                t.printStackTrace()
            }

        })
//        cargarCategorias()
        recyclerView = view.findViewById(R.id.contenedor_categories)
        val LinearLayout = LinearLayoutManager(context)
        LinearLayout.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = LinearLayout
//        items
        val apiProductos = retrofit.create(ProductApi::class.java)
        apiProductos.getProductosCategoriaUno().enqueue(object: Callback<Productos>{
            override fun onResponse(call: Call<Productos>, response: Response<Productos>) {
                Log.d("exito en productos", "onResponse: {${response.body()}}")
                response.body()?.let { showProducts(it) }
            }

            override fun onFailure(call: Call<Productos>, t: Throwable) {
                t.printStackTrace()
            }

        })
        recyclerViewItem = view.findViewById(R.id.contenedor_items)
        val LinearLayout2 = LinearLayoutManager(context)
        LinearLayout2.orientation = LinearLayoutManager.HORIZONTAL
        recyclerViewItem.layoutManager = LinearLayout2
//        adapterItem = AdapterItems(context, cargarItems(), R.id.card_item)
//        recyclerViewItem.adapter = adapterItem

//        circle indicator
//        val pSnap: PagerSnapHelper = PagerSnapHelper()
//        pSnap.attachToRecyclerView(recyclerViewItem)
//
//        val indicator: CircleIndicator2 = view.findViewById(R.id.indicator)
//        indicator.attachToRecyclerView(recyclerViewItem, pSnap)


        return view
    }

    private fun showProducts(body: Productos) {
        Log.d("productos", "onResponse: {${Gson().toJson(body)}}")
        recyclerViewItem.apply {
            adapter = AdapterItems(context, body,R.id.card_item)
        }
    }

    private fun showData(body: Categorias) {
        Log.d("categorias", "onResponse: {${body}}")
        recyclerView.apply {
            adapter = AdapterCategories(context, body, R.id.card)
        }

    }
//    private fun cargarCategorias(){
//
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl("https://order-soft-api.herokuapp.com/")
//            .addConverterFactory(MoshiConverterFactory()).build()
//        val service = retrofit.create(CategoryApi::class.java)
//        service.getCategorias().enqueue(object : Callback<Categorias>{
//
//            override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
//                val categorias = response.body()
//                Log.i("hola funcione", Gson().toJson(categorias))
//                var gson = GsonBuilder().create()
//                val Model= gson.fromJson(Gson().toJson(categorias), Array<Categorias>::class.java).asList()
//                //Log.i("array", Model.toString())
//                //println(println("${response.body()!!::class.simpleName}"))
//                //println(println("${Gson().toJson(categorias)!!::class.simpleName}"))
//            }
//
//            override fun onFailure(call: Call<Categorias>, t: Throwable) {
//                t.printStackTrace()
//            }
//
//        })
//    }

    private fun cargarItems(): ArrayList<Producto> {
        val productos: ArrayList<Producto> = java.util.ArrayList()
        productos.add(
            Producto(1,"Zinger Burger","R.drawable.grupo_26","12",1,12)
        )
        productos.add(
            Producto(2,"Chicken Burger","R.drawable.checken_burger","15",1,12)
        )
        productos.add(
            Producto(3,"Zinger Burger","R.drawable.grupo_26","12",1,12)
        )
        productos.add(
            Producto(4,"Chicken Burger","R.drawable.checken_burger","15",1,12)
        )
        return productos
    }

//    private fun cargarDatos(): ArrayList<co.edu.ufps.ordersoft.entity.Categoria> {
//        val categorias: ArrayList<co.edu.ufps.ordersoft.entity.Categoria> = java.util.ArrayList()
//        categorias.add(
//            co.edu.ufps.ordersoft.entity.Categoria(1,"Burgers","R.drawable.ic_burger")
//        )
//        categorias.add(
//            co.edu.ufps.ordersoft.entity.Categoria(2,"Pizza","R.drawable.ic_fast_food")
//        )
//        categorias.add(
//            co.edu.ufps.ordersoft.entity.Categoria(3,"Chicken","R.drawable.ic_chicken")
//        )
//        return categorias
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

