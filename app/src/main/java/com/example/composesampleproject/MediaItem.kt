package com.example.composesampleproject

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
) {
    enum class Type { PHOTO, VIDEO }
}

fun getMedia() = (1..10).map {
    MediaItem(
        id = it,
        title = "Title $it",
        thumb = "https://lorempixel.com/400/400/people/$it/",
        type = if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
    )
}
