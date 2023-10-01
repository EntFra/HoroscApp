package com.ivanprieto.horoscapp.ui.horoscope

import com.ivanprieto.horoscapp.data.providers.HoroscopeProvider
import com.ivanprieto.horoscapp.motherobject.HoroscopeModelObject.horoscopeInfoList
import io.kotlintest.inspectors.forExactly
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun whenViewModelIsCreatedThenHoroscopesAreLoaded(){
        every { horoscopeProvider.getHoroscope() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value

        assertTrue(horoscopes.isNotEmpty())

    }
}