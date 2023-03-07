package com.amroid.dose.viewmodels


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amroid.dose.ui.screens.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: LoginViewModel
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = LoginViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `when login button clicked with non-empty email and password then isLoading should be true`() =
        runTest {
            viewModel.onEmailChanged("test@test.com")
            viewModel.onPasswordChanged("password")
            viewModel.onLoginClicked()
            assert(viewModel.isLoading)
        }

    @Test
    fun `when login button clicked with empty email and password then isLoading should be false`() =
        runTest{
            viewModel.onEmailChanged("")
            viewModel.onPasswordChanged("")
            viewModel.onLoginClicked()
            assert(!viewModel.isLoading)
        }
}
