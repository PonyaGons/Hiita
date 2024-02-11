<template>
    <v-footer app>
        <v-container>
            <v-row align="end">
                <v-col> <NuxtLink to="/history"><v-btn block>くじログ</v-btn></NuxtLink> </v-col>
                <v-col> <NuxtLink to="/"><v-btn block>神々の意見</v-btn></NuxtLink> </v-col>
                <v-col> <NuxtLink to="/add"><v-btn block>追加</v-btn></NuxtLink> </v-col>
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
