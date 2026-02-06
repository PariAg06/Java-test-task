package com.example.items.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class Item(
    val id: Long? = null,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val description: String,

    @field:Positive
    val price: Double
)
