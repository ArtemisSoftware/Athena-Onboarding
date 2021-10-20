package com.artemissoftware.athenaonboard

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.PopupWindow


class PopUpTutorial {


    @SuppressLint("ClickableViewAccessibility")
    fun showPopupWindow(view: View){

        //Create a View object yourself through inflater
        val inflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = inflater.inflate(R.layout.popup_layout, null)

        //Specify the length and width through constants
        val width = LinearLayout.LayoutParams.MATCH_PARENT
        val height = LinearLayout.LayoutParams.MATCH_PARENT

        //Make Inactive Items Outside Of PopupWindow
        val focusable = true


        //Create a window with our parameters
        val popupWindow = PopupWindow(layout, width, height, focusable)

        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


        //Handler for clicking on the inactive zone of the window


        //Handler for clicking on the inactive zone of the window
        layout.setOnTouchListener { v, event -> //Close the window when clicked
            popupWindow.dismiss()
            true
        }
    }
}