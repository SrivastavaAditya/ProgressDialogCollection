package com.example.customprogressdialogs

import android.app.Dialog
import android.content.Context


/*
 *
 *  Parent Base class for all dialogs
 */
abstract class BaseDialog(context: Context): Dialog(context) {

    var dialogClass: DialogType? = null

    /*
     *
     * method to show dialog
     */
    abstract override fun show()


    /*
     *
     * method to dismiss dialog
     */
    abstract override fun dismiss()


    /*
     *
     * method to get dialog type
     */
    fun getDialogType(): DialogType? = dialogClass


    /*
     *
     * method to set dialog type
     */
    fun setDialogType(dialogType: DialogType){
        dialogClass = dialogType
    }
}