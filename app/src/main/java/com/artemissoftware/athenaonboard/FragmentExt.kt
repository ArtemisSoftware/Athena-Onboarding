package com.artemissoftware.athenaonboard

import android.view.View
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment

fun Fragment.addOnWindowFocusChangeListener(callback: (hasFocus: Boolean) -> Unit) =
    view?.viewTreeObserver?.addOnWindowFocusChangeListener(callback)


fun View.addOnWindowFocusChangeListener(callback: () -> Unit){
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            callback.invoke()
            viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    })
}
