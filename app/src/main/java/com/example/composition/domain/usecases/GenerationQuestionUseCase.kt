package com.example.composition.domain.usecases

import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.Repository

class GenerationQuestionUseCase(private val repository: Repository) {
    operator fun invoke(maxSumValue: Int): Question {
        return repository.generationQuestion(maxSumValue, COUNT_OF_OPTION)
    }

    private companion object {
        const val COUNT_OF_OPTION = 6
    }
}