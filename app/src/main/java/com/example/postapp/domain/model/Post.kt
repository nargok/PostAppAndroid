package com.example.postapp.domain.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.postapp.domain.model.vo.PostId
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

data class PostModel private constructor(
    val id: PostId,
    val text: String,
    val createdAt: LocalDateTime,
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun postedTimeFromNow(): String {
        val now = LocalDateTime.now()
        val diff = ChronoUnit.SECONDS.between(createdAt, now)
        return when {
            diff < 60 -> "今"
            diff < 3600 -> "${diff / 60}分前"
            diff < 86400 -> "${diff / 3600}時間前"
            else -> "${diff / 86400}日前"
        }
    }

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun create(text: String): PostModel {
            return PostModel(
                id = PostId.create(),
                text = text,
                createdAt = LocalDateTime.now()
            )
        }

        fun reconstruct(id: PostId, text: String, createdAt: LocalDateTime): PostModel {
            return PostModel(
                id = id,
                text = text,
                createdAt = createdAt
            )
        }
    }
}
