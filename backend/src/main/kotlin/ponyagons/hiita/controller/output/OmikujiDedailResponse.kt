package ponyagons.hiita.controller.output

import com.fasterxml.jackson.annotation.JsonProperty

data class OmikujiDetailResponse(
    val id: Int,
    @JsonProperty("shrine_name")
    val shrineName: String,
    @JsonProperty("shrine_img")
    val shrineImg: String,
    val fortune: String,
    val date: String,
    @JsonProperty("category_fortune")
    val categoryFortune: List<OmikujiDedailCategoryFortune>
)

data class OmikujiDedailCategoryFortune(
    val category: Int,
    val content: String
)
