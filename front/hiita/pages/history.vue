<template>
    <v-main>
        <h3>2024年</h3>
        <v-row v-for="mikuji in mikuji_list">
            <v-col cols="11">
                
                <NuxtLink v-bind:to="{name: 'detail-id', params: {id: mikuji.id}}">
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
                </NuxtLink>
            </v-col>
        </v-row>
    </v-main>
</template>

<style>
.shrine_thmb {
    border-radius: 50%;
}

.shrine_sub {
    margin-top: -10px;
}

.shrine_arrow {
    color: #B02C23;
    font-weight: bolder;
    font-size: 1em;
    padding-top: 25px;
    padding-left: 20px;
}

.result_badge {
    background-color: #B02C23;
    text-align: center;
    width: 3em;
    margin-top: -10px;
    color: #fff;
    padding: 5px;
    border-radius: 10%;
}
</style>

<script>
export default {
    data: () => ({
        mikuji_list: [
            {
                id: 0,
                shrine_name: "白鬚神社",
                shrine_img: "shirahige.jpg",
                fortune: "大吉"
            },
            {
                id: 1,
                shrine_name: "近江神宮",
                shrine_img: "oh_me.jpg",
                fortune: "小吉"
            }
        ]
    })
}
</script>
