package ponyagons.hiita.controller.output

import com.fasterxml.jackson.annotation.JsonProperty

data class OmikujisResponse(
    val score: List<OmikujisResponseScore>,
    val omikujis: List<OmikujisResponseOmikuji>
)

data class OmikujisResponseScore(
    val date: String,
    val fortune: String,
    @JsonProperty("category_fortune")
    val categoryFortune: List<CategoryFortune>
)

data class CategoryFortune(
    val category: Int,
    val score: Int
)

data class OmikujisResponseOmikuji(
    val id: Int,
    @JsonProperty("shrine_name")
    val shrineName: String,
    @JsonProperty("shrine_img")
    val shrineImg: String,
    val fortune: String,
    val date: String,
)
