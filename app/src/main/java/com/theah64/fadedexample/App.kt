package com.theah64.fadedexample

import android.app.Application
import com.theah64.faded.Faded

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Faded.init(
            dueDate = "2019-01-12",
            daysDeadline = 32
        )
    }
}

