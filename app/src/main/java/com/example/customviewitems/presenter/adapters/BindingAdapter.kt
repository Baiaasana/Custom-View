package com.example.customviewitems.presenter.adapters

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.customviewitems.R

@BindingAdapter("setImage")
fun AppCompatImageView.setImage(url: String?) {
    Glide
        .with(this.context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .centerCrop()
        .into(this)
}
@BindingAdapter("setResource")
fun AppCompatImageView.setResource(image: Int){
    this.setImageResource(image)
}