package com.example.postapp.domain.repository

import com.example.postapp.domain.model.PostModel
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun list(): Flow<List<PostModel>>

    suspend fun register(model: PostModel)
}
