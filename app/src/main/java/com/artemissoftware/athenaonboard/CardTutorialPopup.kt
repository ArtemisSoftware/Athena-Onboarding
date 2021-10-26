package com.artemissoftware.athenaonboard

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.circularreveal.CircularRevealCompat
import com.google.android.material.circularreveal.cardview.CircularRevealCardView
import com.labo.kaji.relativepopupwindow.RelativePopupWindow
import kotlin.math.hypot
import kotlin.math.max

class CardTutorialPopup (context: Context) : RelativePopupWindow(context) {

    init {
        @SuppressLint("InflateParams")
        contentView = LayoutInflater.from(context).inflate(R.layout.popup_tutorial_card, null)
        width = ViewGroup.LayoutParams.WRAP_CONTENT
        height = ViewGroup.LayoutParams.WRAP_CONTENT
        isFocusable = true
        isOutsideTouchable = false
        //setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Disable default animation for circular reveal
        animationStyle = 0


        addTutorial()
    }


    private fun addTutorial(){

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