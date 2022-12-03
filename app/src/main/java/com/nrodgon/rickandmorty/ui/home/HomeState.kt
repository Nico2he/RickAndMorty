package com.nrodgon.rickandmorty.ui.home

import com.nrodgon.rickandmorty.domain.model.Characters

data class HomeState(
    val characters: List<Characters> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false
)
