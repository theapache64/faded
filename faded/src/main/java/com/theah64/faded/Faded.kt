package com.theah64.faded

import android.content.Context
import android.content.ContextWrapper
import io.github.inflationx.viewpump.ViewPump
import io.github.inflationx.viewpump.ViewPumpContextWrapper

class Faded {
    companion object {
        fun init(dueDate: String, daysDeadline: Int) {
            ViewPump.init(
                ViewPump.builder()
                    .addInterceptor(FadedInterceptor())
                    .build()
            )
        }

        fun wrap(newBase: Context): ContextWrapper {
            return ViewPumpContextWrapper.wrap(newBase)
        }
    }
}