package com.epignosishq.epignosistest.model

data class BoringActivity(
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Float,
    val link: String,
    val key: Int,
    val accessibility: Float
)