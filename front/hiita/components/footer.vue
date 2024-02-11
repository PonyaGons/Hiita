<template>
    <v-footer app>
        <v-container>
            <v-row align="end">
                <v-col> <v-btn block @click="navigateTo('/history')">くじログ</v-btn> </v-col>
                <v-col> <v-btn block @click="navigateTo('/')">神々の意見</v-btn> </v-col>
                <v-col> <v-btn block @click="navigateTo('/add')">追加</v-btn> </v-col>
            </v-row>
        </v-container>
    </v-footer>
</template>

<script>
export default {
  data: () => ({
    img: ""
  }),
  methods: {
    submit(){
      this.message = "submit";
    },
    cancel(){
      this.message = "cancel";
    }
  }
}
</script>
