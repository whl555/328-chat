package com.whl.a328_chat.ui

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.whl.a328_chat.R
import com.whl.a328_chat.databinding.FragmentLoginBinding
import com.whl.a328_chat.databinding.FragmentSplashBinding
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment() {

    private val navController by lazy { findNavController() }
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentSplashBinding>(inflater, R.layout.fragment_splash, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val typeface: Typeface =
            Typeface.createFromAsset(activity?.assets, "carbon bl.ttf")
        tv_app_name.typeface = typeface

        Handler().postDelayed(Runnable {
            navController.navigate(R.id.action_splashFragment_to_loginFragment)
        }, 2500)
    }
}