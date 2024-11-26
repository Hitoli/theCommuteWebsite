package org.web.theCommute.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.SectionTitle
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Services
import org.web.theCommute.models.Theme
import org.web.theCommute.style.aboutDescription
import org.web.theCommute.style.aboutImageStyle
import org.web.theCommute.style.servicesStyle
import org.web.theCommute.utils.Constants

@Composable
fun ServiceSections() {

    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier.id(Sections.Services.id)
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 70.percent else 90.percent).padding(topBottom = 40.px)
            .border(width = 0.1.px, color = Theme.HeroColor.rgb, style = LineStyle.Solid).borderRadius(20.px)
            .margin(topBottom = 40.px),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Sections.Services,
            modifier = Modifier.padding(bottom = 20.px),
            alignment = Alignment.CenterHorizontally, breakpoint = breakpoint
        )
        SimpleGrid(numColumns = numColumns(base = 1, md = 2)) {
            Services.values().forEach {
                ServicContent(it, breakpoint)
            }
        }
    }


}

@Composable
fun ServicContent(services: Services, breakpoint: Breakpoint) {
    Column(
        modifier = servicesStyle.toModifier().maxWidth(if (breakpoint > Breakpoint.MD) 700.px else 800.px).margin(20.px).padding(20.px), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(10.px).margin(bottom = 20.px).borderRadius(20.px)
                .border(width = 2.px, color = Theme.HeroColor.rgb, style = LineStyle.Solid)
        ) {
            Image(
                modifier = Modifier.size(if (breakpoint >= Breakpoint.MD) 40.px else 20.px).align(Alignment.Center),
                src = services.image,
                description = services.description
            )
        }
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 20.px else 14.px).color(
                    Theme.MainColor.rgb
                ).color(
                    Theme.HeroColor.rgb
                ).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(services.title)
        }
        P(
            attrs = aboutDescription.toModifier().fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 18.px else 10.px).color(
                    Theme.MainColor.rgb
                ).color(
                    Theme.Background.rgb
                ).margin(topBottom = 0.px)
                .toAttrs()
        ) {
            Text(services.description)
        }
    }
}