package com.senhadigitaldeatendimento.Support.Utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.senhadigitaldeatendimento.R

class CustomDialogSenha(var context:Context){

    var dialog: Dialog? = null

    fun showDialogPassword(tittle:String,
                           msg:String,
                           categoria:String,
                           horario:String,
                           listern:onClickListenerPass){

            dialog = Dialog(context)
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
            dialog?.setContentView(R.layout.custom_dialog_password)
            dialog?.setCancelable(false)
            dialog?.window?.attributes?.windowAnimations = R.style.dialog_animation
            dialog?.findViewById<TextView>(R.id.textview_tittle)?.text = tittle
            dialog?.findViewById<TextView>(R.id.textview_pass)?.text = msg
            dialog?.findViewById<TextView>(R.id.textview_desc)?.text = msg
            dialog?.findViewById<TextView>(R.id.textview_desc_categoria)?.text = categoria
            dialog?.findViewById<TextView>(R.id.textview_desc_horario)?.text = horario
            dialog?.findViewById<Button>(R.id.button_ok)?.setOnClickListener {
                listern.closeDialog()
                dialog?.dismiss()
            }
            dialog?.findViewById<Button>(R.id.button_gotosenha)?.setOnClickListener {
                listern.goToPassword()
                dialog?.dismiss()
            }



            dialog?.show()

    }

    interface onClickListenerPass{
        fun goToPassword()
        fun closeDialog()
    }

}