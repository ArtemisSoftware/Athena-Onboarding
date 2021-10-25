package com.artemissoftware.athenaonboard

import android.graphics.Point
import android.util.DisplayMetrics
import android.view.View

class PopUpPoint (val point: Point, offsetX: Int = 0, val offsetY: Int = 0, val displayMetrics: DisplayMetrics){

    private val calculatedOffsetX: Int = calculateOffsetX(offsetX)
    private var calculatedOffsetY =  calculateOffsetY(offsetY)

    private var firstQuadrant: Boolean
    private var secondQuadrant: Boolean
    private var thirdQuadrant: Boolean
    private var fourthQuadrant: Boolean


    var _x = 0
    var _y = 0
    var _arrowTopVisibility = View.GONE
    var _arrowTopRightVisibility = View.GONE
    var _arrowBottomVisibility = View.GONE
    var _arrowBottomRightVisibility = View.GONE
    var _arrowOffset = 0




    init {

        val xRef = displayMetrics.widthPixels / 2
        val yRef = displayMetrics.heightPixels / 2

        //quadrant

        firstQuadrant = (point.x <= xRef && point.y <= yRef)
        secondQuadrant = (point.x <= xRef && point.y >= yRef)
        thirdQuadrant = (point.x >= xRef && point.y >= yRef)
        fourthQuadrant = (point.x >= xRef && point.y <= yRef)

        //arrow visibility

        if(firstQuadrant){
            _arrowTopVisibility = View.VISIBLE
        }
        else if(secondQuadrant){
            _arrowBottomVisibility = View.VISIBLE
        }
        else if(thirdQuadrant){
            _arrowBottomRightVisibility = View.VISIBLE
        }
        else if(fourthQuadrant){
            _arrowTopRightVisibility = View.VISIBLE
        }


        //arrow offset

        if(firstQuadrant){
            _arrowOffset = (point.x/ 2)  + 4
        }
        else if(secondQuadrant){
            _arrowOffset = (point.x/ 2)  + 4
        }
        else if(thirdQuadrant){
            _arrowOffset = (offsetX/ 2)  + 4
        }
        else if(fourthQuadrant){
            _arrowOffset = (offsetX/ 2)  + 4
        }


    }


    private fun calculateOffsetX(offset: Int) : Int{
        return -(offset /4)
    }

    private fun calculateOffsetY(offset: Int) : Int{
        return if(secondQuadrant || thirdQuadrant){
            offset
        }
        else {
            offset
        }// + (offset / 7)
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
            result = (point.y/displayMetrics.density).toInt() + calculatedOffsetY  //point.y - (calculatedOffsetY/displayMetrics.density).toInt()// - 100
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

        }
        else if(secondQuadrant){
            calculatedOffsetY = calculateOffsetY(offsetY)
        }
        else if(thirdQuadrant){
            calculatedOffsetY = calculateOffsetY(offsetY)
        }
        else if(fourthQuadrant){

        }
    }





}