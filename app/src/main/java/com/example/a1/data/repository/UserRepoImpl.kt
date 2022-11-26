package com.example.a1.data.repository

import android.content.Context
import com.example.a1.domain.models.SaveUserNameParam
import com.example.a1.domain.models.UserName
import com.example.a1.domain.repository.UserRepo


private val SHARED_PREF_NAME = "shared_pref_name"
private val KEY_FIRST_NAME = "firstName"
private val KEY_SECOND_NAME = "secondName"

class UserRepoImpl(context: Context) : UserRepo {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()

        return true
    }

    override fun getName(): UserName {


        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"") ?: ""
        val secondName = sharedPreferences.getString(KEY_SECOND_NAME,"Default") ?:"Default"

        return UserName(firstName = firstName, secondName = secondName)

    }

}