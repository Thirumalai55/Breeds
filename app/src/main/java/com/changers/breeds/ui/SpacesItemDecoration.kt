package com.changers.breeds.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/*
* This class for ensure the grid cell have equal space
* */
class SpacesItemDecoration constructor(private val space: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space
        if(outRect.top == 0) {
            outRect.top = space
        } else {
            outRect.top = 0
        }
    }
}