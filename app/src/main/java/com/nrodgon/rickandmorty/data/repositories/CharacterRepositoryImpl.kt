package com.nrodgon.rickandmorty.data.repositories

import com.nrodgon.rickandmorty.data.Result
import com.nrodgon.rickandmorty.data.source.remote.RickAndMortyApi
import com.nrodgon.rickandmorty.data.source.remote.dto.toCharacter
import com.nrodgon.rickandmorty.data.source.remote.dto.toListCharacters
import com.nrodgon.rickandmorty.domain.model.Character
import com.nrodgon.rickandmorty.domain.model.Characters
import com.nrodgon.rickandmorty.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): CharacterRepository{

    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow{
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(Result.Error(
                message = "Oops, algo ha salido mal",
                data = null
            ))
        } catch (e: IOException) {
            emit(Result.Error(
                message = "No se ha podido conectar con el servidor, compruebe su conexión",
                data = null
            ))
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        val response = try {
            api.getCharacter(id)
        } catch (e: Exception) {
            return Result.Error("Ha ocurrido un error desconocido")
        }
        return Result.Success(response.toCharacter())
    }
}