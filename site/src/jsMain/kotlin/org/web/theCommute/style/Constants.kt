package org.web.theCommute.style

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyleProvider
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.web.theCommute.models.Theme

val NavigationStyles = CssStyle {

    base {
        Modifier.color(Color.white).transition(Transition.of(property = "color", duration = 200.ms))
    }

    hover {
        Modifier.color(Color.black)
    }


}


val ButtonStyle = CssStyle {

    base {
        Modifier.height(40.px).width(100.px).border(width = 0.px).borderRadius(5.px).backgroundColor(
            Theme.HeroColor.rgb
        ).color(Colors.White).margin(10.px).transition(Transition.of(property = "width", duration = 200.ms))
    }
    hover {

        Modifier.width(120.px).border(color = Color.black, width = 4.px).borderRadius(2.px)


    }
}