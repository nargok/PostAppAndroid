package com.example.postapp.domain.model

import com.example.postapp.domain.vo.PostId
import java.time.LocalDateTime

data class PostItemModel(
    val id: PostId,
    val text: String,
    val createdAt: LocalDateTime,
)

