package org.web.theCommute.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Theme
import org.web.theCommute.utils.Constants

@Composable
fun SectionTitle(modifier: Modifier = Modifier, section: Sections, alignment: Alignment.Horizontal = Alignment.Start,breakpoint: Breakpoint) {

    Column(modifier, horizontalAlignment = alignment) {
        P(
            attrs = Modifier.fillMaxWidth()
                .textAlign(if (alignment == Alignment.CenterHorizontally) TextAlign.Center else TextAlign.Start)
                .fontFamily(Constants.FONT_FAMILY).margin(0.px)
                .margin(topBottom = 0.px)
                .fontSize(if (breakpoint>=Breakpoint.MD)25.px else 14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.MainColor.rgb).toAttrs()
        ) {
            Text(section.title)
        }
        P(
            attrs = Modifier.fillMaxWidth()
                .textAlign(if (alignment == Alignment.CenterHorizontally) TextAlign.Center else TextAlign.Start)
                .fontFamily(Constants.FONT_FAMILY).margin(0.px)
                .margin(bottom = 10.px, top = 0.px)
                .fontSize(if (breakpoint>=Breakpoint.MD)50.px else 20.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.HeroColor.rgb).toAttrs()
        ) {
            Text(section.subtitle)
        }
        Box(modifier = Modifier.height(2.px).width(80.px).backgroundColor(Theme.HeroColor.rgb).borderRadius(50.px)) {

        }
    }
}