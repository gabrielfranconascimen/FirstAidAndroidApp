package com.gabrielfranconascimen.firstaidandroidapp.presentation.profile.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.gabrielfranconascimen.designsystem.base.FATheme
import com.gabrielfranconascimen.designsystem.components.dialogs.FADialogError
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment: Fragment() {

    private val viewModel: SignInViewModel by viewModel()

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
                    state.data?.let {
                        SignInScreen(
                            content = it,
                            screenActions = viewModel
                        )
                    }
                    if(state.error) {
                        FADialogError(
                            message = "Email ou senha inválido!"
                        ) {
                            viewModel.closeDialogError()
                        }
                    }
                }
            }
        }
    }
}