package com.example.composition.data

import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.entity.Level
import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.Repository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random


private const val MIN_SUM_VALUE = 2
private const val MIN_ANSWER_VALUE = 1

object RepositoryImpl : Repository {
    override fun generationQuestion(maxSumValue: Int, countOfOPtion: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue - 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val option = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        option.add(rightAnswer)
        val from = max( rightAnswer - countOfOPtion, MIN_ANSWER_VALUE)
        val to = min(maxSumValue - 1,rightAnswer + countOfOPtion)
        while (option.size < countOfOPtion){
            option.add(Random.nextInt(from,to))
        }

        return Question(sum,visibleNumber,option.toList())
    }

    override fun getGamSrttings(level: Level): GameSettings {
        return when(level){
            Level.TEST -> GameSettings(
                10,
                3,
                50,
                8
            )
            Level.EASY -> GameSettings(
                10,
                10,
                70,
                60
            )
            Level.NORMAL -> GameSettings(
                20,
                20,
                80,
                40
            )
            Level.HARD -> GameSettings(
                30,
                30,
                90,
                20
            )
        }
    }
}