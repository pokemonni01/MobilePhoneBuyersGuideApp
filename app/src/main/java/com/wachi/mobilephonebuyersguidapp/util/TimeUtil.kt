package com.wachi.weatherforecast.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by WachiGO on 19/5/2018 AD
 */
object TimeUtil {

    fun getDateTime(timeStamp: String, dateFormat: String): String? {
        return try {
            val sdf = SimpleDateFormat(dateFormat, Locale.US)
            val netDate = Date(timeStamp.toLong() * 1000)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

    fun getCurrentDateTime(dateFormat: String): String {
        return try {
            val sdf = SimpleDateFormat(dateFormat, Locale.US)
            val netDate = Date(System.currentTimeMillis())
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

    fun parse(inputDate: String, oldFormat: String, newFormat: String): String {
        return try {
            val parser = SimpleDateFormat(oldFormat, Locale.US)
            val date = parser.parse(inputDate)
            val formatter = SimpleDateFormat(newFormat, Locale.US)
            formatter.format(date)
        } catch (e: Exception) {
            e.toString()
        }
    }
}