package com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid

import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAid
import com.gabrielfranconascimen.firstaidandroidapp.common.models.FirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidDetailResponse
import com.gabrielfranconascimen.firstaidandroidapp.data.models.FirstAidResponse

class GetFirstAidMapper {
    fun mapDetailResponseToDetail(response: FirstAidDetailResponse): FirstAidDetail {
        return FirstAidDetail(
            identifier = response.identifier,
            steps = response.steps
        )
    }

    fun mapFirstAidResponseToFirstAid(response: FirstAidResponse): FirstAid {
        return FirstAid(
            title = response.title,
            description = response.description,
            detailId = response.detailsId?.id ?: ""
        )
    }
}