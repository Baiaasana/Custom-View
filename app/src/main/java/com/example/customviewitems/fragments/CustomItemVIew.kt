package com.example.customviewitems.fragments

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customviewitems.R
import com.example.customviewitems.data.ItemModel

class CustomItemVIew(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val tvTitle: AppCompatTextView
    private val tvSubTitle: AppCompatTextView
    private val ivImage: AppCompatImageView

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_item_view, this, true)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvSubTitle = view.findViewById(R.id.tvSubtitle)
        ivImage = view.findViewById(R.id.ivImage)
    }

    fun setData(item: ItemModel){
        tvTitle.text = item.title
        tvSubTitle.text = item.subTitle
        Glide().setImage(item.imageUrl, ivImage)
    }
}