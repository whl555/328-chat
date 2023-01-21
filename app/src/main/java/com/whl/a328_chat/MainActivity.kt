package com.whl.a328_chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.whl.a328_chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        findViewById<Toolbar>(R.id.lar_top_appbar).let {
            setSupportActionBar(it)
            it.setupWithNavController(
                navController,
                AppBarConfiguration(setOf(R.id.splashFragment))
            )
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.let {
                when (destination.id) {
                    R.id.splashFragment,
                    R.id.loginFragment -> {
                        supportActionBar?.hide()
                    }
                    else -> supportActionBar?.show()
                }
            }
        }

        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}