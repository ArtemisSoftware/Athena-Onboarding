package com.artemissoftware.athenaonboard

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.DisplayMetrics
import android.view.*

import com.artemissoftware.athenaonboard.tutorial.PopUpPoint
import com.artemissoftware.athenaonboard.tutorial.PopUpTutorial
import com.artemissoftware.athenaonboard.tutorial.PopUpWindowData
import com.artemissoftware.athenaonboard.tutorial.PopupTutorialManager
import android.content.Intent
import android.util.TypedValue
import com.labo.kaji.relativepopupwindow.RelativePopupWindow


class MainActivity : AppCompatActivity() {


    var popupTutorialManager: PopupTutorialManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btn_show_popup_armory = findViewById<View>(R.id.btn_show_popup_armory) as Button

        btn_show_popup_armory.setOnClickListener {


            val k = Intent(this@MainActivity, ArmoryActivity::class.java)
            startActivity(k)

        }

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




//        //second quadrant
//
//
        val btn_show_popup_tartarus = findViewById<View>(R.id.btn_show_popup_tartarus) as Button
        val btn_show_popup_styx = findViewById<View>(R.id.btn_show_popup_styx) as Button


        btn_show_popup_tartarus.setOnClickListener {

            val popUpTutorial_3 = PopUpTutorial(
                anchorView = findViewById<View>(R.id.btn_show_popup_tartarus),
                popUpPoint = getPopUpPoint(R.id.btn_show_popup_tartarus, displayMetrics),
                popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial Tartarus", "We help game developers make their browser games successful by building the market-leading casual browser games platform.")
            )

            popUpTutorial_3.showPopupWindow(it)

//            popUpTutorial_3.showPopupWindow({})

        }

        btn_show_popup_styx.setOnClickListener {

            val popUpTutorial_3 = PopUpTutorial(
                anchorView = findViewById<View>(R.id.btn_show_popup_styx),
                popUpPoint = getPopUpPoint(R.id.btn_show_popup_styx, displayMetrics),
                popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial styx", "We help game developers make their browser games successful by building the market-leading casual browser games platform.")
            )

            //popUpTutorial_3.showPopupWindow(it)
            popUpTutorial_3.showPopupWindow({})

        }
//
//        //third quadrant
//        //fourth quadrant

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

//        img_show_popup_info.setOnClickListener {
//
//            val popUpTutorial = PopUpTutorial()
//            popUpTutorial.showPopupWindow_v3(it, getPopUpPoint(R.id.img_show_popup_info, displayMetrics))
//
//        }
//
    }



    override fun onWindowFocusChanged(hasFocus: Boolean) {


        val popup = ExampleCardPopup(findViewById<View>(R.id.btn_show_popup_olympus).context)
        popup.width =ViewGroup.LayoutParams.WRAP_CONTENT
        popup.height  = ViewGroup.LayoutParams.WRAP_CONTENT


        //-popup.showOnAnchor(findViewById<View>(R.id.btn_show_popup_olympus), RelativePopupWindow.VerticalPosition.BELOW, RelativePopupWindow.HorizontalPosition.ALIGN_LEFT, true)


        val popup2 = ExampleCardPopup(findViewById<View>(R.id.btn_show_popup_tartarus).context)
        popup2.width =ViewGroup.LayoutParams.WRAP_CONTENT
        popup2.height  = ViewGroup.LayoutParams.WRAP_CONTENT


        popup2.showOnAnchor(findViewById<View>(R.id.btn_show_popup_tartarus), RelativePopupWindow.VerticalPosition.ABOVE, RelativePopupWindow.HorizontalPosition.ALIGN_LEFT, 0, -60, true)

//
//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//        val height = displayMetrics.heightPixels
//        val width = displayMetrics.widthPixels
//
//        val l = findViewById<View>(R.id.root);
//        val a: Int = l.getMeasuredWidth();
//        val b: Int = l.getWidth()
//
//
//
//        popupTutorialManager?.let {
//            return
//        }
//
//
//
//        val popUpTutorial_quandrant_1_1 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.btn_show_popup_armory),
//            popUpPoint = getPopUpPoint(R.id.btn_show_popup_armory, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Armory", getString(R.string.lorem_ipsum_pequeno))
//        )
//
//
//        val popUpTutorial_quandrant_1_2 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.btn_show_popup_library),
//            popUpPoint = getPopUpPoint(R.id.btn_show_popup_library, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Library", getString(R.string.lorem_ipsum_medio))
//        )
//
//
//        val popUpTutorial_quandrant_1_3 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.img_show_popup_theme),
//            popUpPoint = getPopUpPoint(R.id.img_show_popup_theme, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial Theme img", getString(R.string.lorem_ipsum_mediano))
//        )
//
//        val popUpTutorial_quandrant_1_4 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.txt_title),
//            popUpPoint = getPopUpPoint(R.id.txt_title, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial Title", getString(R.string.lorem_ipsum_grande))
//        )
//
//
//        val popUpTutorial_quandrant_1_5 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.txt_quadrant_1),
//            popUpPoint = getPopUpPoint(R.id.txt_quadrant_1, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial Quadrant", getString(R.string.lorem_ipsum_grande))
//        )
//
//
//        val popUpTutorial_quandrant_2_1 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.btn_show_popup_tartarus),
//            popUpPoint = getPopUpPoint(R.id.btn_show_popup_tartarus, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial tartarus", "Candidate changes in 2021 Moderator Election – review your ballot")
//        )
//
//        val popUpTutorial_quandrant_2_2 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.btn_show_popup_styx),
//            popUpPoint = getPopUpPoint(R.id.btn_show_popup_styx, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial styx",
//                //"We help game developers make their browser games successful by building the market-leading casual browser games platform." +
//                    //"We help game developers make their browser games successful by building the market-leading casual browser games platform." +
//                    //"We help game developers make their browser games successful by building the market-leading casual browser games platform." +
//                        "We help game developers make their browser games successful by building the market-leading casual browser games platform.")
//        )
//
//
//
//
//        val popUpTutorial_quandrant_3_1 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.img_show_popup_athena),
//            popUpPoint = getPopUpPoint(R.id.img_show_popup_athena, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial athena img", "Candidate changes in 2021 Moderator Election – review your ballot")
//        )
//
//        val popUpTutorial_quandrant_3_2 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.btn_show_popup_help),
//            popUpPoint = getPopUpPoint(R.id.btn_show_popup_help, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial help", "We help game developers make their browser games successful by building the market-leading casual browser games platform.")
//        )
//
//
//
//        val popUpTutorial_quandrant_4_1 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.img_show_popup_logo),
//            popUpPoint = getPopUpPoint(R.id.img_show_popup_logo, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial logo img", "Candidate changes in 2021 Moderator Election – review your ballot")
//        )
//
//        val popUpTutorial_quandrant_4_2 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.img_show_popup_info),
//            popUpPoint = getPopUpPoint(R.id.img_show_popup_info, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial info img", "We help game developers make their browser games successful by building the market-leading casual browser games platform.")
//        )
//
//        val popUpTutorial_quandrant_4_3 = PopUpTutorial(
//            anchorView = findViewById<View>(R.id.txt_quadrant_4),
//            popUpPoint = getPopUpPoint(R.id.txt_quadrant_4, displayMetrics),
//            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial info img", "We help game developers make their browser games successful by building the market-leading casual browser games platform.")
//        )
//
//
//        popupTutorialManager = PopupTutorialManager(onStart = {
//            (findViewById<View>(R.id.layout_dim)).visibility = View.VISIBLE
//        }, onConclude =  {
//            (findViewById<View>(R.id.layout_dim)).visibility = View.GONE
//
//        }).apply {
//            execute(listOf<PopUpTutorial>(
//                //popUpTutorial_quandrant_1_1, //popUpTutorial_quandrant_1_2, popUpTutorial_quandrant_1_3, popUpTutorial_quandrant_1_4, popUpTutorial_quandrant_1_5,
//                //popUpTutorial_quandrant_2_1, popUpTutorial_quandrant_2_2,
//                //popUpTutorial_quandrant_3_1, popUpTutorial_quandrant_3_2,
//                //popUpTutorial_quandrant_4_1, popUpTutorial_quandrant_4_2, popUpTutorial_quandrant_4_3
//            ))
//        }
//        //popupTutorialManager!!.execute(listOf<PopUpTutorial>(popUpTutorial_1, popUpTutorial_2, popUpTutorial_3, popUpTutorial_4))
//
////        btn_show_popup_armory.performClick()
    }




//    private fun getPopUpPoint(viewId : Int, displayMetrics: DisplayMetrics): PopUpPoint {
//
//        val location = IntArray(2)
//        val view = findViewById<View>(viewId) as View
//
//        // Get the x, y location and store it in the location[] array
//        // location[0] = x, location[1] = y.
//
//        // Get the x, y location and store it in the location[] array
//        // location[0] = x, location[1] = y.
//        view.getLocationOnScreen(location)
//
//        //Initialize the Point with x, and y positions
//        val point = Point()
//        point!!.x = location[0]
//        point!!.y = location[1]
//
//        return PopUpPoint(point, view.width, view.height, displayMetrics)
//    }

}