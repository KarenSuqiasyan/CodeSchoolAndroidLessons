package com.example.codeschoolandroidlessons.guardian.data.model

data class Response(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val results: MutableList<Result>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)