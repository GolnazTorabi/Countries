package com.golnaz.countries.utils.bindingAdapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.golnaz.countries.R
import com.squareup.picasso.Picasso

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
fun ImageView.LoadImageUrl(imageUrl: String?, placeholder: Drawable?) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(placeholder ?: resources.getDrawable(R.drawable.app_icon))
        .error(placeholder ?: resources.getDrawable(R.drawable.app_icon))
        .into(this)
}