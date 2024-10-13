package com.creasoft.dua_crea

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dua(
    val title: String,
    val arabicText: String,
    val turkishTransliteration: String, // Türkçe okunuş
    val content: String // Dua'nın içeriği
) : Parcelable {

}
