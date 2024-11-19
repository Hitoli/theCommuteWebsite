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
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.SectionTitle
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Services
import org.web.theCommute.models.Theme
import org.web.theCommute.style.aboutImageStyle
import org.web.theCommute.utils.Constants

@Composable
fun ServiceSections() {

    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Sections.Services.id).fillMaxSize().padding(topBottom = 100.px),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier.maxWidth(2000.px),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                section = Sections.Services,
                modifier = Modifier.padding(bottom = 20.px),
                alignment = Alignment.CenterHorizontally, breakpoint = breakpoint
            )
            Row(modifier = Modifier.fillMaxSize()){
                ServicContent(Services.Android)
                ServicContent(Services.AppMarketing)

            }
        }

    }
}

@Composable
fun ServicContent(services: Services) {
    Column(modifier = Modifier.maxWidth(300.px).margin(20.px).padding(20.px)) {
        Box(modifier = Modifier.padding(10.px).margin(bottom = 20.px).borderRadius(20.px).border(width = 2.px, color = Theme.HeroColor.rgb, style = LineStyle.Solid)) {
            Image(
                modifier = Modifier.size(40.px),
                src = services.image,
                description = services.description
            )
        }
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(20.px).color(
                    Theme.HeroColor.rgb
                ).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(services.title)
        }
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(16.px).color(
                    Theme.Background.rgb
                ).margin(topBottom = 0.px)
                .toAttrs()
        ) {
            Text(services.description)
        }
    }
}