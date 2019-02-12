package com.theah64.faded

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import io.github.inflationx.viewpump.ViewPump
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class Faded {
    companion object {

        @SuppressLint("ConstantLocale")
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        fun init(dueDate: String, daysDeadline: Int) {

            val alpha = calcAlpha(dueDate, daysDeadline)

            ViewPump.init(
                ViewPump.builder()
                    .addInterceptor(FadedInterceptor(alpha))
                    .build()
            )
        }

        private fun calcAlpha(date: String, daysDeadline: Int): Float {

            val curDate = Calendar.getInstance().time
            val dueDate = parseDate(date)
            if (curDate.after(dueDate)) {
                // Due date expired, let's calc alpha
                val daysPassed = getDaysPassed(curDate, dueDate)
                val percentageFinished = (daysPassed * 100f) / daysDeadline
                // converting to 0 - 1
                return 1f - (percentageFinished / 100)

            }

            return -1f
        }

        private fun getDaysPassed(curDate: Date, dueDate: Date): Long {
            val diff = curDate.time - dueDate.time
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
        }

        private fun parseDate(date: String): Date {
            return dateFormat.parse(date)
        }

        fun wrap(newBase: Context): ContextWrapper {
            return ViewPumpContextWrapper.wrap(newBase)
        }
    }
}