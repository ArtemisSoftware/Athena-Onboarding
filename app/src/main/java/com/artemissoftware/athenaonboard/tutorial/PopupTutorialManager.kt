package com.artemissoftware.athenaonboard.tutorial

import com.artemissoftware.athenaonboard.CardTutorialPopup
import com.labo.kaji.relativepopupwindow.RelativePopupWindow

class PopupTutorialManager(var executed: Boolean = false,  private val onStart: () -> Unit, private val onConclude: () -> Unit) {

    var popups: List<RelativePopupWindow>? = null

    private var index = 0

    fun execute(popups: List<RelativePopupWindow>) {

        this.popups = popups

        if(executed == false && popups.size > 0)
            popups?.get(index)?.let {

                onStart()
                executeTutorial(it)
            }
    }


    private fun executeTutorial(tutorial: RelativePopupWindow){

        if(tutorial is CardTutorialPopup) {

            tutorial.run {
                next = { nextTutorial() }
                showOnAnchor(popUpWindowData_.anchor, popUpWindowData_.vertPos, popUpWindowData_.horizPos, popUpWindowData_.offsetX, popUpWindowData_.offsetY, true)
            }

        }
    }


    fun nextTutorial(){

        ++index

        popups?.let { list->

            if(index < list.size){
                executeTutorial(list[index])
            }
            else{
                onConclude()
            }

        }



    }
}