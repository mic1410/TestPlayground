package com.example.testplayground.utils

class YearUtils {
    fun isLeapYear(year: Int): Boolean {
        return isNormalLeapYear(year) && (isSpecialLeapYear(year))
    }

    fun isNormalLeapYear(year: Int) = year % 4 == 0

    fun isSpecialLeapYear(year: Int) = year % 100 != 0 || year % 400 == 0
}