package com.artemissoftware.athenaonboard

import android.app.Activity
import android.util.DisplayMetrics

fun Activity.getDisplayMetrics(): DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)

    return displayMetrics
}
