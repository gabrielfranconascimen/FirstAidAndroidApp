package com.gabrielfranconascimen.firstaidandroidapp.domain.di

import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidDetail
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidDetailImpl
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidList
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidListImpl
import com.gabrielfranconascimen.firstaidandroidapp.domain.firstaid.GetFirstAidMapper
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.EmailValidator
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.EmailValidatorImpl
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.PasswordValidator
import com.gabrielfranconascimen.firstaidandroidapp.domain.profile.PasswordValidatorImpl
import org.koin.dsl.module

val domainModule = module {
    single { GetFirstAidMapper() }
    single<EmailValidator> { EmailValidatorImpl() }
    single<PasswordValidator> { PasswordValidatorImpl() }
    single<GetFirstAidDetail> { GetFirstAidDetailImpl(getFirstAidRepository = get(), dispatcher = get(), mapper = get () ) }
    single<GetFirstAidList> { GetFirstAidListImpl(getFirstAidRepository = get(), dispatcher = get(), mapper = get() )}
}