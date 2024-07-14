package com.example.postapp.infrastructure.repository

import com.example.postapp.domain.model.PostModel
import com.example.postapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(): PostRepository {
    private val _items = MutableStateFlow<List<PostModel>>(emptyList())
    override fun list(): StateFlow<List<PostModel>> {
        return _items
    }

    override fun register(model: PostModel) {
        _items.value = _items.value + model
    }
}