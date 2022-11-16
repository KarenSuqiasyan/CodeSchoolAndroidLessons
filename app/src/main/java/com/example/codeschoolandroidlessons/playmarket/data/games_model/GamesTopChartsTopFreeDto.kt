package com.example.codeschoolandroidlessons.playmarket.data.games_model

import com.example.codeschoolandroidlessons.playmarket.data.base.BaseItemType

enum class GamesTopChartsTopFreeDto(override val title :String) : BaseItemType {
    TOP_FREE("Top free Games"),
    TOP_GROSSING("Top grossing Games"),
    TOP_PAID("Top paid Games");
}