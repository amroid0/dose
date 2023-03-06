package com.amroid.dose.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amroid.dose.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    var user by mutableStateOf(User("", ""))
        private set
    var isLoading by mutableStateOf(false)
        private set
    var loginSuccess by mutableStateOf(false)
        private set

    fun onEmailChanged(email: String) {
        user = user.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        user = user.copy(password = password)
    }

    fun onLoginClicked() {
        if (user.email.isEmpty()||user.password.isEmpty()) return
        isLoading = true

        viewModelScope.launch {
            delay(1000L)
            loginSuccess = true
            isLoading = false

        }
    }
}