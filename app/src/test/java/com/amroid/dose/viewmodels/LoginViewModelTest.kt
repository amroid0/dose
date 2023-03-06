package com.amroid.dose.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amroid.dose.MainCoroutineRule
import com.amroid.dose.ui.screens.login.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        viewModel = LoginViewModel()
    }

    @After
    fun tearDown() {
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `when login button clicked with non-empty email and password then isLoading should be true`() =
        testDispatcher.runBlockingTest {
            viewModel.onEmailChanged("test@test.com")
            viewModel.onPasswordChanged("password")
            viewModel.onLoginClicked()
            assert(viewModel.isLoading)
        }

    @Test
    fun `when login button clicked with empty email and password then isLoading should be false`() =
        testDispatcher.runBlockingTest {
            viewModel.onEmailChanged("")
            viewModel.onPasswordChanged("")
            viewModel.onLoginClicked()
            assert(!viewModel.isLoading)
        }

}
