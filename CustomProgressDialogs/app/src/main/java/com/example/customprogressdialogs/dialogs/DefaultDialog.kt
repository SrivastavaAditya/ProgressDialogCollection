package com.example.customprogressdialogs.dialogs

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import com.example.customprogressdialogs.utils.DialogType
import com.example.customprogressdialogs.R
import kotlinx.android.synthetic.main.layout_default_dialog.*

/*
 *
 *  Default dialog implementation
 */
class DefaultDialog(mContext: Context): BaseDialog(mContext) {

    var dialog = Dialog(mContext)


    /*
     *
     * Initialization
     */
    init {
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setContentView(R.layout.layout_default_dialog)
        setDialogType(dialogType)
    }


    /*
     *
     * static block
     */
    companion object{
        const val TAG = "Default Dialog"

        val dialogType = DialogType.DEFAULT

        lateinit var INSTANCE: DefaultDialog

        fun create(context: Context): DefaultDialog {
            INSTANCE = DefaultDialog(context)
            return INSTANCE
        }
    }


    /*
     *
     * method to set Text
     */
    fun setText(text: String): DefaultDialog {
        dialog.tv_load_text.text = if (!TextUtils.isEmpty(text)) text else context.getString(
            R.string.text_loading
        )
        return INSTANCE
    }


    /*
     *
     * method to show dialog
     */
    override fun show() {
        dialog.show()
    }


    /*
     *
     * method to dismiss dialog
     */
    override fun dismiss() {
        dialog.dismiss()
    }
}