package com.example.codeschoolandroidlessons.playmarket.data.apps_model

import com.example.codeschoolandroidlessons.playmarket.data.base.BaseItemType

enum class AppsCategoriesDto(override val title: String): BaseItemType {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    ARCADE("Arcade"),
    BOARD("Board"),
    CARD("Board"),
    CASINO("Casino"),
    CASUAL("Casual"),
    EDUCATIONAL("Educational"),
    MUSIC("Music"),
    PUZZLE("Puzzle"),
    RACING("Racing"),
    SIMULATION("Simulation"),
    SPORTS("Sports"),
    STRATEGY("Strategy"),
    TRIVIA("Trivia"),
    WORD("Word")
}