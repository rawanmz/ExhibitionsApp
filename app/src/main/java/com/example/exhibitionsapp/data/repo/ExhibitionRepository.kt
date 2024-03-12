package com.example.exhibitionsapp.data.repo

import com.example.exhibitionsapp.common.UIState
import com.example.exhibitionsapp.data.model.ExhibitionResponse
import com.example.exhibitionsapp.data.remote.ArticApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExhibitionRepository @Inject constructor(
    val articApi: ArticApi
) {
    suspend fun getExhibition(): UIState<ExhibitionResponse> {
        val response = articApi.getExhibitions()
        try {
            if (response.isSuccessful) {
                return UIState.Success(response.body())
            } else {
                return UIState.Empty(message = response.message().toString())
            }
        } catch (e: Exception) {
            return UIState.Error(e.message.toString())
        }

    }
}