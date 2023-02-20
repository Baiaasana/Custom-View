package com.example.customviewitems.common.customs

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.*
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.customviewitems.R
import com.example.customviewitems.common.checkEmail
import com.example.customviewitems.common.checkRepeatEmail
import com.example.customviewitems.common.isValidPassword
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@SuppressLint("MissingInflatedId")
class CustomEditText(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val textInputLayout: TextInputLayout
    private val editText: TextInputEditText

    init {
        val view = inflate(context, R.layout.custom_edit_text, this)
        textInputLayout = view.findViewById(R.id.textInputLayout)
        editText = view.findViewById(R.id.textInputEditText)
    }

    fun getEditText():TextInputEditText
    {
        return findViewById(R.id.textInputEditText)
    }

    fun setHint(hint: String){
        editText.hint = hint
    }

    fun getText(): String{
        return textInputLayout.editText.toString()
    }

     fun checkEmail() {
        editText.doOnTextChanged { text, _, _, _ ->
            textInputLayout.helperText = checkEmail(text.toString())
        }
    }

    fun checkPassword() {
        editText.doOnTextChanged { text, _, _, _ ->
            textInputLayout.helperText = isValidPassword(text.toString().trim())
        }
    }

    fun checkRepeatPassword(password: String){
        editText.doOnTextChanged { text, _, _, _ ->
            textInputLayout.helperText = checkRepeatEmail(text.toString().trim() ,password.trim())
        }
    }

}

@BindingAdapter("hint")
fun setCustomHint(editText: CustomEditText,hint: String?) {
    if (hint != null) {
        editText.setHint(hint)
    }
}

@BindingAdapter("text")
fun getText(editText: CustomEditText) : String {
    return editText.getText()
}