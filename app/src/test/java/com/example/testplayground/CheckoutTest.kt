package com.example.testplayground

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

var prices = listOf(
    ItemPrice(name = 'A', price = 50),
    ItemPrice(name = 'B', price = 30),
    ItemPrice(name = 'C', price = 20),
    ItemPrice(name = 'D', price = 15)
)

var discountRules = listOf(
    DiscountRule(name = 'A', counter = 5, discount = 50),
    DiscountRule(name = 'A', counter = 3, discount = 20),
    DiscountRule(name = 'B', counter = 2, discount = 15)
)

class CheckoutTest {

    @Test
    fun `at the beginning checkout price is 0`() {
        assertThat(price("")).isEqualTo(0)
    }

    @Test
    fun `after scanning A checkout price is 50`() {
        assertThat(price("A")).isEqualTo(50)
    }

    @Test
    fun `after scanning B checkout price is 30`() {
        assertThat(price("B")).isEqualTo(30)
    }

    @Test
    fun `after scanning C checkout price is 20`() {
        assertThat(price("C")).isEqualTo(20)
    }

    @Test
    fun `after scanning D checkout price is 15`() {
        assertThat(price("D")).isEqualTo(15)
    }

    @Test
    fun `after scanning AA checkout price is 100`() {
        assertThat(price("AA")).isEqualTo(100)
    }

    @Test
    fun `after scanning AB checkout price is 80`() {
        assertThat(price("AB")).isEqualTo(80)
    }

    @Test
    fun `after scanning AC checkout price is 70`() {
        assertThat(price("AC")).isEqualTo(70)
    }

    @Test
    fun `after scanning AD checkout price is 65`() {
        assertThat(price("AD")).isEqualTo(65)
    }

    @Test
    fun `after scanning BB checkout price is 45`() {
        assertThat(price("BB")).isEqualTo(45)
    }

    @Test
    fun `after scanning AAA checkout price is 130`() {
        assertThat(price("AAA")).isEqualTo(130)
    }

    @Test
    fun `after scanning AAAAB checkout price is 210`() {
        assertThat(price("AAAAB")).isEqualTo(210)
    }

    @Test
    fun `after scanning AAAAA checkout price is 200`() {
        assertThat(price("AAAAA")).isEqualTo(200)
    }

    @Test
    fun `after scanning AAAAAAAA checkout price is 330`() {
        assertThat(price("AAAAAAAA")).isEqualTo(330)
    }


    fun price(good: String): Int {

        var priceBeforeDiscount = 0
        var finalPrice = 0
        var discount = 0
        val map = HashMap<Char, Int>()
        good.forEach {
            var current = map[it] ?: 0
            map[it] = ++current
        }
        good.forEach {
            priceBeforeDiscount += itemPrice(it.toString())
        }
        discount = getTotalDiscount(map)
        finalPrice = priceBeforeDiscount - discount
        return finalPrice
    }

    private fun getTotalDiscount(map: HashMap<Char, Int>): Int {
        var discount = 0
        map.forEach { (item, number) ->
            when (item) {
                'A' -> {
                    var currentNumber = map[item] ?: 0

                    // Big A discount
                    val bigACounter = currentNumber / 5
                    currentNumber -= bigACounter * 5
                    discount += bigACounter * 50

                    // Small A discount
                    val smallACounter = currentNumber / 3
                    currentNumber -= smallACounter * 3
                    discount += smallACounter * 20

                }
                'B' -> discount += (number / 2) * 15
            }

        }
        return discount
    }

    private fun itemPrice(good: String): Int {
        return when (good) {
            "A" -> 50
            "B" -> 30
            "C" -> 20
            "D" -> 15
            else -> 0
        }
    }
}

class ItemPrice(name: Char, price: Int)

class DiscountRule(val name: Char, val counter: Int, val discount: Int)
