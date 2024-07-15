package com.example.postapp.application.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp.domain.model.PostModel
import com.example.postapp.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {
    val items = repository.list()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addPost(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val model = PostModel.create(text)
            repository.register(model)
        }
    }
}
