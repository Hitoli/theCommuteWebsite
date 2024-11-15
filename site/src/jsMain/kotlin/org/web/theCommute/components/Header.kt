package org.web.theCommute.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.dom.svg.SVGBlendMode
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Theme
import org.web.theCommute.style.NavigationStyles
import org.web.theCommute.utils.Constants
import org.web.theCommute.utils.Res


@Composable
fun Header() {

val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier.fillMaxWidth(if(breakpoint>Breakpoint.MD)80.percent else 90.percent).margin(topBottom = 20.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint)
        if(breakpoint > Breakpoint.MD){
            RightSide()
        }
    }
}



@Composable
fun LeftSide(breakpoint: Breakpoint) {
    if (breakpoint<Breakpoint.MD){
        FaBars(modifier = Modifier.color(Theme.HeroColor.rgb).margin(left = 15.px), size = IconSize.XL)
    } else{
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {

            Image(
                src = Res.Image.logo, modifier = Modifier.size(50.px)
            )
            SpanText(
                text = "theCommute",
                modifier = Modifier.fontFamily(Constants.FONT_FAMILY).fontSize(18.px).fontWeight(FontWeight.Normal).color(Theme.Background.rgb).padding(bottom = 10.px, left = 10.px)
            )
        }
    }
}


@Composable
fun RightSide() {
        Row(modifier = Modifier.padding(22.px).borderRadius(r = 5.px).background(Theme.HeroColor.rgb)) {

            Sections.values().forEach { sections ->
                Link(
                    modifier = NavigationStyles.toModifier().padding(right = 30.px).fontFamily(Constants.FONT_FAMILY).fontSize(18.px).fontWeight(
                        FontWeight.Normal
                    ), path = sections.path, text = sections.title
                )

            }
        }


}