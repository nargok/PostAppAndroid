package com.example.postapp.domain.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.postapp.domain.vo.PostId
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

data class PostItemModel(
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
}
