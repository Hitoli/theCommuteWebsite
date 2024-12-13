package org.web.theCommute.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.SectionTitle
import org.web.theCommute.models.PortfolioProjects
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Services
import org.web.theCommute.models.Theme
import org.web.theCommute.style.aboutDescription
import org.web.theCommute.style.myWorkStyle
import org.web.theCommute.style.portfolioNavigationStyle
import org.web.theCommute.utils.Constants

@Composable
fun PortfolioSection() {

    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier.id(Sections.Apps.id)
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent).padding(topBottom = 10.px)
            .margin(topBottom = 20.px),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            section = Sections.Apps,
            modifier = Modifier.padding(bottom = 20.px),
            alignment = Alignment.CenterHorizontally, breakpoint = breakpoint
        )
        Row(
            modifier = Modifier.id("portfolioContainer").fillMaxWidth().margin(bottom = 25.px)
                .maxWidth(if (breakpoint > Breakpoint.MD) 1000.px else if (breakpoint > Breakpoint.SM) 625.px else 300.px).overflow(Overflow.Hidden).scrollBehavior(
                    ScrollBehavior.Smooth), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
        ) {
            PortfolioProjects.values().forEach {
                ProjectCard(it, breakpoint)
            }
        }
//        PorfolioNavigation()

    }
}


@Composable
fun ProjectCard(portfolioProjects: PortfolioProjects, breakpoint: Breakpoint) {

    Link(
        modifier = Modifier.color(Colors.White).textDecorationLine(TextDecorationLine.Underline),
        path = portfolioProjects.link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(modifier = Modifier) {

            Box(
                modifier = Modifier.padding(10.px).margin(bottom = 10.px)
            ) {
                Image(
                    modifier = myWorkStyle.toModifier().size(if (breakpoint >= Breakpoint.MD) 250.px else 270.px)
                        .align(Alignment.Center),
                    src = portfolioProjects.image,
                    description = portfolioProjects.title
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
                Text(portfolioProjects.title)
            }
            P(
                attrs = aboutDescription.toModifier().fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 14.px else 8.px).color(
                        Theme.MainColor.rgb
                    ).color(
                        Theme.Background.rgb
                    ).margin(topBottom = 0.px)
                    .toAttrs()
            ) {
                Text(portfolioProjects.subtitle)
            }
        }
    }

}

@Composable
fun PorfolioNavigation() {
    Row(
        modifier = Modifier.fillMaxWidth().margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.Center,
    ) {
        FaArrowLeft(
            modifier = portfolioNavigationStyle.toModifier().margin(right = 40.px).cursor(Cursor.Pointer).onClick {
                document.getElementById("portfolioContainer")?.scrollBy(x = -325.0, y=0.0)
            }, size = IconSize.XL
        )
        FaArrowRight(
            modifier = portfolioNavigationStyle.toModifier().margin(left = 40.px).cursor(Cursor.Pointer).onClick {

            },
            size = IconSize.XL
        )
    }
}