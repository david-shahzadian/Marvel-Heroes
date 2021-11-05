package org.marvel.marvelheroes.mvi.fragment

import android.widget.Button
import android.widget.TextView
import org.marvel.marvelheroes.R
import org.marvel.marvelheroes.mvi.data.ViewWrapper
import org.marvel.marvelheroes.mvi.viewevent.TestViewEvent
import org.marvel.marvelheroes.mvi.viewstate.TestViewState

@Deprecated("To be removed")
class TestFragment : BaseFragment<TestViewState, TestViewEvent>() {

    override fun getContentView(): ViewWrapper {
        return ViewWrapper.FromLayoutRes(R.layout.fragment_test)
    }

    override fun getViewStateClass(): Class<TestViewState> {
        return TestViewState::class.java
    }

    override fun onViewStateChangeRequired(state: TestViewState) {
        val view = requireView()
        val textView = view.findViewById<TextView>(R.id.textView)
        when (state) {

            is TestViewState.Loading -> {
                textView.text = "Loading"
            }

            is TestViewState.ShowText -> {
                textView.text = state.text
            }
        }
    }

    override fun onViewCreated() {
        super.onViewCreated()
        requireView()
            .findViewById<Button>(R.id.button)
            .setOnClickListener {
                sendViewEvent(TestViewEvent.OnButtonClicked)
            }
    }
}