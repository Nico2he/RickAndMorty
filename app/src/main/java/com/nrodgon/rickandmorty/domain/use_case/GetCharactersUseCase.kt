package com.nrodgon.rickandmorty.domain.use_case

import com.nrodgon.rickandmorty.data.Result
import com.nrodgon.rickandmorty.domain.model.Characters
import com.nrodgon.rickandmorty.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(page: Int): Flow<Result<List<Characters>>> {
        return repository.getCharacters(page)
    }
}