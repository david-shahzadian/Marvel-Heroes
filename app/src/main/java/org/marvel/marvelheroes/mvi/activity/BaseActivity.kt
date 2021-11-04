package org.marvel.marvelheroes.mvi.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import org.marvel.marvelheroes.mvi.data.ViewWrapper

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getActivityView(): ViewWrapper

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityView().extractView(this))
        onActivityCreated()
    }

    @CallSuper
    protected open fun onActivityCreated() {
//        Override if needed
    }
}