<template>
    <v-main>
        おみくじID : {{ $route.params.id }}
    </v-main>
</template>

<script setup>
const route = useRoute()

console.log(route.params.id)
</script>
