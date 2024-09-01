package com.gabrielfranconascimen.firstaidandroidapp.domain.di

import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidDetailImpl
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidList
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidListImpl
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidMapper
import org.koin.dsl.module

val domainModule = module {
    single { GetFirstAidMapper() }
    single<GetFirstAidDetail> { GetFirstAidDetailImpl(getFirstAidRepository = get(), dispatcher = get(), mapper = get () ) }
    single<GetFirstAidList> { GetFirstAidListImpl(getFirstAidRepository = get(), dispatcher = get(), mapper = get() )}
}