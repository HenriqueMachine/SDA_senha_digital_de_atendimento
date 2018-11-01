package com.senhadigitaldeatendimento.Model

import android.os.Parcel
import android.os.Parcelable

class MinhaSenha (

        val categoria:String,
        val numeroSenha:String,
        val hour:String


) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(categoria)
        parcel.writeString(numeroSenha)
        parcel.writeString(hour)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MinhaSenha> {
        override fun createFromParcel(parcel: Parcel): MinhaSenha {
            return MinhaSenha(parcel)
        }

        override fun newArray(size: Int): Array<MinhaSenha?> {
            return arrayOfNulls(size)
        }
    }
}