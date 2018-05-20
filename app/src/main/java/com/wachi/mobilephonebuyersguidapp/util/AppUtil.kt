package com.wachi.mobilephonebuyersguidapp.util

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

object AppUtil {
    fun alertDialog(context: Context, title: String, message: String, cancelable: Boolean,
                    textPositiveButton: String, onPositiveButtonClick: DialogInterface.OnClickListener? = null,
                    textNegativeButton: String? = null, onNegativeButtonClick: DialogInterface.OnClickListener? = null) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(cancelable)
        builder.setPositiveButton(textPositiveButton, null)
        if (onPositiveButtonClick != null) {
            builder.setPositiveButton(textPositiveButton, onPositiveButtonClick)
        }
        if (textNegativeButton != null) {
            if (onNegativeButtonClick != null)
                builder.setNegativeButton(textNegativeButton, onNegativeButtonClick)
            else
                builder.setNegativeButton(textNegativeButton, null)
        }
        builder.show()
    }
}