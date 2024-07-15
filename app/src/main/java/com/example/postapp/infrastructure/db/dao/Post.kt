package com.example.postapp.infrastructure.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.postapp.infrastructure.db.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM posts ORDER BY id DESC")
    fun getAllPosts(): Flow<List<PostEntity>>

    @Insert
    suspend fun insertPost(post: PostEntity)
}