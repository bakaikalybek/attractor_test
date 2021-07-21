package kz.laccent.util

import android.content.Context

interface TranslatableException {
    fun getDefaultResourceId(): Int
    fun getTranslableMessage(context: Context): String = context.getString(getDefaultResourceId())
}