package com.example.animatedlanding.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animatedlanding.data.datasrc.EducationJsonDataSrc
import com.example.animatedlanding.data.model.EducationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EducationViewModel(application: Application): AndroidViewModel(application) {
    private var _uiState = MutableStateFlow<EducationData?>(null)
    val uiState: StateFlow<EducationData?> = _uiState

    init {
        loadEducationData()
    }

    private fun loadEducationData() {
        viewModelScope.launch {
            val ctx = getApplication<Application>().applicationContext
            val resp = EducationJsonDataSrc(ctx).loadData()
            _uiState.value = resp?.data?.manualBuyEducationData
        }
    }

}