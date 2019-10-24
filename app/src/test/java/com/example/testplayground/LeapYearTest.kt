package com.example.testplayground

import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.junit.Test

class LeapYearTest {

    @Test
    fun `2004 is a normal leap year😊`() {
        //given
        val year = 2004

        //when
        val result = isLeapYear(year)

        //then
        assertThat(result).isTrue()
    }

    @Test
    fun `2005 is not a leap year`() {
        //given
        val year = 2005

        //when
        val result = isLeapYear(year)

        //then
        assertThat(result).isFalse()
    }

    @Test
    fun `1900 is not a leap year`() {
        assertThat(isLeapYear(1900)).isFalse()
    }

    @Test
    fun `2000 is a leap year`() {
        assertThat(isLeapYear(2000)).isTrue()
    }

    private fun isLeapYear(year: Int): Boolean {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
    }

    //given
    //when
    //then
}