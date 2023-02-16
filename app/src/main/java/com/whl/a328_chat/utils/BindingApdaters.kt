package com.whl.a328_chat.utils


import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import com.whl.a328_chat.ui.custom_view.MaterialEditText


fun MaterialEditText.loadUse(isUse: Boolean){
    this.useFloatingLabel = isUse
}

@BindingAdapter("android:useFloatingLabelDataBinding")
fun loadUse(view: MaterialEditText, isUse: Boolean?) {
   view.loadUse(isUse!!)
}
