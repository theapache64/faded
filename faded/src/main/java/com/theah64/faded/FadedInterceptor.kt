package com.theah64.faded

import android.util.Log
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import io.github.inflationx.viewpump.InflateResult
import io.github.inflationx.viewpump.Interceptor

class FadedInterceptor(private val alpha: Float) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): InflateResult {
        val result = chain.proceed(chain.request())
        if (alpha != -1f) {
            result.view()?.let {
                Log.e("X", "View is ${it.javaClass.simpleName}")

                if (
                    it !is ConstraintLayout &&
                    it !is RelativeLayout &&
                    it !is LinearLayout &&
                    it !is FrameLayout
                ) {
                    it.alpha = alpha
                }
            }
        }
        return result
    }

}