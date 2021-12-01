package co.edu.ufps.ordersoft.vistas

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import co.edu.ufps.ordersoft.fragmentos.LogInFragment
import co.edu.ufps.ordersoft.fragmentos.SignUpFragment

class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    val totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                LogInFragment()
            }
            1 -> {
                SignUpFragment()
            }
            else -> getItem(position)
        }
    }
}