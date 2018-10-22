package com.senhadigitaldeatendimento.Model

import android.os.Parcel
import android.os.Parcelable

class UltimaSenha(

        val topico:String,
        val numeroSenha:Int

) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(topico)
        parcel.writeInt(numeroSenha)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UltimaSenha> {
        override fun createFromParcel(parcel: Parcel): UltimaSenha {
            return UltimaSenha(parcel)
        }

        override fun newArray(size: Int): Array<UltimaSenha?> {
            return arrayOfNulls(size)
        }
    }
}