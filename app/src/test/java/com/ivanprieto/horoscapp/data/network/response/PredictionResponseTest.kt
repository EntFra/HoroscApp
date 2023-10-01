package com.ivanprieto.horoscapp.data.network.response

import com.ivanprieto.horoscapp.motherobject.HoroscopeModelObject
import com.ivanprieto.horoscapp.motherobject.HoroscopeModelObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest{

    @Test
    fun toDomainShouldReturnCorrectPredictionModel(){
        //Given
        val horoscopeResponse = anyResponse

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe  horoscopeResponse.horoscope
    }
}