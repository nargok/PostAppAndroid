package com.example.postapp.domain.model

import java.time.LocalDateTime

data class PostItemModel(
    val id: Int,
    val text: String,
    val createdAt: LocalDateTime,
)

