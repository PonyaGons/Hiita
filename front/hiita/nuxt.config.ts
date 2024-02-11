// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  devtools: { enabled: true },
  app: {
    baseURL: '/Hiita/',
    pageTransition: { name: 'page', mode: 'out-in' },
  },
  build: {
    transpile: ['vuetify'],
  }
})
