package com.artemissoftware.athenaonboard.tutorial

class PopupTutorialManager(var executed: Boolean = false,  private val onStart: () -> Unit, private val onConclude: () -> Unit) {

    var popups: List<PopUpTutorial>? = null

    private var index = 0

    fun execute(popups: List<PopUpTutorial>) {

        this.popups = popups

        if(executed == false && popups.size > 0)
            popups?.get(index)?.let {

                onStart()
                executeTutorial(it)
            }
    }


    private fun executeTutorial(tutorial: PopUpTutorial){

        tutorial.showPopupWindow(::nextTutorial)
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