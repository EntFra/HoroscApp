package com.ivanprieto.horoscapp.ui.detail

import com.ivanprieto.horoscapp.domain.model.PredictionModel
import com.ivanprieto.horoscapp.domain.usecase.GetPredictionUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HoroscopeDetailViewModelTest {

    @Mock
    private lateinit var getPredictionUseCase: GetPredictionUseCase

    @Test
    fun testGetHoroscopeWhenUseCaseReturnsValidResultThenStateIsSuccess() = runBlockingTest {
        // Arrange
        val sign = "Aries"
        val predictionModel = PredictionModel("Good luck today", sign)
        Mockito.`when`(getPredictionUseCase(sign)).thenReturn(predictionModel)
        val viewModel = HoroscopeDetailViewModel(getPredictionUseCase)

        // Act
        viewModel.getHoroscope(sign)

        // Assert
        val state = viewModel.state.value
        Assert.assertTrue(state is HoroscopeDetailState.Success)
        Assert.assertEquals(
            (state as HoroscopeDetailState.Success).prediction,
            predictionModel.horoscope
        )
        Assert.assertEquals(state.sign, predictionModel.sign)
    }

    @Test
    fun testGetHoroscopeWhenUseCaseReturnsNullResultThenStateIsError() = runBlockingTest {
        // Arrange
        val sign = "Aries"
        Mockito.`when`(getPredictionUseCase(sign)).thenReturn(null)
        val viewModel = HoroscopeDetailViewModel(getPredictionUseCase)

        // Act
        viewModel.getHoroscope(sign)

        // Assert
        val state = viewModel.state.value
        Assert.assertTrue(state is HoroscopeDetailState.Error)
    }
}