package org.web.theCommute.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Theme

@Composable
fun TestimonialSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Sections.Testimonials.id)
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 70.percent else 90.percent).padding(topBottom = 40.px)
            .border(width = 0.1.px, color = Theme.HeroColor.rgb, style = LineStyle.Solid).borderRadius(20.px)
            .margin(topBottom = 40.px), contentAlignment = Alignment.Center
    ) {
        TestimonialContent()
    }

}


@Composable
fun TestimonialContent() {

}


@Composable
fun TestimonialCard(){

}