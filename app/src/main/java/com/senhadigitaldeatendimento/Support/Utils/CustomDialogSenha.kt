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
            dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
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

    fun showDialogDefault(tittle: String, msg: String, listern: onClickListenerDefault){

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        dialog?.setContentView(R.layout.custom_dialog_default)
        dialog?.setCancelable(false)
        dialog?.window?.attributes?.windowAnimations = R.style.dialog_animation
        dialog?.findViewById<TextView>(R.id.textview_tittle)?.text = tittle
        dialog?.findViewById<TextView>(R.id.textview_body)?.text = msg
        dialog?.findViewById<Button>(R.id.button_yes)?.setOnClickListener {
            listern.yes()
            dialog?.dismiss()
        }
        dialog?.findViewById<Button>(R.id.button_no)?.setOnClickListener {
            listern.no()
            dialog?.dismiss()
        }



        dialog?.show()


    }

    fun showDialogDefaultError(tittle: String, msg: String, listern: onClickListenerError){

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        dialog?.setContentView(R.layout.custom_dialog_error)
        dialog?.setCancelable(false)
        dialog?.window?.attributes?.windowAnimations = R.style.dialog_animation
        dialog?.findViewById<TextView>(R.id.textview_tittle_error)?.text = tittle
        dialog?.findViewById<TextView>(R.id.textview_body)?.text = msg
        dialog?.findViewById<Button>(R.id.button_yes)?.setOnClickListener {
            listern.ok()
            dialog?.dismiss()
        }

        dialog?.show()

    }

    interface onClickListenerPass{
        fun goToPassword()
        fun closeDialog()
    }

    interface onClickListenerError{
        fun ok()
    }

    interface onClickListenerDefault{
        fun yes()
        fun no()
    }

}