package org.web.theCommute.models

import com.varabyte.kobweb.compose.ui.graphics.Color
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(val hex:String, val rgb: Color.Rgb) {
    Background(hex = "#464545", Color.rgb( 70, 69, 69)),
    MainColor(hex = "#169DF0", Color.rgb( 70, 69, 69)),
    BlackColor(hex = "#939393", Color.rgb( 147, 147, 147)),
    HeroColor(hex = "#169DF0", Color.rgb(22,157,240)),
    BackgrounMain(hex = "#D7DCE1", Color.rgb(215,220,225))
}