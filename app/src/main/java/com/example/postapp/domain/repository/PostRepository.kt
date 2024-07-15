package com.example.postapp.domain.repository

import com.example.postapp.domain.model.PostModel

interface PostRepository {
    fun list(): List<PostModel>
    suspend fun register(model: PostModel)
}
