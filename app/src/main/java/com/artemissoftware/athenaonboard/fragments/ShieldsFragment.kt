package com.artemissoftware.athenaonboard.fragments

import android.graphics.Point
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.artemissoftware.athenaonboard.CardTutorialPopup
import com.artemissoftware.athenaonboard.R
import com.artemissoftware.athenaonboard.addOnWindowFocusChangeListener
import com.artemissoftware.athenaonboard.getDisplayMetrics
import com.artemissoftware.athenaonboard.tutorial.*
import com.labo.kaji.relativepopupwindow.RelativePopupWindow


class ShieldsFragment : Fragment(R.layout.fragment_shields) {


    var popupTutorialManager: PopupTutorialManager? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        addOnWindowFocusChangeListener { hasFocus ->
            tutorial()
        }


    }



    private fun tutorial(){


        popupTutorialManager?.let {
            return
        }


        val popupWindowData_1 = PopupWindowData(
            anchor = requireView().findViewById<View>(R.id.img_shields),
            layout = R.layout.popup_tutorial_card,
            title = "Tutorial Title",
            description =  getString(R.string.lorem_ipsum_pequeno),
            displayMetrics = requireActivity().getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.ABOVE,
            horizPos = RelativePopupWindow.HorizontalPosition.CENTER
        )


        val popupWindowData_2 = PopupWindowData(
            anchor = requireView().findViewById<View>(R.id.txt_title),
            layout = R.layout.popup_tutorial_card,
            title = "Tutorial Title",
            description =  getString(R.string.lorem_ipsum_mediano),
            displayMetrics = requireActivity().getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.BELOW,
            horizPos = RelativePopupWindow.HorizontalPosition.ALIGN_LEFT
        )

        val popupWindowData_3 = PopupWindowData(
            anchor = requireView().findViewById<View>(R.id.txt_available),
            layout = R.layout.popup_tutorial_card,
            title = "Tutorial Title",
            description =  getString(R.string.lorem_ipsum_grande),
            displayMetrics = requireActivity().getDisplayMetrics(),
            vertPos = RelativePopupWindow.VerticalPosition.ABOVE,
            horizPos = RelativePopupWindow.HorizontalPosition.CENTER,
            offsetY = -240
        )


        val popUpTutorial_1 = CardTutorialPopup(popUpWindowData_ = popupWindowData_1)
        val popUpTutorial_2 = CardTutorialPopup(popUpWindowData_ = popupWindowData_2)
        val popUpTutorial_3 = CardTutorialPopup(popUpWindowData_ = popupWindowData_3)

        popupTutorialManager = PopupTutorialManager(onStart = {
            (requireView().findViewById<View>(R.id.layout_dim)).visibility = View.VISIBLE
        }, onConclude =  {
            (requireView().findViewById<View>(R.id.layout_dim)).visibility = View.GONE

        }).apply {
            execute(listOf<RelativePopupWindow>(
                popUpTutorial_1, popUpTutorial_2,popUpTutorial_3
            ))
        }


    }


}