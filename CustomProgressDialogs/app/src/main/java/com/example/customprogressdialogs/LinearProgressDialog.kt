package com.example.customprogressdialogs

import android.app.Dialog
import android.content.Context
import android.os.CountDownTimer
import android.text.TextUtils
import kotlinx.android.synthetic.main.layout_default_dialog.*
import kotlinx.android.synthetic.main.layout_default_dialog.tv_load_text
import kotlinx.android.synthetic.main.layout_linear_progress_dialog.*

class LinearProgressDialog(context: Context): Dialog(context){

    var dialog = Dialog(context)
    var mDuration: Int = 0

    init {
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setContentView(R.layout.layout_linear_progress_dialog)
        dialog.linear_pb.progress = 0
    }


    companion object{
        const val TAG = "Linear Progress Dialog"

        lateinit var INSTANCE: LinearProgressDialog

        fun create(context: Context): LinearProgressDialog{
            INSTANCE = LinearProgressDialog(context)
            return INSTANCE
        }
    }


    /*
     *
     * method to set Text
     */
    fun setText(text: String): LinearProgressDialog{
        dialog.tv_load_text.text = if (!TextUtils.isEmpty(text)) text else context.getString(R.string.text_loading)
        return INSTANCE
    }


    /*
     *
     * method to show progress
     */
    fun setMaxProgress(maxProgress: Int){
        dialog.linear_pb.max = maxProgress
    }


    /*
     *
     * method to set Max Duration
     */
    fun setMaxDuration(maxDuration: Int){
        mDuration = maxDuration
    }

    /*
     *
     * method to show dialog
     */
    override fun show() {
        var i = 0
        val timer = object: CountDownTimer(10000, 1000){
            override fun onFinish() {
                dialog.linear_pb.progress = dialog.linear_pb.max
                dismiss()
            }

            override fun onTick(millisUntilFinished: Long) {
                i+=1
                dialog.linear_pb.progress = i*10
            }

        }
        dialog.show()
        timer.start()
    }


    /*
     *
     * method to dismiss dialog
     */
    override fun dismiss() {
        Thread.sleep(500)
        dialog.dismiss()
    }
}