package com.artemissoftware.athenaonboard

import android.R.attr
import android.R.attr.*
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.artemissoftware.athenaonboard.tutorial.PopupWindowData
import com.google.android.material.circularreveal.cardview.CircularRevealCardView
import com.labo.kaji.relativepopupwindow.RelativePopupWindow
import kotlin.math.hypot
import kotlin.math.max

import android.view.ViewGroup.MarginLayoutParams


class CardTutorialPopup (val popUpWindowData_: PopupWindowData) : RelativePopupWindow(popUpWindowData_.anchor.context) {

    var next: () -> Unit = {}

    init {

        @SuppressLint("InflateParams")
        val layout = LayoutInflater.from(popUpWindowData_.anchor.context).inflate(popUpWindowData_.layout, null)

        contentView = layout
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        height = ViewGroup.LayoutParams.WRAP_CONTENT
        isFocusable = false
        isOutsideTouchable = false
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Disable default animation for circular reveal
        animationStyle = 0


        addTutorial(layout)
    }


    private fun addTutorial(layout: View){

        (layout.findViewById<View>(R.id.txt_title) as TextView).text = popUpWindowData_.title
        (layout.findViewById<View>(R.id.txt_description) as TextView).text = popUpWindowData_.description


        val arrow_top = (layout.findViewById<View>(R.id.img_arrow_top) as ImageView)
        val arrow_top_right = (layout.findViewById<View>(R.id.img_arrow_top_right) as ImageView)
        val arrow_bottom = (layout.findViewById<View>(R.id.img_arrow_bottom) as ImageView)
        val arrow_bottom_right = (layout.findViewById<View>(R.id.img_arrow_bottom_right) as ImageView)

        arrow_top.visibility = popUpWindowData_._arrowTopVisibility
        arrow_top_right.visibility = popUpWindowData_._arrowTopRightVisibility
        arrow_bottom.visibility = popUpWindowData_._arrowBottomVisibility
        arrow_bottom_right.visibility = popUpWindowData_._arrowBottomRightVisibility


        //Handler for clicking on the inactive zone of the window
        layout.setOnTouchListener { v, event -> //Close the window when clicked
            this@CardTutorialPopup.dismiss()
            next()
            true
        }


        val contraintLayer = (layout.findViewById<View>(R.id.constraint_root) as ConstraintLayout)
        val set = ConstraintSet()
        set.clone(contraintLayer)

        set.connect(arrow_top.getId(), ConstraintSet.START,  ConstraintSet.PARENT_ID,  ConstraintSet.START, popUpWindowData_._arrowOffset)
        set.setMargin(arrow_top.getId(), ConstraintSet.START, popUpWindowData_._arrowOffset);

        set.connect(arrow_bottom.getId(), ConstraintSet.START,  ConstraintSet.PARENT_ID,  ConstraintSet.START, popUpWindowData_._arrowOffset)
        set.setMargin(arrow_bottom.getId(), ConstraintSet.START,  popUpWindowData_._arrowOffset);


//        set.connect(arrow_top_right.getId(), ConstraintSet.END,  ConstraintSet.PARENT_ID,  ConstraintSet.END, popUpWindowData_._arrowOffset)
//        set.setMargin(arrow_top_right.getId(), ConstraintSet.END, popUpWindowData_._arrowOffset);
//        set.connect(arrow_bottom_right.getId(), ConstraintSet.END,  ConstraintSet.PARENT_ID,  ConstraintSet.END, popUpWindowData_._arrowOffset)
//        set.setMargin(arrow_bottom_right.getId(), ConstraintSet.END,  popUpWindowData_._arrowOffset);

        set.applyTo(contraintLayer);
        contraintLayer.invalidate();

    }

    override fun showOnAnchor(
        anchor: View,
        vertPos: Int,
        horizPos: Int,
        x: Int,
        y: Int,
        fitInScreen: Boolean
    ) {
        super.showOnAnchor(anchor, vertPos, horizPos, x, y, fitInScreen)
        circularReveal(anchor)
    }

    private fun circularReveal(anchor: View) {
        (contentView as CircularRevealCardView).run {
            post {
                val myLocation = IntArray(2).apply { getLocationOnScreen(this) }
                val anchorLocation = IntArray(2).apply { anchor.getLocationOnScreen(this) }
                val cx = anchorLocation[0] - myLocation[0] + anchor.width / 2
                val cy = anchorLocation[1] - myLocation[1] + anchor.height / 2
                val windowRect = Rect().apply { getWindowVisibleDisplayFrame(this) }

                measure(
                    makeDropDownMeasureSpec(this@CardTutorialPopup.width, windowRect.width()),
                    makeDropDownMeasureSpec(this@CardTutorialPopup.height, windowRect.height())
                )
                val dx = max(cx, measuredWidth - cx)
                val dy = max(cy, measuredHeight - cy)
                val finalRadius = hypot(dx.toFloat(), dy.toFloat())

                //for animation
//                CircularRevealCompat.createCircularReveal(
//                    this,
//                    cx.toFloat(),
//                    cy.toFloat(),
//                    0f,
//                    finalRadius
//                ).run {
//                    duration = 500
//                    start()
//                }
            }
        }
    }

    companion object {
        private fun makeDropDownMeasureSpec(measureSpec: Int, maxSize: Int): Int {
            return View.MeasureSpec.makeMeasureSpec(
                getDropDownMeasureSpecSize(measureSpec, maxSize),
                getDropDownMeasureSpecMode(measureSpec)
            )
        }

        private fun getDropDownMeasureSpecSize(measureSpec: Int, maxSize: Int): Int {
            return when (measureSpec) {
                ViewGroup.LayoutParams.MATCH_PARENT -> maxSize
                else -> View.MeasureSpec.getSize(measureSpec)
            }
        }

        private fun getDropDownMeasureSpecMode(measureSpec: Int): Int {
            return when (measureSpec) {
                ViewGroup.LayoutParams.WRAP_CONTENT -> View.MeasureSpec.UNSPECIFIED
                else -> View.MeasureSpec.EXACTLY
            }
        }
    }
}