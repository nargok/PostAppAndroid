package com.example.postapp.application.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.postapp.domain.model.PostModel
import com.example.postapp.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {
    val items = repository.list()
    fun list() = repository.list()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addPost(text: String) {
        val model = PostModel.create(text)
        repository.register(model)
    }
}
