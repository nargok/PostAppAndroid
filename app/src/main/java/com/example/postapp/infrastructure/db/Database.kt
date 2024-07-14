package com.example.postapp.infrastructure.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.postapp.infrastructure.db.dao.PostDao
import com.example.postapp.infrastructure.db.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object {
        const val DATABASE_NAME = "post_database"
    }
}