package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.gabrielfranconascimen.designsystem.base.FATheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstAidListFragment: Fragment() {

    private val viewModel: FirstAidListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FATheme {
                    val state by viewModel.viewState.collectAsState()
                    when {
                        state.loading -> FirstAidListScreenLoading()
                        state.error -> FirstAidListScreenError { viewModel.tryAgain() }
                        state.data != null -> {
                            state.data?.let {
                                FirstAidListScreen(content = it) { item ->
                                    FirstAidListFragmentDirections.actionFirstAidListFragmentToFirstAidDetailFragment(
                                        item.title,
                                        item.detailId
                                    ).apply { findNavController().navigate(this) }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}