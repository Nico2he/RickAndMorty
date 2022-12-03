package com.nrodgon.rickandmorty.ui.detail

import com.nrodgon.rickandmorty.domain.model.Character

data class DetailState(
    val character: Character? = null,
    val isLoading: Boolean = false
)