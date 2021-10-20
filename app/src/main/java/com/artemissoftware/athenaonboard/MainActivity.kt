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

    //The "x" and "y" position of the "Show Button" on screen.
    var p: Point? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_show_popup_armory = findViewById<View>(R.id.btn_show_popup_armory) as Button
        val lolo = this

        btn_show_popup_armory.setOnClickListener {

            //Open popup window
            if (p != null)
                showPopup(lolo, p!!);

        }

    }


    // Get the x and y position after the button is draw on screen
// (It's important to note that we can't get the position in the onCreate(),
// because at that stage most probably the view isn't drawn yet, so it will return (0, 0))

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        val location = IntArray(2)
        val button = findViewById<View>(R.id.btn_show_popup_armory) as Button

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        button.getLocationOnScreen(location)

        //Initialize the Point with x, and y positions

        //Initialize the Point with x, and y positions
        p = Point()
        p!!.x = location[0]
        p!!.y = location[1]
    }

    // The method that displays the popup.
    private fun showPopup(context: Activity, p: Point) {
        val popupWidth =  ViewGroup.LayoutParams.WRAP_CONTENT//200
        val popupHeight =  ViewGroup.LayoutParams.WRAP_CONTENT//150

        // Inflate the popup_layout.xml
        //val viewGroup = context.findViewById<View>(R.id.popup) as ConstraintLayout
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = layoutInflater.inflate(R.layout.popup_layout, null)

        // Creating the PopupWindow
        val popup = PopupWindow(context)
        popup.contentView = layout
        popup.width = popupWidth
        popup.height = popupHeight
        popup.isFocusable = true

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        val OFFSET_X = 30
        val OFFSET_Y = 30

        // Clear the default translucent background
        popup.setBackgroundDrawable(BitmapDrawable())

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y)

        // Getting a reference to Close button, and close the popup when clicked.
        val close = layout.findViewById<View>(R.id.btn_close) as Button
        close.setOnClickListener {
            popup.dismiss()
        }
    }


}