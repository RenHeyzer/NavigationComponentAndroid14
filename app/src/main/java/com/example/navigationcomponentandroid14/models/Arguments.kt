package com.example.navigationcomponentandroid14.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Arguments(
    val text: String,
    val tags: List<String>,
    val isTransition: Boolean
): Parcelable