package com.example.postapp.domain.repository

import com.example.postapp.domain.model.PostModel
import kotlinx.coroutines.flow.StateFlow

interface PostRepository {
    fun list(): StateFlow<List<PostModel>>
    fun register(model: PostModel)
}
