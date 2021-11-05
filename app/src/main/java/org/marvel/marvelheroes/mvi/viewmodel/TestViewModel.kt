package org.marvel.marvelheroes.mvi.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.marvel.marvelheroes.mvi.viewevent.TestViewEvent
import org.marvel.marvelheroes.mvi.viewstate.TestViewState

//TODO remove before release
@Deprecated("To be removed")
class TestViewModel : BaseViewModel<TestViewState, TestViewEvent>() {

    override fun getDefaultViewState(): TestViewState {
        return TestViewState.ShowText("Before click")
    }

    override fun onViewEvent(event: TestViewEvent) {
        when (event) {
            is TestViewEvent.OnButtonClicked -> {
                viewModelScope
                    .launch {

                    }
            }
        }
    }
}