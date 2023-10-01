package com.ivanprieto.horoscapp.domain

import com.ivanprieto.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}