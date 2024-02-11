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
                                        大吉
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
    </v-main>
</template>

<style>
body {
    background-color: #F4E8D0;
}

.v-application {
    background-color: #F4E8D0;
}

.category-menu {
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
</style>

<script>
export default {
    data: () => ({ value: 0, year: 2024 })
}
</script>
