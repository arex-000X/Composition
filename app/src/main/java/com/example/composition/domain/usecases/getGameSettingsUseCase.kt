package com.example.composition.domain.usecases

import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.entity.Level
import com.example.composition.domain.repository.Repository

class getGameSettingsUseCase(private val repository: Repository) {

    operator fun invoke(level:Level):GameSettings{
        return repository.getGamSrttings(level)
    }


}