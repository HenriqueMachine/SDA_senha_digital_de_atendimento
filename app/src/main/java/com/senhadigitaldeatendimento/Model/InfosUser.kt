package com.senhadigitaldeatendimento.Model

import android.os.Parcel
import android.os.Parcelable

class InfosUser (

        val nome:String,
        val email:String,
        val dataNascimento:String,
        val cpf:String,
        val numeroTelefone:String

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeString(dataNascimento)
        parcel.writeString(cpf)
        parcel.writeString(numeroTelefone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InfosUser> {
        override fun createFromParcel(parcel: Parcel): InfosUser {
            return InfosUser(parcel)
        }

        override fun newArray(size: Int): Array<InfosUser?> {
            return arrayOfNulls(size)
        }
    }
}