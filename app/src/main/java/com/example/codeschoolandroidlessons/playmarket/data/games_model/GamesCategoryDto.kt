package com.example.codeschoolandroidlessons.playmarket.data.games_model

import com.example.codeschoolandroidlessons.playmarket.data.base.BaseItemType

enum class GamesCategoryDto( override val title: String): BaseItemType {
    WATCH_APPS("Watch apps"),
    WATCH_FACES("Watch faces"),
    ART_AND_DESIGN("Art and design"),
    AUGMENTED_REALITY("Augmented reality"),
    AUTO_VEHICLES("Auto & design"),
    BEAUTY("Beauty"),
    BOOKS_AND_REFERENCE("Books & Reference"),
    BUSINESS("Business"),
    COMICS("Comics"),
    COMMUNICATION("Communication"),
    DATING("Dating"),
    EDUCATION("Education"),
    EVENTS("Events"),
    FINANCE("Finance"),
    GAMES("Games"),
    KIDS("Kids"),
    LIFESTYLE("Lifestyle"),
    MEDICAL("Medical"),
    PARENTING("Parenting"),
    SOCIAL("Social"),
    SPORTS("Sports"),
    TOOLS("Tools"),
    WEATHER("Weather")
}