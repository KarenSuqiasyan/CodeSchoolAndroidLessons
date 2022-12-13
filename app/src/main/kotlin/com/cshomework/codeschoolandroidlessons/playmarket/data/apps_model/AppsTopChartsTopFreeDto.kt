package com.cshomework.codeschoolandroidlessons.playmarket.data.apps_model

import com.cshomework.codeschoolandroidlessons.playmarket.data.base.BaseItemType

enum class AppsTopChartsTopFreeDto(override val title :String) : BaseItemType {
    TOP_FREE("Top free Apps"),
    TOP_GROSSING("Top grossing Apps"),
    TOP_PAID("Top paid Apps");
}