package com.example.a1.domain.usecase

import com.example.a1.domain.models.UserName
import com.example.a1.domain.repository.UserRepo

class GetUserNameUseCase(private val userRepo: UserRepo) {

    fun execute(): UserName{
        return userRepo.getName()

    }

}