package com.artemissoftware.athenaonboard

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ColorFilter
import android.graphics.Point
import android.graphics.drawable.*
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.updateBounds
import android.graphics.Bitmap

import android.graphics.drawable.BitmapDrawable

import android.graphics.drawable.Drawable
import android.widget.*
import androidx.constraintlayout.widget.ConstraintSet





class PopUpTutorial(private val view: View, private val popUpPoint: PopUpPoint, private val popUpWindowData: PopUpWindowData) {


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

    fun showPopupWindow_v2(view: View, p: Point){
        val popupWidth =  ViewGroup.LayoutParams.WRAP_CONTENT
        val popupHeight =  ViewGroup.LayoutParams.WRAP_CONTENT

        // Inflate the popup_layout.xml
        //val viewGroup = context.findViewById<View>(R.id.popup) as ConstraintLayout
        val layoutInflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = layoutInflater.inflate(R.layout.popup_layout, null)

        // Creating the PopupWindow
        val popup = PopupWindow(view)
        popup.contentView = layout
        popup.width = popupWidth
        popup.height = popupHeight
        popup.isFocusable = true

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        val OFFSET_X = 30
        val OFFSET_Y = 30

        // Clear the default translucent background
        popup.setBackgroundDrawable(BitmapDrawable())

        // Set an elevation value for popup window
        // Call requires API level 21
        if(Build.VERSION.SDK_INT>=21){
            popup.elevation = 15.0f;
        }

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y)

        // Getting a reference to Close button, and close the popup when clicked.
        val close = layout.findViewById<View>(R.id.btn_close) as Button
        close.setOnClickListener {
            popup.dismiss()
        }
    }


    fun showPopupWindow_v3(view: View, popUpPoint: PopUpPoint){

        val popupWidth =  ViewGroup.LayoutParams.WRAP_CONTENT
        val popupHeight =  ViewGroup.LayoutParams.WRAP_CONTENT

        // Inflate the popup_layout.xml
        //val viewGroup = context.findViewById<View>(R.id.popup) as ConstraintLayout
        val layoutInflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = layoutInflater.inflate(R.layout.popup_layout, null)

        // Creating the PopupWindow
        val popup = PopupWindow(view)
        popup.contentView = layout
        popup.width = popupWidth
        popup.height = popupHeight
        popup.isFocusable = true


        popup.getContentView (). measure (0, 0);
        val mPopupWindowHeight = popup.getContentView (). getMeasuredHeight ();
        val mPopupWindowWidth = popup.getContentView (). getMeasuredWidth ();


        popUpPoint.updateOffsets(mPopupWindowWidth, mPopupWindowHeight)


        // Clear the default translucent background
        popup.setBackgroundDrawable(BitmapDrawable())

        // Set an elevation value for popup window
        // Call requires API level 21
        if(Build.VERSION.SDK_INT>=21){
            popup.elevation = 15.0f;
        }

        // Displaying the popup at the specified location, + offsets.
        //popup.showAtLocation(layout, Gravity.NO_GRAVITY, popUpPoint.x(), popUpPoint.y())

        popup.showAtLocation(layout,  Gravity.NO_GRAVITY, popUpPoint.x(), popUpPoint.y())


        // Getting a reference to Close button, and close the popup when clicked.
        val close = layout.findViewById<View>(R.id.btn_close) as Button
        close.setOnClickListener {
            popup.dismiss()
        }
    }



    fun showPopupWindow(popUpPoint: PopUpPoint, view: View, popUpWindowData: PopUpWindowData){

        val popupWidth =  ViewGroup.LayoutParams.WRAP_CONTENT
        val popupHeight =  ViewGroup.LayoutParams.WRAP_CONTENT

        // Inflate the popup_layout.xml
        //val viewGroup = context.findViewById<View>(R.id.popup) as ConstraintLayout
        val layoutInflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = layoutInflater.inflate(popUpWindowData.layout, null)

        (layout.findViewById<View>(R.id.txt_title) as TextView).text = popUpWindowData.title
        (layout.findViewById<View>(R.id.txt_description) as TextView).text = popUpWindowData.description


        // Creating the PopupWindow
        val popup = PopupWindow(view)
        popup.contentView = layout
        popup.width = popupWidth
        popup.height = popupHeight
        popup.isFocusable = true


        popup.getContentView (). measure (0, 0);
        val mPopupWindowHeight = popup.getContentView (). getMeasuredHeight ();
        val mPopupWindowWidth = popup.getContentView (). getMeasuredWidth ();


        popUpPoint.updateOffsets(mPopupWindowWidth, mPopupWindowHeight)


        // Clear the default translucent background
        popup.setBackgroundDrawable(BitmapDrawable())

        // Set an elevation value for popup window
        // Call requires API level 21
        if(Build.VERSION.SDK_INT>=21){
            popup.elevation = 15.0f;
        }

        // Displaying the popup at the specified location, + offsets.
        //popup.showAtLocation(layout, Gravity.NO_GRAVITY, popUpPoint.x(), popUpPoint.y())

        popup.showAtLocation(layout, Gravity.NO_GRAVITY, popUpPoint.x(), popUpPoint.y())

        //Handler for clicking on the inactive zone of the window
        layout.setOnTouchListener { v, event -> //Close the window when clicked
            popup.dismiss()
            true
        }
    }


    fun showPopupWindow(next: () -> Unit){

        val popupWidth =  ViewGroup.LayoutParams.WRAP_CONTENT
        val popupHeight =  ViewGroup.LayoutParams.WRAP_CONTENT

        // Inflate the popup_layout.xml
        //val viewGroup = context.findViewById<View>(R.id.popup) as ConstraintLayout
        val layoutInflater = view.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout: View = layoutInflater.inflate(popUpWindowData.layout, null)

        (layout.findViewById<View>(R.id.txt_title) as TextView).text = popUpWindowData.title
        (layout.findViewById<View>(R.id.txt_description) as TextView).text = popUpWindowData.description

        val contraintLayer = (layout.findViewById<View>(R.id.constraint_root) as ConstraintLayout)

        val arrow = (layout.findViewById<View>(R.id.img_arrow) as ImageView)

        val set = ConstraintSet()
        set.clone(contraintLayer)
        //set.constrainWidth(arrow.getId(), ConstraintSet.MATCH_CONSTRAINT)

        set.connect(arrow.getId(), ConstraintSet.START,  ConstraintSet.PARENT_ID,  ConstraintSet.START,(popUpPoint.point.x/ 2)  - 8 + 12 )
        set.setMargin(arrow.getId(), ConstraintSet.START, (popUpPoint.point.x/ 2) - 8 + 12 );

        set.applyTo(contraintLayer);
        contraintLayer.invalidate();


//        val res = view.context.getResources();
//        val drawable = res.getDrawable(R.drawable.arrow_box_top_left) as LayerDrawable
//        val id = drawable.getId(1)
//        val layer = drawable.findDrawableByLayerId(id)
//



//


//
//
//        var layerDrawable: LayerDrawable = lolo.getBackground() as LayerDrawable
////        (layerDrawable.findDrawableByLayerId(layerDrawable.getId(1)) as RotateDrawable).updateBounds(left = 188)
//        val ll = RotateDrawable()
//
//        ll.toDegrees = 90f
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            layerDrawable.addLayer(ll)
//        }
//        lolo.background = ll
//
////        var lolo_2 = layerDrawable.findDrawableByLayerId(layerDrawable.getId(1)) as RotateDrawable
////        lolo_2.updateBounds(left = 8, right = 0, bottom = 0, top = -12)
////
//////
//////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//////            layerDrawable.setDrawable(1, lolo_2)
//////        }
////
////        lolo.background = lolo_2
//
////        val layerDrawable = resources.getDrawable(R.drawable.arrow_box_top_left) as LayerDrawable
////        val gradientDrawable = layerDrawable.findDrawableByLayerId(R.id.start_point) as GradientDrawable
//


        // Creating the PopupWindow
        val popup = PopupWindow(view)
        popup.contentView = layout
        popup.width = popupWidth
        popup.height = popupHeight
        popup.isFocusable = true


        popup.getContentView (). measure (0, 0);
        val mPopupWindowHeight = popup.getContentView (). getMeasuredHeight ();
        val mPopupWindowWidth = popup.getContentView (). getMeasuredWidth ();


        popUpPoint.updateOffsets(mPopupWindowWidth, mPopupWindowHeight)


        // Clear the default translucent background
        popup.setBackgroundDrawable(BitmapDrawable())

        // Set an elevation value for popup window
        // Call requires API level 21
        if(Build.VERSION.SDK_INT>=21){
            popup.elevation = 15.0f;
        }

        // Displaying the popup at the specified location, + offsets.
        //popup.showAtLocation(layout, Gravity.NO_GRAVITY, popUpPoint.x(), popUpPoint.y())

        popup.showAtLocation(layout, Gravity.NO_GRAVITY, popUpPoint.x(), popUpPoint.y())

        //Handler for clicking on the inactive zone of the window
        layout.setOnTouchListener { v, event -> //Close the window when clicked
            popup.dismiss()
            next()
            true
        }
    }

}