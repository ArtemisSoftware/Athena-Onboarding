package com.artemissoftware.athenaonboard

class PopupTutorialManager(var executed: Boolean = false, private val onConclude: () -> Unit) {

    var popups: List<PopUpTutorial>? = null

    private var index = 0

    fun execute(popups: List<PopUpTutorial>) {

        this.popups = popups

        if(executed == false)
            popups?.get(index)?.let { executeTutorial(it) }
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