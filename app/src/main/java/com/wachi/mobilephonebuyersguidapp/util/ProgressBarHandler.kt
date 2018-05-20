package com.wachi.mobilephonebuyersguidapp.util

import android.app.Activity
import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.wachi.mobilephonebuyersguidapp.R

class ProgressBarHandler(context: Context) {

    private var mProgressBar: ProgressBar

    fun showProgress() {
        mProgressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        mProgressBar.visibility = View.INVISIBLE
    }

    init {
        val layout = (context as Activity).findViewById<View>(android.R.id.content).rootView as ViewGroup
        mProgressBar = ProgressBar(context, null)
        mProgressBar.isIndeterminate = true
        mProgressBar.indeterminateDrawable.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary),
                android.graphics.PorterDuff.Mode.MULTIPLY)
        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        val rl = RelativeLayout(context)
        rl.gravity = Gravity.CENTER
        rl.addView(mProgressBar)
        layout.addView(rl, params)
        hideProgress()
    }
}