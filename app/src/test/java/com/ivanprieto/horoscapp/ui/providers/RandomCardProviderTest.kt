package com.ivanprieto.horoscapp.ui.providers

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest{

    @Test
    fun getRandomCardShouldReturnARandomCard(){
        val randoomCard = RandomCardProvider()

        val card = randoomCard.getLucky()

        assertNotNull(card)

    }
}