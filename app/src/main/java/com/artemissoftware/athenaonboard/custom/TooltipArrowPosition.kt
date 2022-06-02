package com.artemissoftware.athenaonboard.custom

enum class TooltipArrowPosition(val value: Int) {
    NO_ARROW(0),
    TOP(1),
    TOP_CENTER(2),
    BOTTOM(3),
    BOTTOM_CENTER(4);

    companion object{

        fun isBottom(position: TooltipArrowPosition) = listOf(BOTTOM, BOTTOM_CENTER).contains(position)

        fun getPosition(position: Int) = values().find { it.value == position } ?: NO_ARROW
    }
}