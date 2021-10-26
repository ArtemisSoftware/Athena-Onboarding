package com.artemissoftware.athenaonboard

import android.app.Activity
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.View
import com.artemissoftware.athenaonboard.tutorial.PopUpPoint

fun Activity.getDisplayMetrics(): DisplayMetrics {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)

    return displayMetrics
}


fun Activity.getPopUpPoint(viewId : Int, displayMetrics: DisplayMetrics): PopUpPoint {

    val location = IntArray(2)
    val view = this.findViewById<View>(viewId) as View

    // Get the x, y location and store it in the location[] array
    // location[0] = x, location[1] = y.

    // Get the x, y location and store it in the location[] array
    // location[0] = x, location[1] = y.
    view.getLocationOnScreen(location)

    //Initialize the Point with x, and y positions
    val point = Point()
    point!!.x = location[0]
    point!!.y = location[1]

    return PopUpPoint(point, view.width, view.height, displayMetrics)
}