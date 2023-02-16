package com.whl.a328_chat.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.whl.a328_chat.R
import com.whl.a328_chat.databinding.ActivityHomeScreenBinding
import com.whl.a328_chat.databinding.ActivityMainBinding

class HomeScreenActivity : AppCompatActivity() {

    private val navController by lazy {
        Navigation.findNavController(this, R.id.splashFragment)
    }
    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)
    }

    
}