package com.artemissoftware.athenaonboard.tutorial

import android.app.Activity
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.View
import com.labo.kaji.relativepopupwindow.RelativePopupWindow

class PopupWindowData(val anchor: View, val layout: Int, val title: String, val description: String,

                      val vertPos: Int, val horizPos: Int, val offsetX: Int = 0, val offsetY: Int = 0, val fitInScreen: Boolean = true,
                      val displayMetrics: DisplayMetrics, private var id: Int = 0,
                      val arrowOffsetX: Int = 0, val boxPaddingRight: Int = 0, val boxPaddingLeft: Int = 0){


    var firstQuadrant: Boolean = false
    var secondQuadrant: Boolean = false
    var thirdQuadrant: Boolean = false
    var fourthQuadrant: Boolean = false

    var _arrowTopVisibility = View.GONE
    var _arrowTopRightVisibility = View.GONE
    var _arrowBottomVisibility = View.GONE
    var _arrowBottomRightVisibility = View.GONE
    var _arrowOffset = 0

    init {
        id = anchor.id



        val location = IntArray(2)
        anchor.getLocationOnScreen(location)

        //Initialize the Point with x, and y positions
        val point = Point()
        point!!.x = location[0]
        point!!.y = location[1]




        val xRef = displayMetrics.widthPixels / displayMetrics.density / 2
        val yRef = displayMetrics.heightPixels / displayMetrics.density /  2

        //quadrant

        firstQuadrant = (point.x / 2 <= xRef && point.y /2 <= yRef)
        secondQuadrant = (point.x / 2 <= xRef && point.y / 2 >= yRef)
        thirdQuadrant = (point.x / 2 >= xRef && point.y / 2 >= yRef)
        fourthQuadrant = (point.x /2 >= xRef && point.y <= yRef)


        //arrow visibility

        if(vertPos == RelativePopupWindow.VerticalPosition.BELOW){

            if(horizPos == RelativePopupWindow.HorizontalPosition.RIGHT){
                _arrowTopRightVisibility = View.VISIBLE
                _arrowOffset = 20 + arrowOffsetX//16
            }
            else {
                _arrowTopVisibility = View.VISIBLE
                _arrowOffset = (point.x / 2) + 68 + arrowOffsetX//4
            }
        }

        if(vertPos == RelativePopupWindow.VerticalPosition.ABOVE){

            if(horizPos == RelativePopupWindow.HorizontalPosition.RIGHT || horizPos == RelativePopupWindow.HorizontalPosition.ALIGN_RIGHT){
                _arrowBottomRightVisibility = View.VISIBLE
                _arrowOffset = 20 + arrowOffsetX//16
            }
            else {
                _arrowBottomVisibility = View.VISIBLE
                _arrowOffset = (point.x / 2) + 68// + arrowOffsetX
            }

        }


//        if(firstQuadrant){
//            _arrowTopVisibility = View.VISIBLE
//        }
//        else if(secondQuadrant){
//            _arrowBottomVisibility = View.VISIBLE
//        }
//        else if(thirdQuadrant){
//            _arrowBottomRightVisibility = View.VISIBLE
//        }
//        else if(fourthQuadrant){
//            _arrowTopRightVisibility = View.VISIBLE
//        }


//        if(firstQuadrant){
//            _arrowOffset = (point.x/ 2)  + 4
//        }
//        else if(secondQuadrant){
//            _arrowOffset = (point.x/ 2)  + 4
//        }
//        else if(thirdQuadrant){
//            _arrowOffset = (offsetX/ 2)  + 4
//        }
//        else if(fourthQuadrant){
//            _arrowOffset = (offsetX/ 2)  + 4
//        }


    }



}