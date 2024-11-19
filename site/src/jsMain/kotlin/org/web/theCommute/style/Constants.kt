package org.web.theCommute.style

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.CSSFilter
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyleProvider
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.web.theCommute.models.Theme

val NavigationStyles = CssStyle {

    base {
        Modifier.color(Color.white).transition(Transition.of(property = "color", duration = 200.ms))
    }

    hover {
        Modifier.color(Color.black)
    }


}

val aboutImageStyle = CssStyle{
    base{
      Modifier.transition(Transition.of("rotate", duration = 200.ms))
    }

    hover{
        Modifier.rotate(10.deg)
    }
}

val aboutDescription = CssStyle{

    base {
        Modifier.opacity(50.percent).transition(Transition.of("opacity", duration = 200.ms))
    }

    hover{
        Modifier.opacity(100.percent)

    }
}

@OptIn(ExperimentalComposeWebApi::class)
val BackgroundStyles = CssStyle {

    base {
        Modifier.transition(Transition.of(property = "styleModifier", duration = 200.ms))
    }

    hover {
        Modifier.styleModifier {
            filter {
                sepia(50.percent)
            }
        }
    }


}


@OptIn(ExperimentalComposeWebApi::class)
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