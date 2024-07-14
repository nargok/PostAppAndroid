package com.example.postapp.infrastructure.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="posts")
data class PostEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "text")val text: String,
    @ColumnInfo(name = "created_at")val createdAt: Long = System.currentTimeMillis()
)
