package com.nrodgon.rickandmorty.domain.repositories

import com.nrodgon.rickandmorty.data.Result
import com.nrodgon.rickandmorty.domain.model.Character
import com.nrodgon.rickandmorty.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(page: Int): Flow<Result<List<Characters>>>

    suspend fun getCharacter(id: Int): Result<Character>
}