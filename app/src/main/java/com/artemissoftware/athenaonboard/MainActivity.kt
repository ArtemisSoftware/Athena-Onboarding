package com.artemissoftware.athenaonboard

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.annotation.MainThread
import androidx.constraintlayout.widget.ConstraintLayout
import android.util.DisplayMetrics
import android.view.*
import android.widget.ImageView
import android.R.color

import android.graphics.drawable.GradientDrawable

import android.graphics.drawable.LayerDrawable





class MainActivity : AppCompatActivity() {


    lateinit var btn_show_popup_armory: View
    var popupTutorialManager: PopupTutorialManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
//
//        val btn_show_popup_help = findViewById<View>(R.id.btn_show_popup_help) as Button
//        val btn_show_popup_olympus = findViewById<View>(R.id.btn_show_popup_olympus) as Button
//
//
//        val img_show_popup_athena = findViewById<View>(R.id.img_show_popup_athena) as ImageView
//        val img_show_popup_logo = findViewById<View>(R.id.img_show_popup_logo) as ImageView
//        val img_show_popup_info = findViewById<View>(R.id.img_show_popup_info) as ImageView


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels




//        //first quadrant

        btn_show_popup_armory = findViewById<View>(R.id.btn_show_popup_armory) as Button


        val btn_show_popup_library = findViewById<View>(R.id.btn_show_popup_library) as Button
        val img_show_popup_theme = findViewById<View>(R.id.img_show_popup_theme) as ImageView


//        btn_show_popup_armory.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_armory, displayMetrics))
//
//        }






//        btn_show_popup_library.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_library, displayMetrics))
//
//        }

        img_show_popup_theme.setOnClickListener {

            val popUpTutorial_3 = PopUpTutorial(
                view = findViewById<View>(R.id.img_show_popup_theme),
                popUpPoint = getPopUpPoint(R.id.img_show_popup_theme, displayMetrics),
                popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial 1", "Lorem ipsum dolor sit amet. Eum distinctio distinctio vel alias odit qui galisum alias et delectus optio sed quia provident quod magni. Qui deleniti suscipit ab consequatur dolores est aliquid quae At dolores perferendis aut animi obcaecati hic reiciendis soluta.")
            )

            popUpTutorial_3.showPopupWindow({})
        }



//        //second quadrant
//
//
//        val btn_show_popup_tartarus = findViewById<View>(R.id.btn_show_popup_tartarus) as Button
//        val btn_show_popup_styx = findViewById<View>(R.id.btn_show_popup_styx) as Button
//
//
//        btn_show_popup_tartarus.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_tartarus, displayMetrics))
//
//        }
//
//        btn_show_popup_styx.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_styx, displayMetrics))
//
//        }
//
//        //third quadrant
//        //fourth quadrant
//
//        btn_show_popup_help.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_help, displayMetrics))
//
//        }
//
//        btn_show_popup_olympus.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.btn_show_popup_olympus, displayMetrics))
//
//        }
//
//
//
//
//        img_show_popup_logo.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.img_show_popup_logo, displayMetrics))
//
//        }
//
//        img_show_popup_athena.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.img_show_popup_athena, displayMetrics))
//
//        }
//
//        img_show_popup_info.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.img_show_popup_info, displayMetrics))
//
//        }
//
    }



    override fun onWindowFocusChanged(hasFocus: Boolean) {


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels


        popupTutorialManager?.let {
            return
        }

        (findViewById<View>(R.id.layout_dim)).visibility = View.VISIBLE

        val popUpTutorial_1 = PopUpTutorial(
            view = btn_show_popup_armory,
            popUpPoint = getPopUpPoint(R.id.btn_show_popup_armory, displayMetrics),
            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial 1", "Lorem ipsum dolor sit amet. Eum distinctio distinctio vel alias odit qui galisum alias et delectus optio sed quia")
        )


        val popUpTutorial_2 = PopUpTutorial(
            view = findViewById<View>(R.id.btn_show_popup_library),
            popUpPoint = getPopUpPoint(R.id.btn_show_popup_library, displayMetrics),
            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial 1", "Lorem ipsum dolor sit amet.")
        )


        val popUpTutorial_3 = PopUpTutorial(
            view = findViewById<View>(R.id.img_show_popup_theme),
            popUpPoint = getPopUpPoint(R.id.img_show_popup_theme, displayMetrics),
            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial 1", "Lorem ipsum dolor sit amet. Eum distinctio distinctio vel alias odit qui galisum alias et delectus optio sed quia provident quod magni. Qui deleniti suscipit ab consequatur dolores est aliquid quae At dolores perferendis aut animi obcaecati hic reiciendis soluta.")
        )

        val popUpTutorial_4 = PopUpTutorial(
            view = findViewById<View>(R.id.txt_title),
            popUpPoint = getPopUpPoint(R.id.txt_title, displayMetrics),
            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial 1", "Lorem ipsum dolor sit amet. Eum distinctio distinctio vel alias odit qui galisum alias et delectus optio sed quia provident quod magni. Qui deleniti suscipit ab consequatur dolores est aliquid quae At dolores perferendis aut animi obcaecati hic reiciendis soluta.")
        )


        popupTutorialManager = PopupTutorialManager(onConclude =  {
            (findViewById<View>(R.id.layout_dim)).visibility = View.GONE

        })
        popupTutorialManager!!.execute(listOf<PopUpTutorial>(popUpTutorial_1, popUpTutorial_2, popUpTutorial_3, popUpTutorial_4))

//        btn_show_popup_armory.performClick()
    }




    private fun getPopUpPoint(viewId : Int, displayMetrics: DisplayMetrics): PopUpPoint{

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

        return PopUpPoint(point, view.width, view.height, displayMetrics)
    }

}