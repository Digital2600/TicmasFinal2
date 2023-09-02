package com.curso.android.app.practica.ticmasfinal2.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.ticmasfinal2.model.ComparisonResult
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _comparisonResult = MutableLiveData<ComparisonResult>()
    val comparisonResult: LiveData<ComparisonResult> = _comparisonResult

    fun compareStrings(string1: String, string2: String) {
        val isEqual = string1 == string2
        _comparisonResult.value = ComparisonResult(isEqual)
    }
}

