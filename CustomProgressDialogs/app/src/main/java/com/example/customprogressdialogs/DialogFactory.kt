package com.example.customprogressdialogs

import android.content.Context

/*
 *  Dialog Factory class
 *  ... responsible for providing different dialogs
 */
class DialogFactory {


    /*
     *
     * method to get default dialog
     */
    public fun getDefaultDialog(context: Context): DefaultDialog{
        return DefaultDialog.create(context)
    }


    /*
     *
     * method to get linear progress dialog
     */
    fun getLinearDialog(context: Context): LinearProgressDialog{
        return LinearProgressDialog.create(context)
    }
}