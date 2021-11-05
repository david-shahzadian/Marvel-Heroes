package org.marvel.marvelheroes.mvi.viewstate

sealed class TestViewState : ViewState {

    object Loading : TestViewState()

    data class ShowText(
        val text: String
    ) : TestViewState()
}