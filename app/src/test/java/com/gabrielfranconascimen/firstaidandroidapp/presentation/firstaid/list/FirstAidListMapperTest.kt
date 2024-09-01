package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import org.junit.Test

class FirstAidListMapperTest {

    private val mapper = FirstAidListMapper()

    private val expectedResult = listOf(
        FirstAidListScreenEntity(
            title = "Title 1",
            description = "Description 1",
            detailId = "id_1"
        ),
        FirstAidListScreenEntity(
            title = "Title 2",
            description = "Description 2",
            detailId = "id_2"
        ),
        FirstAidListScreenEntity(
            title = "Title 3",
            description = "Description 3",
            detailId = "id_3"
        )
    )

    @Test
    fun `Should mapper whe receive list`() {
        val expected = mapper.map(FirstAidListMock.mockRepositorySuccess())

        assert(expected.size == 3)
        assert(expected[1].title == expectedResult[1].title)
        assert(expected[2].description == expectedResult[2].description)
        assert(expected[1].detailId == expectedResult[1].detailId)
    }
}