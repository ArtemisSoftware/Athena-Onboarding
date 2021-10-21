package com.artemissoftware.athenaonboard

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.annotation.MainThread
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_show_popup_armory = findViewById<View>(R.id.btn_show_popup_armory) as Button
        val btn_show_popup_library = findViewById<View>(R.id.btn_show_popup_library) as Button
        val btn_show_popup_help = findViewById<View>(R.id.btn_show_popup_help) as Button
        val btn_show_popup_olympus = findViewById<View>(R.id.btn_show_popup_olympus) as Button
        val lolo = this

        btn_show_popup_armory.setOnClickListener {

            val popUpTutorial = PopUpTutorial()
            popUpTutorial.showPopupWindow_v2(it, getCoordinates(R.id.btn_show_popup_armory))

        }

        btn_show_popup_library.setOnClickListener {

            val popUpTutorial = PopUpTutorial()
            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_library))

        }

        btn_show_popup_help.setOnClickListener {

            val popUpTutorial = PopUpTutorial()
            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_help))

        }

        btn_show_popup_olympus.setOnClickListener {

            val popUpTutorial = PopUpTutorial()
            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_olympus))

        }

    }



    private fun getCoordinates(viewId : Int): Point{

        val location = IntArray(2)
        val button = findViewById<View>(viewId) as View

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        button.getLocationOnScreen(location)

        //Initialize the Point with x, and y positions

        //Initialize the Point with x, and y positions
        val point = Point()
        point!!.x = location[0]
        point!!.y = location[1]

        return point
    }


    private fun getPopUpPoint(viewId : Int): PopUpPoint{

        val location = IntArray(2)
        val view = findViewById<View>(viewId) as View

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        view.getLocationOnScreen(location)

        //Initialize the Point with x, and y positions

        //Initialize the Point with x, and y positions
        val point = Point()
        point!!.x = location[0]
        point!!.y = location[1]

        return PopUpPoint(point, view.width, view.height)
    }

}