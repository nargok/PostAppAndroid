package com.example.postapp.domain.vo

import de.huxhorn.sulky.ulid.ULID

data class PostId private constructor(val value: String) {
    companion object {
        private val ulid = ULID()
        fun create(): PostId {
            return PostId(ulid.nextULID())
        }

        fun reconstruct(id: String): PostId {
            return PostId(id)
        }
    }

    override fun toString(): String {
        return value
    }
}
