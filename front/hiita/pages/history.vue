<template>
    <v-main>
        <v-row>
            <v-col cols="11">
                <h3>2024年</h3>
            </v-col>
            <v-col cols="11">
                <v-card style="height: 100px">
                    <v-card-text>
                        <v-row>
                            <v-col cols=3 align="center">
                                <v-img class="shrine_thmb" src="img/shirahige.jpg" size="88" max-width="70"></v-img>
                            </v-col>
                            <v-col cols="5" class="shrine_sub">
                                <h4>白髭神社</h4>
                                <div class="result_badge">
                                    大吉
                                </div>
                            </v-col>
                            <v-col cols="1" class="shrine_arrow">
                                <h2>&gt;</h2>
                            </v-col>
                        </v-row>
                    </v-card-text>
                </v-card>
            </v-col>

            <v-col cols="11">
                <v-card style="height: 100px">
                    <v-card-text>
                        <v-row>
                            <v-col cols=3 align="center">
                                <v-img class="shrine_thmb" src="img/oh_me.jpg" size="88" max-width="70"></v-img>
                            </v-col>
                            <v-col cols="5" class="shrine_sub">
                                <h4>近江神宮</h4>
                                <div class="result_badge" style="background-color: #415356;">
                                    小吉
                                </div>
                            </v-col>
                            <v-col cols="1" class="shrine_arrow">
                                <h2>&gt;</h2>
                            </v-col>
                        </v-row>
                    </v-card-text>
                </v-card>
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
