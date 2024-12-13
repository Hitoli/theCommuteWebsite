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
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.SectionTitle
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Testimonials
import org.web.theCommute.models.Theme
import org.web.theCommute.models.WorkExperience
import org.web.theCommute.style.aboutDescription
import org.web.theCommute.utils.Constants

@Composable
fun WorkExperienceSection(){

    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Sections.WorkExperience.id)
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent).padding(topBottom = 10.px)
            .borderRadius(20.px)
            .margin(topBottom = 20.px), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.maxWidth(1100.px),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                section = Sections.WorkExperience,
                modifier = Modifier.padding(bottom = 20.px),
                alignment = Alignment.CenterHorizontally, breakpoint = breakpoint
            )
            WorkExperienceDescription(workExperience = WorkExperience.GeeksForGeeks, breakpoint)
        }

    }

}


@Composable
fun WorkExperienceCard(){

}

@Composable
fun WorkExperienceDescription(workExperience: WorkExperience, breakpoint:Breakpoint){
    Box(
        modifier = Modifier.fillMaxHeight().padding(10.px).margin(bottom = 10.px)
    ) {
        P(
            attrs = aboutDescription.toModifier().fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px).color(
                    Theme.MainColor.rgb
                ).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(workExperience.description)
        }
    }
}