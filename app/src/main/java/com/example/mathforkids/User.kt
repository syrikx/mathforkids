package com.example.mathforkids

data class User(
    val name: String="",
    val birthDate: String="",
    var totalScore: Int=0,
    var dailyScores: Map<String, Int> = emptyMap(),
    var settings: Map<String, Boolean> = emptyMap(),
    var selected: Boolean = false
)
