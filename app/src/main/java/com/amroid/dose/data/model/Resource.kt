package com.amroid.dose.data.model


data class Resource<out T>(
    val data: T? = null,
    val error: String? = null,
    val loading: Boolean = false,
) {
    companion object {

        fun <T> success(
            data: T
        ): Resource<T> {
            return Resource(
                data = data,
            )
        }

        fun <T> error(
            message: String,
        ): Resource<T> {
            return Resource(
                error = message
            )
        }

        fun <T> loading(): Resource<T> = Resource(loading = true)
    }
}

