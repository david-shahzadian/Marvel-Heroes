package org.marvel.marvelheroes.mvi.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes

/**
 * Includes all the possible types of view instances to set as a content view
 */
sealed class ViewWrapper {

    /**
     * Extracts a content view
     * @param context view context instance
     * @return Extracted content view
     */
    abstract fun extractView(context: Context): View

    /**
     * Resource layout view type
     * @param res layout res
     */
    data class FromLayoutRes(
        @LayoutRes val res: Int
    ) : ViewWrapper() {

        override fun extractView(context: Context): View {
            return LayoutInflater
                .from(context)
                .inflate(res, null)
        }
    }

    /**
     * Custom view type
     * @param instance custom view instance
     */
    data class FromViewInstance(
        val instance: View
    ) : ViewWrapper() {

        override fun extractView(context: Context): View = instance
    }
}