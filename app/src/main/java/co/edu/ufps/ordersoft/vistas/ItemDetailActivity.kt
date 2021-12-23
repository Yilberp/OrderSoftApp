package co.edu.ufps.ordersoft.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.dao.Producto
import co.edu.ufps.ordersoft.interfaces.ProductApi
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemDetailActivity : AppCompatActivity() {
    private lateinit var btnBack: ImageButton
    private lateinit var titleItem: TextView
    private lateinit var price: TextView
    private lateinit var desc: TextView
    private lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        titleItem = findViewById(R.id.title_item)
        price = findViewById(R.id.item_price_detail)
        desc = findViewById(R.id.item_desc)
        image = findViewById(R.id.item_image)
        var id: String = "1"
        val extras: Bundle? = intent.extras
        if (extras != null){
            id = extras.getString("id").toString()
            Log.d("id parametro", id)
        }
        val retrofit = Retrofit.Builder().baseUrl("https://order-soft-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrofit.create(ProductApi::class.java)
        api.getProductosPorId(id).enqueue(object: Callback<Producto>{
            override fun onResponse(call: Call<Producto>, response: Response<Producto>) {
                Log.d("id", "onResponse: {${Gson().toJson(response.body())}}")
                titleItem.text = response.body()?.producto?.nombre?.replace(" ","\n")
                price.text = response.body()?.producto?.precio.toString()
                desc.text = response.body()?.producto?.descripcion
                Picasso.get().load(response.body()?.producto?.imagen).into(image)
            }

            override fun onFailure(call: Call<Producto>, t: Throwable) {
                t.printStackTrace()
            }

        })

        btnBack = findViewById(R.id.btn_back_detail)
        btnBack.setOnClickListener {
           this.onBackPressed()
            finish()
        }
    }
}