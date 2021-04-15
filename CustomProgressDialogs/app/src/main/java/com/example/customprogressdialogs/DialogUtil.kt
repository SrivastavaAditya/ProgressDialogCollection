package com.example.customprogressdialogs

import android.annotation.SuppressLint
import android.content.Context

class DialogUtil(val context: Context) {


    lateinit var defaultDialog: DefaultDialog
    lateinit var linearDialog: LinearProgressDialog

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


    fun getLinearDialog(): DialogUtil{
        linearDialog = LinearProgressDialog.create(context)
        return INSTANCE
    }


    fun setDefaultDialogText(text: String): DialogUtil{
        defaultDialog.setText(text)
        return INSTANCE
    }


    fun setLinearDialogTitle(text: String): DialogUtil{
        linearDialog.setText(text)
        return INSTANCE
    }


    /*
     *
     * method to show dialog
     */
    fun show() {
        if(this::defaultDialog.isInitialized){
            defaultDialog.show()
        }

        if(this::linearDialog.isInitialized){
            linearDialog.show()
        }
    }


    /*
     *
     * method to dismiss dialog
     */
    fun dismiss() {
        defaultDialog.dismiss()
        linearDialog.dismiss()
    }


    fun build(): DialogUtil{
        show()
        return INSTANCE
    }
}