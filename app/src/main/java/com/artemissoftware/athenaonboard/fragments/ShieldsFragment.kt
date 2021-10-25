package com.artemissoftware.athenaonboard.fragments

import android.graphics.Point
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.artemissoftware.athenaonboard.R
import com.artemissoftware.athenaonboard.getDisplayMetrics
import com.artemissoftware.athenaonboard.tutorial.PopUpPoint
import com.artemissoftware.athenaonboard.tutorial.PopUpTutorial
import com.artemissoftware.athenaonboard.tutorial.PopUpWindowData
import com.artemissoftware.athenaonboard.tutorial.PopupTutorialManager


class ShieldsFragment : Fragment(R.layout.fragment_shields) {


    var popupTutorialManager: PopupTutorialManager? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tutorial()
    }



    private fun tutorial(){


        popupTutorialManager?.let {
            return
        }


        val popUpTutorial = PopUpTutorial(
            view = requireView().findViewById<View>(R.id.img_shields),
            popUpPoint = getPopUpPoint( requireActivity(), getView(), R.id.img_shields),
            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial 1", "Lorem ipsum dolor sit amet. Eum distinctio distinctio vel alias odit qui galisum alias et delectus optio sed quia")
        )


        val popUpTutorial_2 = PopUpTutorial(
            view = requireView().findViewById<View>(R.id.txt_available),
            popUpPoint = getPopUpPoint( requireActivity(), getView(), R.id.txt_available),
            popUpWindowData = PopUpWindowData(R.layout.popup_layout, "Tutorial 2", "Lorem ipsum dolor sit amet. Eum distinctio distinctio vel alias odit qui galisum alias et delectus optio sed quia")
        )



        view?.viewTreeObserver?.addOnWindowFocusChangeListener { hasFocus ->

            popUpTutorial_2.showPopupWindow({})

        }



//        getView()?.let { popUpTutorial.showPopupWindow(it) }
//
//
//        popupTutorialManager = PopupTutorialManager(onStart = {
//            //(findViewById<View>(R.id.layout_dim)).visibility = View.VISIBLE
//        }, onConclude =  {
//            //(findViewById<View>(R.id.layout_dim)).visibility = View.GONE
//
//        }).apply {
//            execute(listOf<PopUpTutorial>(
//                //popUpTutorial, popUpTutorial_2,
//            ))
//        }


    }


    private fun getPopUpPoint(view1: FragmentActivity, view: View?, viewId: Int): PopUpPoint {

        val location = IntArray(2)
        val view = view?.findViewById<View>(viewId) as View

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        view.getLocationOnScreen(location)

        //Initialize the Point with x, and y positions
        val point = Point()
        point!!.x = location[0]
        point!!.y = location[1]

        return PopUpPoint(point, view.width, view.height, view1.getDisplayMetrics())
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