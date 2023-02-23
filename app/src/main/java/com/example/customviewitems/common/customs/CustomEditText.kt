package com.example.customviewitems.common.customs

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.*
import androidx.databinding.BindingAdapter
import com.example.customviewitems.R
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

    fun getEditText(): TextInputEditText {
        return findViewById(R.id.textInputEditText)
    }

    fun getLayout(): TextInputLayout {
        return findViewById(R.id.textInputLayout)
    }
}

@BindingAdapter("hint")
fun setCustomHint(editText: CustomEditText, hint: String?) {
    if (hint != null) {
        editText.getEditText().hint = hint
    }
}

@BindingAdapter("endIconMode")
fun setEndIconMode(textInputLayout: CustomEditText, mode: Int) {
    textInputLayout.getLayout().endIconMode = mode
}

@BindingAdapter("text")
fun setText(editText: CustomEditText, text: String?) {
    if (text != null) {
        editText.getEditText().setText(text)
    }
}





