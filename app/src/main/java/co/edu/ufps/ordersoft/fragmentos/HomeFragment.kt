package co.edu.ufps.ordersoft.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.ufps.ordersoft.Adapter.AdapterCategories
//import android.widget.ImageView
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.entity.Category

//import com.bumptech.glide.Glide

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
    private lateinit var adapter: AdapterCategories
//    private lateinit var image: ImageView
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
        recyclerView = view.findViewById(R.id.contenedor_categories)
        val LinearLayout = LinearLayoutManager(context)
        LinearLayout.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = LinearLayout
        adapter = AdapterCategories(context, cargarDatos(), R.id.card)
        recyclerView.adapter = adapter

//        image = view.findViewById(R.id.image_profile_bar)
//        var url: String = "https://pbs.twimg.com/media/FFaEtv3XwAQLcdg?format=jpg&name=medium"
//        Glide.with(this).load(url)
//            .placeholder(R.drawable.ic_baseline_account_circle_24)
//            .error(R.drawable.ic_baseline_account_circle_24)
//            .circleCrop()
//            .into(image)
        return view
    }

    private fun cargarDatos(): ArrayList<Category> {
        val categories: ArrayList<Category> = java.util.ArrayList()
        categories.add(
            Category("1","Burgers",R.drawable.ic_burger)
        )
        categories.add(
            Category("2","Pizza",R.drawable.ic_fast_food)
        )
        categories.add(
            Category("3","Chicken",R.drawable.ic_chicken)
        )
        return categories
    }

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