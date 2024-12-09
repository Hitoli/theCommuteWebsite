package org.web.theCommute.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
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
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.SectionTitle
import org.web.theCommute.models.PortfolioProjects
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Testimonials
import org.web.theCommute.models.Theme
import org.web.theCommute.style.aboutDescription
import org.web.theCommute.style.myWorkStyle
import org.web.theCommute.style.servicesStyle
import org.web.theCommute.utils.Constants

@Composable
fun TestimonialSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Sections.Testimonials.id)
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent).padding(topBottom = 10.px)
            .borderRadius(20.px)
            .margin(topBottom = 40.px), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.maxWidth(1100.px),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                section = Sections.Testimonials,
                modifier = Modifier.padding(bottom = 20.px),
                alignment = Alignment.CenterHorizontally, breakpoint = breakpoint
            )
            Row(
                modifier = Modifier.id("testimonialContainer").fillMaxWidth().margin(bottom = 25.px)
                    .maxWidth(if (breakpoint > Breakpoint.MD) 1000.px else if (breakpoint > Breakpoint.SM) 625.px else 300.px)
                    .overflow(
                        Overflow.Hidden
                    ).scrollBehavior(
                        ScrollBehavior.Smooth
                    ), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
            ) {
                Testimonials.values().forEach {
                    TestimonialContent(breakpoint = breakpoint, testimonials = it)
                }
            }
        }

    }

}


@Composable
fun TestimonialContent(testimonials: Testimonials, breakpoint: Breakpoint) {

    Column(
        modifier = Modifier.maxWidth(400.px).maxHeight(400.px)
            .padding(20.px), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly
    ) {

        TestimonialCard(breakpoint, testimonials)
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px).color(
                    Theme.MainColor.rgb
                ).color(
                    Theme.Background.rgb
                ).margin(topBottom = 0.px)
                .toAttrs()
        ) {
            Text(testimonials.client)
        }
        P(
            attrs = aboutDescription.toModifier().fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px).color(
                    Theme.MainColor.rgb
                ).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(testimonials.testimonial)
        }

    }

}


@Composable
fun TestimonialCard(breakpoint: Breakpoint, testimonials: Testimonials) {
    Box(
        modifier = Modifier.padding(10.px).margin(bottom = 10.px)
    ) {
        Image(
            modifier = Modifier.borderRadius(topLeft = 50.px, topRight = 50.px, bottomLeft = 50.px)
                .size(if (breakpoint >= Breakpoint.MD) 250.px else 270.px)
                .align(Alignment.Center),
            src = testimonials.image,
            description = testimonials.client
        )
    }
}