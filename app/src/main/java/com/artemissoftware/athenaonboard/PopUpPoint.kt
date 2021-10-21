package com.artemissoftware.athenaonboard

import android.graphics.Point
import android.util.DisplayMetrics

class PopUpPoint (private val point: Point, offsetX: Int = 0, offsetY: Int = 0, displayMetrics: DisplayMetrics){

    private val calculatedOffsetX: Int = (offsetX /4)
    private var calculatedOffsetY =  (offsetY + (offsetY / 7))

    private var firstQuadrant: Boolean
    private var secondQuadrant: Boolean
    private var thirdQuadrant: Boolean
    private var fourthQuadrant: Boolean


    init {

        val xRef = displayMetrics.widthPixels / 2
        val yRef = displayMetrics.heightPixels / 2

        firstQuadrant = (point.x <= xRef && point.y <= yRef)
        secondQuadrant = (point.x <= xRef && point.y >= yRef)
        thirdQuadrant = (point.x >= xRef && point.y >= yRef)
        fourthQuadrant = (point.x >= xRef && point.y <= yRef)
    }

    fun x (): Int {

        var result = 0

        if(firstQuadrant){
             result = point.x + calculatedOffsetX
        }
        else if(secondQuadrant){
            result = point.x + calculatedOffsetX
        }
        else if(thirdQuadrant){
             result = point.x - calculatedOffsetX
        }
        else if(fourthQuadrant){
            result = point.x - calculatedOffsetX
        }

        return result
    }

    fun y (): Int {

        var result = 0

        if(firstQuadrant){
            result = point.y + calculatedOffsetY
        }
        else if(secondQuadrant){
            result = point.y - calculatedOffsetY
        }
        else if(thirdQuadrant){
            result = point.y - calculatedOffsetY
        }
        else if(fourthQuadrant){
            result = point.y + calculatedOffsetY
        }

        return result
    }


    fun updateOffsets(offsetX: Int, offsetY: Int){

        if(firstQuadrant){
            //result = point.x + calculatedOffsetX
        }
        else if(secondQuadrant){
            //result = point.x + calculatedOffsetX
        }
        else if(thirdQuadrant){
            calculatedOffsetY = offsetY
        }
        else if(fourthQuadrant){
            //result = point.x - calculatedOffsetX
        }





    }

}