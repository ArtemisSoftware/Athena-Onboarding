package com.artemissoftware.athenaonboard

import android.graphics.Point
import android.util.DisplayMetrics
import android.view.View

class PopUpPoint (val point: Point, offsetX: Int = 0, offsetY: Int = 0, displayMetrics: DisplayMetrics){

    private val calculatedOffsetX: Int = calculateOffsetX(offsetX)
    private var calculatedOffsetY =  calculateOffsetY(offsetY)

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


    private fun calculateOffsetX(offset: Int) : Int{
        return -(offset /4)
    }

    private fun calculateOffsetY(offset: Int) : Int{
        return offset// + (offset / 7)
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
            calculatedOffsetY = calculateOffsetY(offsetY)
        }
        else if(thirdQuadrant){
            calculatedOffsetY = calculateOffsetY(offsetY)
        }
        else if(fourthQuadrant){
            //result = point.x - calculatedOffsetX
        }
    }


    fun arrowTopVisibility(): Int {

        var visibility = View.GONE

        if(firstQuadrant){
            visibility = View.VISIBLE
        }
        else if(secondQuadrant){

        }
        else if(thirdQuadrant){

        }
        else if(fourthQuadrant){

        }

        return visibility
    }

    fun arrowBottomVisibility(): Int{

        var visibility = View.GONE

        if(firstQuadrant){
            visibility = View.GONE
        }
        else if(secondQuadrant){

        }
        else if(thirdQuadrant){

        }
        else if(fourthQuadrant){

        }

        return visibility
    }

}