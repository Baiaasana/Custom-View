package com.example.customviewitems.presenter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.customviewitems.R
import com.example.customviewitems.data.ItemModel
import com.example.customviewitems.common.Glide

class CustomViewAdapter(private val context: Context, private val list: List<ItemModel>) :
    ArrayAdapter<ItemModel>(context, R.layout.custom_item_view) {

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_item_view, null)

// Activity
//        val inflater = context.layoutInflater
//        val view = inflater.inflate(R.layout.custom_item_view, null)

        val image = view.findViewById<AppCompatImageView>(R.id.ivImage)
        val title = view.findViewById<AppCompatTextView>(R.id.tvTitle)
        val subTitle = view.findViewById<AppCompatTextView>(R.id.tvSubtitle)

        title.text = list[position].title
        subTitle.text = list[position].subTitle
        Glide().setImage(list[position].imageUrl, image)

        return view

    }

//    private val tvTitle: AppCompatTextView
//    private val tvSubTitle: AppCompatTextView
//    private val ivImage: AppCompatImageView
//
//    init {
//        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val view = inflater.inflate(R.layout.custom_item_view, this, true)
//        tvTitle = view.findViewById(R.id.tvTitle)
//        tvSubTitle = view.findViewById(R.id.tvSubtitle)
//        ivImage = view.findViewById(R.id.ivImage)
//    }
//
//    fun setData(item: ItemModel) {
//        tvTitle.text = item.title
//        tvSubTitle.text = item.subTitle
//        Glide().setImage(item.imageUrl, ivImage)
//    }
}