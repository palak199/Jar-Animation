package com.example.jar.data.model

data class EducationCardState(
    val id: Int,
    var isExpanded: Boolean = false,
    var hasCollapsed: Boolean = false,
    var rotationX: Float = 45f,
    var translationY: Float = 300f
)
