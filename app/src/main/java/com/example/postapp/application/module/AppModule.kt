package com.example.postapp.application.module

import android.app.Application
import androidx.room.Room
import com.example.postapp.domain.repository.PostRepository
import com.example.postapp.infrastructure.db.PostDatabase
import com.example.postapp.infrastructure.db.dao.PostDao
import com.example.postapp.infrastructure.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostDatabase(app: Application): PostDatabase {
        return Room.databaseBuilder(
            app,
            PostDatabase::class.java,
            PostDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePostDao(db: PostDatabase): PostDao {
        return db.postDao();
    }

    @Provides
    @Singleton
    fun providePostRepository(postDao: PostDao): PostRepository {
        return PostRepositoryImpl(postDao)
    }
}
