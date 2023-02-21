package com.example.customviewitems.presenter.fragments.sign_up

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.customviewitems.common.*

class SignUpViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username = _username.value

     fun addUser(username: String){
        _username.postValue(username)
    }
    fun checkEmail(email: String): String? {
        return isValidEmail(email)
    }

    fun checkPassword(password: String): String? {
        return isValidPassword(password)
    }

    fun checkRepeatPassword(repeatPassword: String, password: String): String? {
        return isValidRepeatPassword(repeatPassword, password)
    }



}