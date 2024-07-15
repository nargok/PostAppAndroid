package com.example.postapp.infrastructure.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.postapp.domain.model.PostModel
import com.example.postapp.domain.model.vo.PostId
import com.example.postapp.domain.repository.PostRepository
import com.example.postapp.infrastructure.db.dao.PostDao
import com.example.postapp.infrastructure.db.entity.PostEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val postDao: PostDao
) : PostRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun list(): Flow<List<PostModel>> {
        return postDao.getAllPosts().flowOn(Dispatchers.IO).map { it -> it.map { it.toModel() } }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun register(model: PostModel) {
        postDao.insertPost(model.toEntity())
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun PostEntity.toModel(): PostModel {
    return PostModel.reconstruct(
        id = PostId.reconstruct(id),
        text = text,
        createdAt = LocalDateTime.ofInstant(Instant.ofEpochMilli(createdAt), ZoneId.systemDefault())
    )
}

@RequiresApi(Build.VERSION_CODES.O)
private fun PostModel.toEntity(): PostEntity {
    return PostEntity(
        id = id.value,
        text = text,
        createdAt = createdAt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    )

}