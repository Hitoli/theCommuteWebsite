package org.web.theCommute.style

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
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


val servicesStyle = CssStyle{
    base{
      Modifier.transition(Transition.of("border", duration = 200.ms))
    }
    hover{
        Modifier.borderRadius(20.px)
        .border(width = 2.px, color = Theme.HeroColor.rgb, style = LineStyle.Solid)
    }
}

val myWorkStyle = CssStyle{
    base{
        Modifier.borderRadius(0.px).transition(Transition.of("borderRadius", duration = 400.ms))

    }
    hover{
        Modifier.borderRadius(50.px)
    }
}



val ButtonStyle = CssStyle {

    base {
        Modifier.border(width = 0.px).borderRadius(5.px).backgroundColor(Theme.HeroColor.rgb).color(Colors.White)
            .margin(topBottom = 10.px).transition(Transition.of(property = "width", duration = 200.ms))
    }
    hover {

        Modifier.width(400.px).border(color = Color.black, width = 4.px).borderRadius(2.px)


    }
}