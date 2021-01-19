package com.theah64.faded

import android.util.Log
import android.view.ViewGroup
import io.github.inflationx.viewpump.InflateResult
import io.github.inflationx.viewpump.Interceptor

class FadedInterceptor(private val alpha: Float) : Interceptor {

    init {
        Log.d("FadedInterceptor", "Alpha is '$alpha'")
    }

    override fun intercept(chain: Interceptor.Chain): InflateResult {
        val result = chain.proceed(chain.request())
        if (alpha != -1f) {
            result.view?.let {

                if (it !is ViewGroup) {
                    it.alpha = alpha
                }
            }
        }
        return result
    }

}