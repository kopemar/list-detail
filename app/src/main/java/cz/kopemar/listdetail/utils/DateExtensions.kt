package cz.kopemar.listdetail.utils

import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun String.parseDate(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDateTime.parse(this.dropLast(1))
            .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))
    } else {
        this
    }
}