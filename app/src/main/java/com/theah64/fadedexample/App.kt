package com.theah64.fadedexample

import android.app.Application
import com.theah64.faded.Faded

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Faded.init(
            dueDate = "2021-01-10", // Jan 10, 2021
            daysDeadline = 15
        )
    }
}

