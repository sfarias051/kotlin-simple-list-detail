package com.sebastianfarias.simplealbum.model

/**
 *
 * {
 *  "userId": 1,
 *  "id": 1,
 *  "title": "quidem molestiae enim"
 * }
 *
 */
data class Album(
    val userId: Int,
    val id: Int,
    val title: String)