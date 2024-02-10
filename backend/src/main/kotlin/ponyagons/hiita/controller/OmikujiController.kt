package ponyagons.hiita.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ponyagons.hiita.controller.input.OmikujiRegisterInput
import ponyagons.hiita.controller.output.*

@RestController
@RequestMapping("/omikuji")
class OmikujiController {

    @GetMapping
    fun getOmikujis(@RequestParam user: Int): OmikujisResponse {
        val mock = OmikujisResponse(
            score = listOf(
                OmikujisResponseScore(
                    date = "20230101",
                    fortune = "大吉",
                    categoryFortune = listOf(
                        CategoryFortune(category = 1, score = 1),
                        CategoryFortune(category = 2, score = 2),
                        CategoryFortune(category = 3, score = 3),
                        CategoryFortune(category = 4, score = 4),
                        CategoryFortune(category = 5, score = 5),
                        CategoryFortune(category = 6, score = 5)
                    )
                )
            ),
            omikujis = listOf(
                OmikujisResponseOmikuji(
                    id = 1,
                    shrineName = "白髭神社",
                    shrineImg = "img",
                    fortune = "大吉",
                    date = "20230101"
                )
            )
        )

        return mock
    }

    @PostMapping
    fun register(@RequestBody input: OmikujiRegisterInput) {

    }

    @GetMapping("{id}")
    fun getOmikujiDetail(@PathVariable("id") id: Int): OmikujiDetailResponse {
        val mock = OmikujiDetailResponse(
            id = 1,
            shrineName = "白髭神社",
            shrineImg = "img",
            fortune = "大吉",
            date = "20230101",
            categoryFortune = listOf(
                OmikujiDedailCategoryFortune(category = 1, content = "神のお告げ"),
                OmikujiDedailCategoryFortune(category = 2, content = "神のお告げ"),
                OmikujiDedailCategoryFortune(category = 3, content = "神のお告げ"),
                OmikujiDedailCategoryFortune(category = 4, content = "神のお告げ"),
                OmikujiDedailCategoryFortune(category = 5, content = "神のお告げ"),
                OmikujiDedailCategoryFortune(category = 6, content = "神のお告げ")
            )
        )

        return mock
    }

    @GetMapping("opinions")
    fun getOpinions(@RequestParam year: Int, @RequestParam user: Int): OpinionsResponse {
        val mock = OpinionsResponse(
            year = 2023,
            overall = Overall(
                fortune = "大吉",
                score = listOf(
                    OverallScore(category = 1, score = 1),
                    OverallScore(category = 2, score = 2),
                    OverallScore(category = 3, score = 3),
                    OverallScore(category = 4, score = 4),
                    OverallScore(category = 5, score = 5),
                    OverallScore(category = 6, score = 5)
                )
            ),
            categories = listOf(
                Category(
                    category = 1,
                    omikujis = listOf(
                        CategoryOmikuji(
                            shrineName = "白髭神社",
                            shrineImg = "img",
                            content = "占い結果",
                            opinion = "専門家の意見"
                        ),
                        CategoryOmikuji(
                            shrineName = "平安神宮",
                            shrineImg = "img",
                            content = "占い結果",
                            opinion = "専門家の意見"
                        )
                    )
                )
            )
        )

        return mock
    }
}