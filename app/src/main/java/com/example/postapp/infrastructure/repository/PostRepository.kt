package com.example.postapp.infrastructure.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.postapp.domain.model.PostModel
import com.example.postapp.domain.model.vo.PostId
import com.example.postapp.domain.repository.PostRepository
import com.example.postapp.infrastructure.db.dao.PostDao
import com.example.postapp.infrastructure.db.entity.PostEntity
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val postDao: PostDao
): PostRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun list(): List<PostModel> {
        return postDao.getAllPosts().map { it.toModel() }
    }

    override suspend fun register(model: PostModel) {
        postDao.insertPost(model.toEntity())
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun PostEntity.toModel(): PostModel {
    return PostModel.reconstruct(
        id = PostId.reconstruct(id),
        text = text,
        createdAt = LocalDateTime.parse(createdAt.toString())
    )
}

private fun PostModel.toEntity(): PostEntity {
    return PostEntity(
        id = id.value,
        text = text,
        createdAt = 10L // TODO 治す
    )
}