package com.example.composition.domain.repository

import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.entity.Level
import com.example.composition.domain.entity.Question

interface Repository {

    fun generationQuestion(
        maxSumValue: Int,
        countOfOPtion: Int
    ): Question

    fun getGamSrttings(level:Level):GameSettings

}