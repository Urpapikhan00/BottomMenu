package com.example.tester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tester.fragment.bitfragment
import com.example.tester.fragment.dashboard
import com.example.tester.fragment.profilefragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dashboardFragment=dashboard()
    private val profileFragment=profilefragment()
    private val bitFragment=bitfragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(dashboardFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_Profile -> replaceFragment(profileFragment)
                R.id.ic_bitwallet -> replaceFragment(bitFragment)
                R.id.ic_dashboard-> replaceFragment(dashboardFragment)

        }
         true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}