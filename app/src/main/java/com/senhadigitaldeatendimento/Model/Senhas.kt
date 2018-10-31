package com.senhadigitaldeatendimento.Model

import android.os.Parcel
import android.os.Parcelable

class Senhas(

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

    companion object CREATOR : Parcelable.Creator<Senhas> {
        override fun createFromParcel(parcel: Parcel): Senhas {
            return Senhas(parcel)
        }

        override fun newArray(size: Int): Array<Senhas?> {
            return arrayOfNulls(size)
        }
    }
}