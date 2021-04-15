package com.example.customprogressdialogs

import android.annotation.SuppressLint
import android.content.Context

class DialogUtil(val context: Context) {


    var defaultDialog: DefaultDialog? = null


    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var INSTANCE: DialogUtil

        /*
         *
         * method to create Dialog object
         */
        fun builder(context: Context): DialogUtil{
            INSTANCE = DialogUtil(context)
            return INSTANCE
        }
    }


    fun getDefaultDialog(): DialogUtil{
        defaultDialog = DefaultDialog.create(context)
        return INSTANCE
    }


    fun setDefaultDialogText(text: String): DialogUtil{
        defaultDialog?.setText(text)
        return INSTANCE
    }


    /*
     *
     * method to show dialog
     */
    fun show() {
        defaultDialog?.show()
    }


    /*
     *
     * method to dismiss dialog
     */
    fun dismiss() {
        defaultDialog?.dismiss()
    }


    fun build(): DialogUtil{
        show()
        return INSTANCE
    }
}