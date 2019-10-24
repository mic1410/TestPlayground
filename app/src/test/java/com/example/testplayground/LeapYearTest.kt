package com.example.testplayground

import com.example.testplayground.utils.YearUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LeapYearTest {

    @Test
    fun `2004 is a normal leap year😊`() {
        //given
        val year = 2004

        //when
        val result = YearUtils().isLeapYear(year)

        //then
        assertThat(result).isTrue()
    }

    @Test
    fun `2005 is not a leap year`() {
        //given
        val year = 2005

        //when
        val result = YearUtils().isLeapYear(year)

        //then
        assertThat(result).isFalse()
    }

    @Test
    fun `1900 is not a leap year`() {
        assertThat(YearUtils().isLeapYear(1900)).isFalse()
    }

    @Test
    fun `2000 is a leap year`() {
        assertThat(YearUtils().isLeapYear(2000)).isTrue()
    }

    //given
    //when
    //then
}