package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.detail

import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailMapper
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FirstAidDetailMapperTest {

    private val mapper = FirstAidDetailMapper()

    @Test
    fun `Should verify initial view state when title`() {
        val result = mapper.mapInitialState("Test 1")

        assertTrue(result.loading)
        assertFalse(result.error)
        assert(result.data != null)
        assert(result.data?.title == "Test 1")
    }

    @Test
    fun `Should screen entity when return success`() {
        val result = mapper.mapSteps(FirstAidDetailMock.mockRepository())

        assert(result.title == "Procedimentos")
        assert(result.steps[0].step == "1")
        assert(result.steps[0].label == "Procedimento 0")
        assert(result.steps[2].step == "3")
    }
}