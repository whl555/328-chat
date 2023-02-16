package com.whl.a328_chat.utils

import android.content.res.Resources
import android.util.TypedValue

// 属性扩展
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = this.toFloat().dp