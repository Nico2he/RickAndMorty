package com.nrodgon.rickandmorty.domain.use_case

import com.nrodgon.rickandmorty.data.Result
import com.nrodgon.rickandmorty.domain.model.Character
import com.nrodgon.rickandmorty.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<Character> {
        return repository.getCharacter(id)
    }
}