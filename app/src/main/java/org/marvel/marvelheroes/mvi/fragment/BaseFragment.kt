package org.marvel.marvelheroes.mvi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.marvel.marvelheroes.mvi.data.ViewWrapper
import org.marvel.marvelheroes.mvi.viewevent.ViewEvent
import org.marvel.marvelheroes.mvi.viewmodel.BaseViewModel
import org.marvel.marvelheroes.mvi.viewmodel.ViewModelFactory
import org.marvel.marvelheroes.mvi.viewstate.ViewState

abstract class BaseFragment<VS : ViewState, VE : ViewEvent> : Fragment() {

    protected abstract fun getContentView(): ViewWrapper

    protected abstract fun getViewStateClass(): Class<VS>

    private lateinit var viewModel: BaseViewModel<VS, VE>

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container
            ?.let {
                getContentView().extractView(it.context)
            }
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelFactory.getByViewState(getViewStateClass() as Class<ViewState>) as BaseViewModel<VS, VE>
        viewLifecycleOwner
            .lifecycleScope
            .launchWhenStarted {
                viewModel
                    .viewStateFlow
                    .onEach {
                        onViewStateChangeRequired(it)
                    }
                    .collect()
            }
        onViewCreated()
    }

    @CallSuper
    protected open fun onViewCreated() {
//        Override if needed
    }

    protected abstract fun onViewStateChangeRequired(state: VS)

    protected fun sendViewEvent(event: VE) {
        viewModel.onViewEvent(event)
    }
}