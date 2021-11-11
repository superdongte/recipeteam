package com.example.recipeteam.recipe

import android.os.Parcel
import android.os.Parcelable

data class Cook (
    var cookid: Int,
    var cname: String,
    var cimage: String?,
    var crecipe: String,
    var cookcontent: String,
    var crank: Int
        ) : Parcelable {
    constructor(parcel: Parcel) : this (
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(cookid)
        dest.writeString(cname)
        dest.writeString(cimage)
        dest.writeString(crecipe)
        dest.writeString(cookcontent)
        dest.writeInt(crank)
    }


    companion object CREATOR : Parcelable.Creator<Cook> {
        override fun createFromParcel(parcel: Parcel): Cook {
            return Cook(parcel)
        }

        override fun newArray(size: Int): Array<Cook?> {
            return arrayOfNulls(size)
        }
    }
}
