package ponyagons.hiita.controller.output

import com.fasterxml.jackson.annotation.JsonProperty

data class OpinionsResponse(
    val year: Int,
    val overall: Overall,
    val categories: List<Category>
)

data class Overall(
    val fortune: String,
    val score: List<OverallScore>
)

data class OverallScore(
    val category: Int,
    val score: Int
)

data class Category(
    val category: Int,
    val omikujis: List<CategoryOmikuji>
)

data class CategoryOmikuji(
    @JsonProperty("shrine_name")
    val shrineName: String,
    @JsonProperty("shrine_img")
    val shrineImg: String,
    val content: String,
    val opinion: String,
)
