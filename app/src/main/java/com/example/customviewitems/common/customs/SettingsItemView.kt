package com.example.customviewitems.common.customs

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.annotation.StringRes
import com.example.customviewitems.R
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textview.MaterialTextView
import com.google.android.material.transition.MaterialContainerTransform

class SettingsItemView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val titleTextView: MaterialTextView
    private val descriptionTextView: MaterialTextView
    private val switch: SwitchMaterial

    init {

        val view = inflate(context, R.layout.custom_setting_item, this)
        titleTextView = view.findViewById(R.id.tvSettingTitle)
        descriptionTextView = view.findViewById(R.id.tvSettingDescription)
        switch = view.findViewById(R.id.swSettingSwitch)

        context.obtainStyledAttributes(attrs, R.styleable.SettingsItemView).apply {
            titleTextView.text = getString(R.styleable.SettingsItemView_siw_titleText)
            descriptionTextView.text = getString(R.styleable.SettingsItemView_siw_descriptionText)
            switch.visibility =
                if (getBoolean(R.styleable.SettingsItemView_siw_showSwitch, false)) VISIBLE else GONE
            recycle()
        }
        hideDescriptionViewIfNoContent()
    }

    private fun hideDescriptionViewIfNoContent() {
        descriptionTextView.apply {
            visibility = if (text.isNullOrEmpty()) GONE else VISIBLE
        }
    }

    fun setTitleText(@StringRes resId: Int) {
        titleTextView.setText(resId)
    }

    fun setTitleText(text: String) {
        titleTextView.text = text
    }

    fun setDescriptionText(@StringRes resId: Int) {
        descriptionTextView.setText(resId)
        hideDescriptionViewIfNoContent()
    }

    fun setDescriptionText(text: String) {
        descriptionTextView.text = text
        hideDescriptionViewIfNoContent()
    }

    fun setSwitchEnabled(enabled: Boolean) {
        switch.isChecked = enabled
    }

}