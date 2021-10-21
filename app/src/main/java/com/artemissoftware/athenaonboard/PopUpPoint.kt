package com.artemissoftware.athenaonboard

import android.graphics.Point

class PopUpPoint (point: Point, offsetX: Int = 0, offsetY: Int = 0){

    val x: Int = point.x + (offsetX /4)
    val y = point.y + offsetY + (offsetY / 7)

}