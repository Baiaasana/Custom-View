package com.example.customviewitems.presenter.fragments.sign_up

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.customviewitems.databinding.FragmentSignUpBinding
import java.util.*

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = signUpViewModel
        binding.btnSignUp.isEnabled = false
        validation()
        listeners()
    }

    private fun listeners() {
        binding.btnSignUp.setOnClickListener {
            signUpViewModel.addUser(binding.etUsername.getEditText().text.toString())
            Toast.makeText(
                context,
                binding.etUsername.getEditText().text.toString(),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSettingsFragment())
        }
    }

    private fun validation() = with(binding) {

        var timer = Timer()
        val delay = 2000L

        etEmail.getEditText().doOnTextChanged { text, _, _, _ ->
            timer.cancel()
            timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    (context as Activity).runOnUiThread {
                        etEmail.getLayout().helperText =
                            signUpViewModel.checkEmail(text.toString().trim())
                        buttonEnable()
                    }
                }
            }, delay)
        }

        etPassword.getEditText().doOnTextChanged { text, _, _, _ ->

            timer.cancel()
            timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    (context as Activity).runOnUiThread {
                        etPassword.getLayout().helperText =
                            signUpViewModel.checkPassword(text.toString())
                        if (etRepeatPassword.getEditText().text!!.isNotEmpty()) {
                            etRepeatPassword.getLayout().helperText =
                                signUpViewModel.checkRepeatPassword(
                                    etRepeatPassword.getEditText().text.toString(), text.toString()
                                )
                        }
                        buttonEnable()
                    }
                }
            }, delay)
        }

        etRepeatPassword.getEditText().doOnTextChanged { text, _, _, _ ->

            timer.cancel()
            timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    (context as Activity).runOnUiThread {
                        etRepeatPassword.getLayout().helperText =
                            signUpViewModel.checkRepeatPassword(
                                text.toString(),
                                etPassword.getEditText().text.toString()
                            )
                        buttonEnable()
                    }
                }
            }, delay)
        }
    }

    private fun buttonEnable() = with(binding) {
        btnSignUp.apply {
            isEnabled =
                (etEmail.getLayout().helperText == null && etPassword.getLayout().helperText == null
                        && etRepeatPassword.getLayout().helperText == null)
            setBackgroundColor(Color.parseColor("#139F9F"))

        }
    }
}