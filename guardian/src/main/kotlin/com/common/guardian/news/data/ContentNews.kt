package com.common.guardian.news.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ContentNewsDto(
    @SerializedName("response") val response: NewsResponseDto?
) : Serializable

data class NewsResponseDto(
    @SerializedName("currentPage") val currentPage: Int?,
    @SerializedName("orderBy") val orderBy: String?,
    @SerializedName("pageSize") val pageSize: Int?,
    @SerializedName("pages") val pages: Int?,
    @SerializedName("results") val results: MutableList<NewsResultDto?>?,
    @SerializedName("startIndex") val startIndex: Int?,
    @SerializedName("status") val status: String?,
    @SerializedName("total") val total: Int?,
    @SerializedName("userTier") val userTier: String?
) : Serializable

data class NewsResultDto(
    @SerializedName("apiUrl") val apiUrl: String?,
    @SerializedName("fields") val fields: NewsFieldsDto?,
    @SerializedName("id") val id: String?,
    @SerializedName("isHosted") val isHosted: Boolean?,
    @SerializedName("pillarId") val pillarId: String?,
    @SerializedName("pillarName") val pillarName: String?,
    @SerializedName("sectionId") val sectionId: String?,
    @SerializedName("sectionName") val sectionName: String?,
    @SerializedName("tags") val tags: List<NewsTagDto?>?,
    @SerializedName("type") val type: String?,
    @SerializedName("webPublicationDate") val webPublicationDate: String?,
    @SerializedName("webTitle") val webTitle: String?,
    @SerializedName("webUrl") val webUrl: String?
) : Serializable

data class NewsFieldsDto(
    @SerializedName("headline") val headline: String?,
    @SerializedName("shortUrl") val shortUrl: String?,
    @SerializedName("starRating") val starRating: String?,
    @SerializedName("thumbnail") val thumbnail: String?
) : Serializable

data class NewsTagDto(
    @SerializedName("apiUrl") val apiUrl: String?,
    @SerializedName("bio:") val bio: String?,
    @SerializedName("bylineImageUrl") val bylineImageUrl: String?,
    @SerializedName("bylineLargeImageUrl") val bylineLargeImageUrl: String?,
    @SerializedName("firstName") val firstName: String?,
    @SerializedName("id: String?") val id: String?,
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("references") val references: List<Any?>?,
    @SerializedName("sectionId") val sectionId: String?,
    @SerializedName("sectionName") val sectionName: String?,
    @SerializedName("twitterHandle") val twitterHandle: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("webTitle") val webTitle: String?,
    @SerializedName("webUrl") val webUrl: String?
) : Serializable