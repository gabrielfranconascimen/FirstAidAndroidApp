package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.detail

import com.gabrielfranconascimen.firstaidandroidapp.common.FADispatcherTest
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailMapper
import com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details.FirstAidDetailViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FirstAidDetailViewModelTest {

    private val dispatchers = FADispatcherTest()

    private val getFirstAidDetail: GetFirstAidDetail = mockk()
    private val mapper: FirstAidDetailMapper = mockk(relaxed = true)

    private lateinit var viewModel: FirstAidDetailViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatchers.main)
        viewModel = FirstAidDetailViewModel(
            getFirsAidDetail = getFirstAidDetail,
            mapper = mapper
        )
    }


    @Test
    fun `Should load data when return first aid details success`() {
        coEvery { getFirstAidDetail.execute(any()) } returns FirstAidDetailMock.mockRepository()
        every { mapper.mapSteps(any()) } returns FirstAidDetailMock.mapSteps()

        viewModel.start("", " ")
        viewModel.loadData()

        assertFalse(viewModel.viewState.value.loading)
        assertFalse(viewModel.viewState.value.error)
        assert(viewModel.viewState.value.data != null)
        assert(viewModel.viewState.value.data?.steps?.size == 3)
    }

    @Test
    fun `Should error when return repository error`() {
        coEvery { getFirstAidDetail.execute(any()) } returns null
        every { mapper.mapSteps(any()) } returns null

        viewModel.loadData()

        assertFalse(viewModel.viewState.value.loading)
        assertTrue(viewModel.viewState.value.error)
        assert(viewModel.viewState.value.data == null)
    }

}