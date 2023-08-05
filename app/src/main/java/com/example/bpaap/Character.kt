package com.example.bpaap

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val name: String,
    val description: String,
    val photo: Int,
    val birthday: String,
    val bounty: String,
) : Parcelable
