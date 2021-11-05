package org.marvel.marvelheroes.mvi.activity

import org.marvel.marvelheroes.R
import org.marvel.marvelheroes.mvi.data.ViewWrapper
import org.marvel.marvelheroes.mvi.fragment.TestFragment

class MainActivity : BaseActivity() {

    override fun getActivityView(): ViewWrapper {
        return ViewWrapper.FromLayoutRes(R.layout.activity_main)
    }

    override fun onActivityCreated() {
        super.onActivityCreated()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root, TestFragment())
            .commit()
    }
}