package com.example.testplayground.utils

var prices: Map<Char, Int> = listOf(
    ItemPrice(name = 'A', price = 50),
    ItemPrice(name = 'B', price = 30),
    ItemPrice(name = 'C', price = 20),
    ItemPrice(name = 'D', price = 15)
).associateBy { it.name }.mapValues { it.value.price }

var discountRules = listOf(
    DiscountRule(name = 'A', counter = 5, discount = 50),
    DiscountRule(name = 'A', counter = 3, discount = 20),
    DiscountRule(name = 'B', counter = 2, discount = 15)
)

class CheckoutCalculator {


    fun price(item: String): Int {

        var priceBeforeDiscount = 0
        var finalPrice = 0
        var discount = 0
        val map = HashMap<Char, Int>()
        item.forEach {
            var current = map[it] ?: 0
            map[it] = ++current
        }
        item.forEach {
            priceBeforeDiscount += getItemPrice(it)
        }
        discount = getTotalDiscount(map)
        finalPrice = priceBeforeDiscount - discount
        return finalPrice
    }

    private fun getTotalDiscount(map: HashMap<Char, Int>): Int {
        var discount = 0
        discountRules.forEach { rule ->
            val currentNumber = map[rule.name]
            currentNumber?.let {
                val counter = currentNumber / rule.counter
                map[rule.name] = currentNumber - counter * rule.counter
                discount += counter * rule.discount
            }
        }
        return discount
    }

    private fun getItemPrice(name: Char): Int {
        return prices[name] ?: 0
    }
}

class ItemPrice(val name: Char, val price: Int)

class DiscountRule(val name: Char, val counter: Int, val discount: Int)
