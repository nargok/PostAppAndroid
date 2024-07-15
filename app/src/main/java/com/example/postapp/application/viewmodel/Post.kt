package com.example.postapp.application.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.postapp.domain.model.PostModel
import com.example.postapp.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {
    private val _items = MutableStateFlow<List<PostModel>>(emptyList())
    val items: StateFlow<List<PostModel>> get() = _items

    init {
        loadTodos()
    }

    private fun loadTodos() {
        _items.value = repository.list()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addPost(text: String) {
        viewModelScope.launch {
            val model = PostModel.create(text)
            repository.register(model)
        }
    }
}
