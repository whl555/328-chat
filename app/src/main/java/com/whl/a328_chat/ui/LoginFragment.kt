package com.whl.a328_chat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.whl.a328_chat.R
import com.whl.a328_chat.databinding.FragmentLoginBinding
import com.whl.a328_chat.viewmodel.LoginViewModel

class LoginFragment : BaseFragment() {

    private val navController by lazy { findNavController() }
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignIn.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_splashFragment)
        }
    }
}
