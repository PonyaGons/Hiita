<template>
    <v-main>
        <v-container fluid>
            <v-row dense>
                <v-col cols="11">
                    <v-card style="height: 200px">
                        <v-card-title>{{ year }}年総合評価</v-card-title>
                        <v-card-text>
                            <v-row align-content="center">
                                <v-col cols=5 align="center">
                                    <div class="summary">
                                        {{ overall.fortune }}
                                    </div>
                                </v-col>
                                <v-col cols="5" class="align-center" align="center">
                                    <v-img src="img/glaf.png" size="88" max-width="200"></v-img>
                                </v-col>
                            </v-row>
                        </v-card-text>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>

        <v-row class="category-tab-row" no-gutters>
            <v-col v-for="category in category_names" class="category-tab-col">
                <v-btn block flat v-if="category.id == current_category" style="margin-top: 11px; height: 30px; font-weight: bold; border-radius: 10px 10px 0px 0px;" color="#B02C23"
                    plane @click="clickCategory(category.id)">{{ category.name }}</v-btn>
                <v-btn block flat v-if="category.id != current_category" style="margin-top: 5px; font-weight: bold;" plane
                    @click="clickCategory(category.id)">{{ category.name }}</v-btn>
            </v-col>
        </v-row>

        <v-row v-for="omikuji in categories.filter(x => x.category == current_category).map(x => x.omikujis).flat()">
            <v-col cols="11">
                
                <!-- <NuxtLink v-bind:to="{name: 'detail-id', params: {id: mikuji.id}}">
                <v-card style="height: 100px">
                    <v-card-text>
                        <v-row>
                            <v-col cols=3 align="center">
                                <v-img class="shrine_thmb" :src="`img/${mikuji.shrine_img}`" size="88" max-width="70"></v-img>
                            </v-col>
                            <v-col cols="5" class="shrine_sub">
                                <h4>{{ mikuji.shrine_name }}</h4>
                                <div class="result_badge">
                                    {{ mikuji.fortune }}
                                </div>
                            </v-col>
                            <v-col cols="1" class="shrine_arrow">
                                <h2>&gt;</h2>
                            </v-col>
                        </v-row>
                    </v-card-text>
                </v-card>
                </NuxtLink> -->

                <v-card style="height: auto">
                    <v-card-text>
                        <v-row>
                            <v-col cols=2 align="center">
                                <v-img class="shrine_thmb" :src="`img/${omikuji.shrine_img}`" size="60" max-width="50"></v-img>
                            </v-col>
                            <v-col cols=7 class="shrine-name">
                                <h4>{{ omikuji.shrine_name }}</h4>
                            </v-col>
                        </v-row>
                        <v-row>
                            <v-col cols=10 class="omikuji-content">
                                <h2>{{ omikuji.content }}</h2>
                            </v-col>
                        </v-row>
                        <v-row>
                            <v-col cols=10 class="omikuji-opinion">
                                <div class="hiita-opinion">
                                    <h4>Hiita アドバイス</h4>
                                    <div style="color: #B02C23; margin-top: -20px;">=======================</div>
                                    {{ omikuji.opinion }}
                                </div>
                            </v-col>
                        </v-row>
                    </v-card-text>
                </v-card>
            </v-col>
        </v-row>

    </v-main>
</template>

<style>
body {
    background-color: #F4E8D0;
}

.v-application {
    background-color: #F4E8D0;
}

.category-tab-row {
    margin-top: 10px;
    /* height: 50px; */
}

.category-tab-col {
    background-color: #fff;
}

.summary {
    background-color: #B02C23;
    height: 50px;
    color: #fff;
    font-weight: bold;
    font-size: 3em;
    width: 120px;
    padding-top: 30px;
    margin-top: 30px;
}

.shrine_thmb {
    border-radius: 50%;
}

.shrine_name {
    margin-top: -15px;
    font-weight: bold;
    font-size: 1.5em;
}

.omikuji-content {
    padding-left: 10%;
    margin-top: -10px;
}

.hiita-opinion {
    border: 2px solid #415356;
    border-radius: 10px;
    padding-left: 20px;
    margin-left: 40px;
    padding-bottom: 10px;
}

.v-btn::before {
    background-color: #B02C23;
}
</style>

<script>
export default {
    data: () => ({
        year: 2024,
        current_category: 1,
        category_names: [
            { id: 1, name: "縁談" },
            { id: 2, name: "学業" },
            { id: 3, name: "商業" },
            { id: 4, name: "願望" },
            { id: 5, name: "失物" },
            { id: 6, name: "病気" }
        ],
        overall: {
            fortune: "大吉",
            score: [
                { catery: 1, score: 4 },
                { catery: 2, score: 5 },
                { catery: 3, score: 2 },
                { catery: 4, score: 5 },
                { catery: 5, score: 4 },
                { catery: 6, score: 1 },
            ]
        },
        categories: [
            {
                category: 1, omikujis: [
                    { shrine_name: "白髭神社", shrine_img: "shirahige.jpg", content: "彼女できる", opinion: "嘘っぱちです" },
                    { shrine_name: "近江神社", shrine_img: "oh_me.jpg",     content: "そのうち縁談", opinion: "夢みがち" },
                ]   
            },
            {
                category: 2, omikujis: [
                    { shrine_name: "白髭神社", shrine_img: "shirahige.jpg", content: "合格できる", opinion: "心強い感想です" },
                    { shrine_name: "近江神社", shrine_img: "oh_me.jpg",     content: "気を抜くと浪人です", opinion: "正しいですが気にしすぎる必要はありません" },
                ]   
            },
            {
                category: 3, omikujis: [
                    { shrine_name: "白髭神社", shrine_img: "shirahige.jpg", content: "占い結果", opinion: "専門家の意見" },
                    { shrine_name: "近江神社", shrine_img: "oh_me.jpg",     content: "占い結果", opinion: "専門家の意見" },
                ]   
            },
            {
                category: 4, omikujis: [
                    { shrine_name: "白髭神社", shrine_img: "shirahige.jpg", content: "占い結果", opinion: "専門家の意見" },
                    { shrine_name: "近江神社", shrine_img: "oh_me.jpg",     content: "占い結果", opinion: "専門家の意見" },
                ]   
            },
            {
                category: 5, omikujis: [
                    { shrine_name: "白髭神社", shrine_img: "shirahige.jpg", content: "占い結果", opinion: "専門家の意見" },
                    { shrine_name: "近江神社", shrine_img: "oh_me.jpg",     content: "占い結果", opinion: "専門家の意見" },
                ]   
            },
            {
                category: 6, omikujis: [
                    { shrine_name: "白髭神社", shrine_img: "shirahige.jpg", content: "占い結果", opinion: "専門家の意見" },
                    { shrine_name: "近江神社", shrine_img: "oh_me.jpg",     content: "占い結果", opinion: "専門家の意見" },
                ]   
            }
        ]
    }),
    methods: {
        clickCategory(arg) {
            this.current_category = arg;
        },
    }
}
</script>
