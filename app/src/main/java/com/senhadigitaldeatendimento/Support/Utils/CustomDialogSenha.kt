package com.senhadigitaldeatendimento.Support.Utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class CustomDialogSenha(var context:Context){

    var dialog: Dialog? = null

    fun showDialogConfirmation(tittle:String,msg:String, listern: DialogInterface.OnDismissListener? = null){

        try {

            dialog = Dialog(context)
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
            dialog?.setContentView(R.layout.dialog_custom)
            dialog?.setCancelable(false)
            dialog?.window?.attributes?.windowAnimations = R.style.dialog_animation
            dialog?.findViewById<TextView>(R.id.textview_tittle)?.text = tittle
            dialog?.findViewById<TextView>(R.id.textview_desc)?.text = msg
            dialog?.findViewById<Button>(R.id.button_ok)?.setOnClickListener {
                dialog?.dismiss()
                listern?.onDismiss(dialog)
            }

            dialog?.show()

        }catch (e:Exception){

        }
    }

    fun showDialogQuestion(tittle:String?,msg:String?, listern:CustomDialogActions){

        try {

            dialog = Dialog(context)
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
            dialog?.setContentView(R.layout.dialog_custom)
            dialog?.setCancelable(false)
            dialog?.window?.attributes?.windowAnimations = R.style.dialog_animation
            dialog?.findViewById<TextView>(R.id.textview_tittle)?.text = tittle
            dialog?.findViewById<TextView>(R.id.textview_desc)?.text = msg
            dialog?.findViewById<Button>(R.id.button_ok)?.text = context?.getString(R.string.text_sim)
            dialog?.findViewById<Button>(R.id.button_ok)?.setOnClickListener {
                dialog?.dismiss()
                listern.yes()
            }
            dialog?.findViewById<Button>(R.id.button_no)?.visibility = View.VISIBLE
            dialog?.findViewById<Button>(R.id.button_no)?.text = context?.getString(R.string.text_nao)
            dialog?.findViewById<Button>(R.id.button_no)?.setOnClickListener {
                dialog?.dismiss()
                listern.no()
            }

            dialog?.show()

        }catch (e: Exception){

        }

    }


}