package org.web.theCommute.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
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
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.Header
import org.web.theCommute.components.SectionTitle
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Theme
import org.web.theCommute.style.aboutDescription
import org.web.theCommute.style.aboutImageStyle
import org.web.theCommute.utils.Constants


@Composable
fun AboutSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.fillMaxSize().id(Sections.About.id).padding(30.px),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier.maxWidth(1100.px),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                section = Sections.About,
                modifier = Modifier.padding(bottom = 20.px),
                alignment = Alignment.CenterHorizontally, breakpoint = breakpoint
            )
            AboutContent(breakpoint)
        }

    }
}

@Composable
fun AboutContent(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier.fillMaxSize().background(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent)
                .align(Alignment.CenterHorizontally), numColumns = numColumns(base = 1, sm = if (breakpoint>Breakpoint.MD)2 else 1)
        ) {
            if (breakpoint>=Breakpoint.MD){
                AboutImage(breakpoint)
            }
            AboutDescription(breakpoint)
        }

    }
}

@Composable
fun AboutImage(breakpoint: Breakpoint) {
    val size = if (breakpoint >= Breakpoint.MD) 400.px else 100.px
    Image(
        modifier = aboutImageStyle.toModifier().height(size).width(size).objectFit(ObjectFit.Contain),
        src = "aboutmes.jpg",
        description = "About me"
    )
}

@Composable
fun AboutDescription(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        P(
            attrs = aboutDescription.toModifier().fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 18.px else 10.px).color(
                    Theme.MainColor.rgb
                )
                .toAttrs()
        ) {
            Text("I am a Software engineer working in GeeksForGeeks. I am trying to record my journey to becoming a better developer, a better person and an entrepreneur. I document whatever I learn, so this website is pretty much my second brain. I hope you enjoy your stay here.")
        }
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px).color(
                    Theme.HeroColor.rgb
                )
                .toAttrs()
        ) {
            Text("Your Captain (theCommute)")
        }
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px).color(
                    Theme.HeroColor.rgb
                )
                .toAttrs()
        ) {
            Text("Hitesh Kohli")
        }
    }

}