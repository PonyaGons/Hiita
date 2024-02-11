<template>
    <header class="header">
        <v-app-bar app>
        <v-app-bar-title>
            <v-img
            class="mx-2"
            src="img/logo.png"
            max-height="40"
            max-width="100"
            contain>
            </v-img>
        </v-app-bar-title>
        <!-- <div class="year_changer" v-if="year !== null">
            <v-btn block @click=""><</v-btn>
            <v-btn block @click="">{{ year }}</v-btn>
            <v-btn block @click="">></v-btn>
        </div> -->
      </v-app-bar>
        <!-- <img class="header-logo" src="/img/logo.png" alt="Hiita" /> -->
    </header>
  </template>
  
  <style>
  .header {
    background-color: #fff;
    display: flex;
  }
  </style>
