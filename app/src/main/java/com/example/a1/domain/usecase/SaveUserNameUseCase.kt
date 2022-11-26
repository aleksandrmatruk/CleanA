package com.example.a1.domain.usecase

import com.example.a1.domain.models.SaveUserNameParam
import com.example.a1.domain.repository.UserRepo

class SaveUserNameUseCase(private val userRepo: UserRepo) {

    fun execute(param: SaveUserNameParam): Boolean {

        val result: Boolean = userRepo.saveName(saveParam = param)
        return result

    }

}