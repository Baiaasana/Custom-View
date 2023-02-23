package com.example.customviewitems.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemModel2(
    val title: String,
    val subTitle: String,
    val image: Int,
) : Parcelable

