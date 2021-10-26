package com.artemissoftware.athenaonboard

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.DisplayMetrics
import android.view.*

import android.content.Intent
import android.util.TypedValue
import com.artemissoftware.athenaonboard.tutorial.*
import com.labo.kaji.relativepopupwindow.RelativePopupWindow


class MainActivity : AppCompatActivity() {


    var popupTutorialManager: PopupTutorialManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_show_popup_armory).setOnClickListener{

            val k = Intent(this@MainActivity, ArmoryActivity::class.java)
            startActivity(k)

        }

    }



    override fun onWindowFocusChanged(hasFocus: Boolean) {

        popupTutorialManager?.let {
            return
        }

        val popupWindowData_1 = PopupWindowData(
            anchor = findViewById<View>(R.id.txt_title),
            layout = R.layout.test_test,
            title = "Tutorial Title",
            description =  getString(R.string.lorem_ipsum_pequeno),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.BELOW,
            horizPos = RelativePopupWindow.HorizontalPosition.ALIGN_LEFT
        )

        val popUpTutorial_1 = CardTutorialPopup(popUpWindowData_ = popupWindowData_1)



        val popupWindowData_2 = PopupWindowData(
            anchor = findViewById<View>(R.id.btn_show_popup_armory),
            layout = R.layout.test_test,
            title = "Tutorial armory",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.BELOW,
            horizPos = RelativePopupWindow.HorizontalPosition.ALIGN_LEFT
        )

        val popUpTutorial_2 = CardTutorialPopup(popUpWindowData_ = popupWindowData_2)


        val popupWindowData_3 = PopupWindowData(
            anchor = findViewById<View>(R.id.btn_show_popup_library),
            layout = R.layout.test_test,
            title = "Tutorial library",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.BELOW,
            horizPos = RelativePopupWindow.HorizontalPosition.ALIGN_LEFT
        )

        val popUpTutorial_3 = CardTutorialPopup(popUpWindowData_ = popupWindowData_3)


        val popupWindowData_4 = PopupWindowData(
            anchor = findViewById<View>(R.id.img_show_popup_theme),
            layout = R.layout.test_test,
            title = "Tutorial theme",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.BELOW,
            horizPos = RelativePopupWindow.HorizontalPosition.ALIGN_LEFT
        )

        val popUpTutorial_4 = CardTutorialPopup(popUpWindowData_ = popupWindowData_4)




        val popupWindowData_5 = PopupWindowData(
            anchor = findViewById<View>(R.id.btn_show_popup_styx),
            layout = R.layout.test_test,
            title = "Tutorial styx",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.ABOVE,
            horizPos = RelativePopupWindow.HorizontalPosition.ALIGN_LEFT,
            offsetY = -148
        )

        val popUpTutorial_5 = CardTutorialPopup(popUpWindowData_ = popupWindowData_5)


        val popupWindowData_6 = PopupWindowData(
            anchor = findViewById<View>(R.id.btn_show_popup_tartarus),
            layout = R.layout.test_test,
            title = "Tutorial tartarus",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.ABOVE,
            horizPos = RelativePopupWindow.HorizontalPosition.ALIGN_LEFT,
            offsetY = -132
        )

        val popUpTutorial_6 = CardTutorialPopup(popUpWindowData_ = popupWindowData_6)




        val popupWindowData_7 = PopupWindowData(
            anchor = findViewById<View>(R.id.img_show_popup_logo),
            layout = R.layout.test_test,
            title = "logo",
            description =  getString(R.string.lorem_ipsum_muito_pequeno),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.BELOW,
            horizPos = RelativePopupWindow.HorizontalPosition.RIGHT
        )

        val popUpTutorial_7 = CardTutorialPopup(popUpWindowData_ = popupWindowData_7)


        val popupWindowData_8 = PopupWindowData(
            anchor = findViewById<View>(R.id.img_show_popup_info),
            layout = R.layout.test_test,
            title = "Tutorial info",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.BELOW,
            horizPos = RelativePopupWindow.HorizontalPosition.RIGHT
        )

        val popUpTutorial_8 = CardTutorialPopup(popUpWindowData_ = popupWindowData_8)




        val popupWindowData_9 = PopupWindowData(
            anchor = findViewById<View>(R.id.img_show_popup_athena),
            layout = R.layout.test_test,
            title = "Tutorial athena",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.ABOVE,
            horizPos = RelativePopupWindow.HorizontalPosition.RIGHT,
            offsetY = -132
        )

        val popUpTutorial_9 = CardTutorialPopup(popUpWindowData_ = popupWindowData_9)


        val popupWindowData_10 = PopupWindowData(
            anchor = findViewById<View>(R.id.btn_show_popup_help),
            layout = R.layout.test_test,
            title = "Tutorial help",
            description =  getString(R.string.lorem_ipsum_medio),
            displayMetrics = getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.ABOVE,
            horizPos = RelativePopupWindow.HorizontalPosition.RIGHT,
            offsetY = -132
        )

        val popUpTutorial_10 = CardTutorialPopup(popUpWindowData_ = popupWindowData_10)


        popupTutorialManager = PopupTutorialManager(onStart = {
            (findViewById<View>(R.id.layout_dim)).visibility = View.VISIBLE
        }, onConclude =  {
            (findViewById<View>(R.id.layout_dim)).visibility = View.GONE

        }).apply {
            execute(listOf<RelativePopupWindow>(
                popUpTutorial_1, popUpTutorial_2, popUpTutorial_3, popUpTutorial_4, popUpTutorial_5, popUpTutorial_6,
                popUpTutorial_7, popUpTutorial_8, popUpTutorial_9, popUpTutorial_10

            ))
        }

    }



}