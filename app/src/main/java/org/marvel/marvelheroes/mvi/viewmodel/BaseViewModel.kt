package org.marvel.marvelheroes.mvi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.marvel.marvelheroes.mvi.viewevent.ViewEvent
import org.marvel.marvelheroes.mvi.viewstate.ViewState

@Deprecated("To be removed")
abstract class BaseViewModel<VS : ViewState, VE : ViewEvent> : ViewModel() {

    private val viewMutableStateFlow by lazy {
        MutableStateFlow(getDefaultViewState())
    }
    val viewStateFlow: StateFlow<VS>
        get() = viewMutableStateFlow

    abstract fun onViewEvent(event: VE)

    protected abstract fun getDefaultViewState(): VS

    protected fun setViewState(state: VS) {
        viewModelScope
            .launch {
                viewMutableStateFlow.emit(state)
            }
    }
}