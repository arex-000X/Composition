package com.example.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val masSumValue: Int,
    val minCountRightAnswers: Int,
    val minPrecentRightAnswwers:Int,
    val gameTimeInSeconds:Int
    ): Parcelable
