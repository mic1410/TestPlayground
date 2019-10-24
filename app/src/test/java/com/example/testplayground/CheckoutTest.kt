package com.example.testplayground

import com.example.testplayground.utils.CheckoutCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test



class CheckoutTest {

    @Test
    fun `at the beginning checkout price is 0`() {
        assertThat(CheckoutCalculator().price("")).isEqualTo(0)
    }

    @Test
    fun `after scanning A checkout price is 50`() {
        assertThat(CheckoutCalculator().price("A")).isEqualTo(50)
    }

    @Test
    fun `after scanning B checkout price is 30`() {
        assertThat(CheckoutCalculator().price("B")).isEqualTo(30)
    }

    @Test
    fun `after scanning C checkout price is 20`() {
        assertThat(CheckoutCalculator().price("C")).isEqualTo(20)
    }

    @Test
    fun `after scanning D checkout price is 15`() {
        assertThat(CheckoutCalculator().price("D")).isEqualTo(15)
    }

    @Test
    fun `after scanning AA checkout price is 100`() {
        assertThat(CheckoutCalculator().price("AA")).isEqualTo(100)
    }

    @Test
    fun `after scanning AB checkout price is 80`() {
        assertThat(CheckoutCalculator().price("AB")).isEqualTo(80)
    }

    @Test
    fun `after scanning AC checkout price is 70`() {
        assertThat(CheckoutCalculator().price("AC")).isEqualTo(70)
    }

    @Test
    fun `after scanning AD checkout price is 65`() {
        assertThat(CheckoutCalculator().price("AD")).isEqualTo(65)
    }

    @Test
    fun `after scanning BB checkout price is 45`() {
        assertThat(CheckoutCalculator().price("BB")).isEqualTo(45)
    }

    @Test
    fun `after scanning AAA checkout price is 130`() {
        assertThat(CheckoutCalculator().price("AAA")).isEqualTo(130)
    }

    @Test
    fun `after scanning AAAAB checkout price is 210`() {
        assertThat(CheckoutCalculator().price("AAAAB")).isEqualTo(210)
    }

    @Test
    fun `after scanning AAAAA checkout price is 200`() {
        assertThat(CheckoutCalculator().price("AAAAA")).isEqualTo(200)
    }

    @Test
    fun `after scanning AAAAAAAA checkout price is 330`() {
        assertThat(CheckoutCalculator().price("AAAAAAAA")).isEqualTo(330)
    }
}
