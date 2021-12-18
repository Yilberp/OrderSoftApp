package co.edu.ufps.ordersoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import co.edu.ufps.ordersoft.vistas.HomeActivity
import co.edu.ufps.ordersoft.vistas.MyAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var fb: FloatingActionButton
    lateinit var tw: FloatingActionButton
    lateinit var g: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)
        fb = findViewById(R.id.btn_register_fb)
        tw = findViewById(R.id.btn_register_tw)
        g = findViewById(R.id.btn_register_g)
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
    override fun onBackPressed() {
        val fm: FragmentManager = supportFragmentManager
        if (fm.backStackEntryCount == 0){
            super.onBackPressed()
        }else if (fm.backStackEntryCount == 1){
            moveTaskToBack(false)
        }else{
            fm.popBackStack()
        }
    }
}
