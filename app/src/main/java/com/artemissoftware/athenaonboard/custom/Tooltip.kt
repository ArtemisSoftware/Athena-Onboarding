package com.artemissoftware.athenaonboard.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.NonNull
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.artemissoftware.athenaonboard.R
import com.artemissoftware.athenaonboard.databinding.TooltipViewBinding
import com.google.android.material.card.MaterialCardView


import android.content.res.TypedArray







class Tooltip(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var binding: TooltipViewBinding = TooltipViewBinding.inflate(LayoutInflater.from(context), this)
    private lateinit var mainView: View
    private lateinit var imageView: AppCompatImageView

    private var arrowPosition: TooltipArrowPosition = TooltipArrowPosition.NO_ARROW
    private var title: String? = null

    init {
        inflateAttributes(context, attrs, 0, 0)


    }

    private fun inflateAttributes(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRe: Int){

        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Tooltip,
            defStyleAttr,
            defStyleRe
        )

        try{

            title = typedArray.getString(R.styleable.Tooltip_tiptitle)
            arrowPosition = TooltipArrowPosition.getPosition(typedArray.getInt(R.styleable.Tooltip_arrowPosition, TooltipArrowPosition.NO_ARROW.value))

        }finally {

            typedArray.recycle()
        }

        binding.textView.text = title

    }

    fun setPosition(view: View){

        val arrowView = if(TooltipArrowPosition.isBottom(arrowPosition)){
            binding.imageView3.visibility = View.GONE
            binding.imgArrowBottom
        }
        else{
            binding.imgArrowBottom.visibility = View.GONE
            binding.imageView3
        }

        calculateX(arrowView, getCoordinateOnScreen(view, true) + view.width/2f)
        if(TooltipArrowPosition.isBottom(arrowPosition)) arrowView.rotation = 180f
    }

    private fun calculateX(arrowView: View, value: Float){
        arrowView.x = 36.5f//value - getCoordinateOnScreen(arrowView, true) - (arrowView.width/2f)
    }

    private fun getCoordinateOnScreen(view: View, isX: Boolean): Int{

        val location = IntArray(2)
        view.getLocationOnScreen(location)
        return if(isX) location[0] else location[1]

    }




}