package com.example.codeschoolandroidlessons.multiple_recyclerview.utils

import android.content.Context
import android.content.Intent

object Utils {

    fun share(context: Context, shareBody: String, type: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareBody)
            this.type = type
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }
}