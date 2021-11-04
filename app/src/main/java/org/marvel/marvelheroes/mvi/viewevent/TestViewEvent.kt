package org.marvel.marvelheroes.mvi.viewevent

@Deprecated("To be removed")
sealed class TestViewEvent : ViewEvent {

    object OnButtonClicked : TestViewEvent()
}