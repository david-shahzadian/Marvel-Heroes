package org.marvel.marvelheroes.mvi.viewmodel

import org.marvel.marvelheroes.mvi.viewstate.TestViewState
import org.marvel.marvelheroes.mvi.viewstate.ViewState

object ViewModelFactory {

    fun getByViewState(viewStateClass: Class<ViewState>): BaseViewModel<*, *> {
        return when (viewStateClass) {
            TestViewState::class.java -> TestViewModel()
            else -> TODO()
        }
    }
}