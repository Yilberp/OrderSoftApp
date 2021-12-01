package co.edu.ufps.ordersoft.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import co.edu.ufps.ordersoft.R
import co.edu.ufps.ordersoft.fragmentos.*
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var mDrawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var imagen: ImageView
    lateinit var menu: ImageButton
    //    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //UI
        mDrawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        menu = findViewById(R.id.menu_navigation)
//        toolbar = findViewById(R.id.topAppBar)
        getSupportFragmentManager().beginTransaction().add(R.id.content, HomeFragment()).commit()
        setTitle("Home")
//
        //Setup toolbar
//        setSupportActionBar(toolbar)
        menu.setOnClickListener{
            toggle()
        }

//        toolbar.setNavigationOnClickListener{
//            toggle()
//        }
        navigationView.setNavigationItemSelectedListener(this)
        imagen = navigationView.getHeaderView(0).findViewById(R.id.ima_nav_header)
        var url: String = "https://pbs.twimg.com/media/FFaEtv3XwAQLcdg?format=jpg&name=medium"
        Glide.with(this).load(url)
            .placeholder(R.drawable.ic_baseline_account_circle_24)
            .error(R.drawable.ic_baseline_account_circle_24)
            .circleCrop()
            .into(imagen)
    }

    private fun toggle() {
        if (mDrawerLayout.isDrawerOpen(findViewById(R.id.nav_view))) {
            mDrawerLayout.closeDrawers()
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectItemNav(item)
        return true
    }


    private fun selectItemNav(item: MenuItem) {
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        when (item.itemId) {
            R.id.nav_home -> {
                ft.replace(R.id.content, HomeFragment()).commit()
            }
            R.id.nav_profile -> {
                ft.replace(R.id.content, ProfileFragment()).commit()
            }
            R.id.nav_orders -> {
                ft.replace(R.id.content, OrdersFragment()).commit()
            }
            R.id.nav_payment -> {
                ft.replace(R.id.content, PaymentFragment()).commit()
            }
            R.id.nav_address -> {
                ft.replace(R.id.content, AddressFragment()).commit()
            }
            else -> selectItemNav(item)
        }
        setTitle(item.title)
        mDrawerLayout.closeDrawers()
    }
}