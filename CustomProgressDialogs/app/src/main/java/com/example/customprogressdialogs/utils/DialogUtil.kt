package com.example.customprogressdialogs.utils

import android.content.Context
import com.example.customprogressdialogs.dialogs.BaseDialog
import com.example.customprogressdialogs.dialogs.DefaultDialog
import com.example.customprogressdialogs.dialogs.LinearProgressDialog
import com.example.customprogressdialogs.factory.DialogFactory


/*
 *  Dialog Builder class
 *  ... builds all dialogs
 */
class DialogUtil(val context: Context) {


    lateinit var mDialog: BaseDialog
    var dialogFactory: DialogFactory =
        DialogFactory()

    companion object {

        lateinit var INSTANCE: DialogUtil

        /*
         *
         * method to create Dialog object
         */
        fun builder(context: Context): DialogUtil {
            INSTANCE =
                DialogUtil(context)
            return INSTANCE
        }
    }


    /*
     *
     * method to get dialog type
     */
    fun getDialog(type: DialogType): DialogUtil {
        when(type){
            DialogType.DEFAULT -> {
                mDialog = dialogFactory.getDefaultDialog(context)
            }

            DialogType.LINEAR -> {
                mDialog = dialogFactory.getLinearDialog(context)
            }
        }
        return INSTANCE
    }


    /*
     *
     * method to set text in dialog
     */
    fun setText(text: String): DialogUtil {
        when(mDialog.getDialogType()){
            DialogType.DEFAULT -> {
                (mDialog as DefaultDialog).setText(text)
            }

            DialogType.LINEAR -> {
                (mDialog as LinearProgressDialog).setText(text)
            }

            else -> {

            }
        }
        return INSTANCE
    }


    /*
     *
     * method to set Max Duration
     */
    fun setDuration(duration: Long): DialogUtil {
        when(mDialog.getDialogType()){
            DialogType.LINEAR -> {
                (mDialog as LinearProgressDialog).setMaxDuration(duration)
            }

            else -> {

            }
        }
        return INSTANCE
    }


    /*
     *
     * method to set interval Duration
     */
    fun setInterval(interval: Long): DialogUtil {
        when(mDialog.getDialogType()){
            DialogType.LINEAR -> {
                (mDialog as LinearProgressDialog).setInterval(interval)
            }

            else -> {

            }
        }
        return INSTANCE
    }


    /*
     *
     * method to set interval Duration
     */
    fun setProgress(progress: Int): DialogUtil {
        when(mDialog.getDialogType()){
            DialogType.LINEAR -> {
                (mDialog as LinearProgressDialog).setMaxProgress(progress)
            }

            else -> {

            }
        }
        return INSTANCE
    }


    /*
     *
     * method to show dialog
     */
    fun show() {
        if(this::mDialog.isInitialized){
            mDialog.show()
        }
    }


    /*
     *
     * method to dismiss dialog
     */
    fun dismiss() {
        if(this::mDialog.isInitialized){
            mDialog.dismiss()
        }
    }


    /*
     *
     * method to build dialog util
     */
    fun build(): DialogUtil {
        return INSTANCE
    }
}