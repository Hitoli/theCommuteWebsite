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
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.SectionTitle
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Testimonials
import org.web.theCommute.models.Theme
import org.web.theCommute.models.WorkExperience
import org.web.theCommute.style.aboutDescription
import org.web.theCommute.style.workExperienceDescription
import org.web.theCommute.style.workExperiencePara
import org.web.theCommute.utils.Constants

@Composable
fun WorkExperienceSection() {

    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Sections.WorkExperience.id)
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent).padding(topBottom = 10.px)
            .borderRadius(20.px)
            .margin(topBottom = 20.px), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SectionTitle(
                section = Sections.WorkExperience,
                modifier = Modifier.padding(bottom = 20.px),
                alignment = Alignment.CenterHorizontally, breakpoint = breakpoint
            )
            WorkExperience.values().forEach { workExperience ->
                WorkExperienceCard(breakpoint = breakpoint, active = workExperience.number == 1, experience = workExperience)
            }

        }

    }

}


@Composable
fun WorkExperienceCard(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: WorkExperience
) {
    SimpleGrid(
        modifier = Modifier.fillMaxWidth().maxWidth(if (breakpoint > Breakpoint.MD) 60.percent else 90.percent),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        WorkExperienceDescription(workExperience = experience, breakpoint = breakpoint, active = active)
        WorkExperienceDetails(breakpoint = breakpoint, experience = experience, active = active)
    }

}

@Composable
fun WorkExperienceDescription(workExperience: WorkExperience, breakpoint: Breakpoint, active: Boolean) {
    Box(
        modifier = Modifier.fillMaxHeight().padding(10.px).margin(topBottom = 10.px)
            .background(if (active) Theme.HeroColor.rgb else Theme.BackgrounMain.rgb)
    ) {
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px)
                .color(if (!active) Theme.MainColor.rgb else Colors.White).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(workExperience.description)
        }
    }
}

@Composable
fun WorkExperienceDetails(
    breakpoint: Breakpoint,
    experience: WorkExperience,
    active: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth().margin(left = if (breakpoint > Breakpoint.MD) 14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        Box(Modifier.fillMaxHeight().margin(right = 14.px)) {
            Box(modifier = Modifier.fillMaxHeight().width(3.px).background(Theme.HeroColor.rgb).align(Alignment.Center))
            Box(
                modifier = Modifier.size(40.px).backgroundColor(if (active) Theme.HeroColor.rgb else Color.white)
                    .border(width = 3.px, style = LineStyle.Solid, color = Theme.HeroColor.rgb)
                    .borderRadius(50.percent).align(Alignment.Center), contentAlignment = Alignment.Center
            ) {
                P(
                    attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                        .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px)
                        .color(if (!active) Theme.MainColor.rgb else Colors.White).margin(topBottom = 6.px)
                        .toAttrs()
                ) {
                    Text(experience.number.toString())
                }
            }
        }
        WorkExperienceContent(workExperience = experience, active = active, breakpoint = breakpoint)
    }

}

@Composable
fun WorkExperienceContent(
    workExperience: WorkExperience,
    active: Boolean,
    breakpoint: Breakpoint
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 16.px else 8.px)
                .color(if (active) Theme.MainColor.rgb else Theme.HeroColor.rgb).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(workExperience.nameCompany)
        }
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 12.px else 8.px)
                .color(if (active) Theme.MainColor.rgb else Theme.HeroColor.rgb).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(workExperience.position)
        }
        P(
            attrs = Modifier.fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.LG) 12.px else 8.px)
                .color(if (active) Theme.MainColor.rgb else Theme.HeroColor.rgb).margin(topBottom = 6.px)
                .toAttrs()
        ) {
            Text(workExperience.dateStart)
        }
    }
}