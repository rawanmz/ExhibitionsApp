package com.example.exhibitionsapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exhibitionsapp.common.UIState
import com.example.exhibitionsapp.data.model.ExhibitionResponse
import com.example.exhibitionsapp.domain.GetExhibitionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val getExhibitionsUseCase: GetExhibitionsUseCase,
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    var artWork = MutableLiveData<UIState<ExhibitionResponse>>(UIState.Loading())
    //var artWork = MutableStateFlow<UIState<ExhibitionResponse>>(UIState.Loading())
    init {
        getArtWorks()
    }

    fun getArtWorks() {
        viewModelScope.launch {
            when (val response = getExhibitionsUseCase.invoke()) {
                is UIState.Success -> artWork.postValue(UIState.Success(response.responseData))
                is UIState.Error -> artWork.postValue(UIState.Error(response.error))
                is UIState.Empty -> artWork.postValue(
                    UIState.Empty(
                        title = response.title,
                    )
                )
                else -> {}
            }
        }
    }
}
