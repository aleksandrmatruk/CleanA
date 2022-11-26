package com.example.a1.domain.repository

import com.example.a1.domain.models.SaveUserNameParam
import com.example.a1.domain.models.UserName

interface UserRepo {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName


}