package com.example.customviewitems.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemModel(
    val title: String,
    val subTitle: String,
    val imageUrl: String,
) : Parcelable
