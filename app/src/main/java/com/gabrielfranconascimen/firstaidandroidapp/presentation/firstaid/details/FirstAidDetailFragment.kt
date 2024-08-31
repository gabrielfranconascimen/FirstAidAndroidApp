package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gabrielfranconascimen.designsystem.base.FATheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstAidDetailFragment : Fragment() {

    private val viewModel: FirstAidDetailViewModel by viewModel()
    private val args: FirstAidDetailFragmentArgs by navArgs()

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
                    FirstAidDetailScreen(
                        title = state.data?.title ?: "",
                        firstAidDetails = state.data?.steps,
                        isLoading = state.loading,
                        isError = state.error,
                        onErrorAction = { viewModel.tryAgain() }
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.start(args.title, args.detailId)
    }

}
