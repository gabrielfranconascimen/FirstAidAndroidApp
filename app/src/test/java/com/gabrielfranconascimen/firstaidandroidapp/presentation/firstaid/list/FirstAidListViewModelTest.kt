package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import com.gabrielfranconascimen.firstaidandroidapp.common.FADispatcherTest
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidList
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
class FirstAidListViewModelTest {

    private val getList: GetFirstAidList = mockk()
    private val mapper: FirstAidListMapper = mockk()

    private val dispatchersTest = FADispatcherTest()

    private lateinit var viewModel: FirstAidListViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatchersTest.main)
        viewModel = FirstAidListViewModel(getList = getList, mapper = mapper)
    }

    @Test
    fun `Should load data when return first aid success` () {
        coEvery { getList.execute() } returns FirstAidListMock.mockRepositorySuccess()
        every { mapper.map(any()) } returns FirstAidListMock.mockMapperSuccess()

        viewModel.loadData()

        assertFalse(viewModel.viewState.value.loading)
        assertFalse(viewModel.viewState.value.error)
        assert(viewModel.viewState.value.data != null)
        assert(viewModel.viewState.value.data?.size == 3)
    }

    @Test
    fun `Should error when return first aid is empty`() {
        coEvery { getList.execute() } returns listOf()
        every { mapper.map(any()) } returns listOf()

        viewModel.loadData()

        assertFalse(viewModel.viewState.value.loading)
        assertTrue(viewModel.viewState.value.error)
        assert(viewModel.viewState.value.data == null)
    }

    @Test
    fun `Should error when return repository error`() {
        coEvery { getList.execute() } returns null
        every { mapper.map(any()) } returns listOf()

        viewModel.loadData()

        assertFalse(viewModel.viewState.value.loading)
        assertTrue(viewModel.viewState.value.error)
        assert(viewModel.viewState.value.data == null)
    }
}