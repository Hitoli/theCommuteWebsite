package org.web.theCommute.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.web.theCommute.models.Theme
import org.web.theCommute.sections.*


@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.background(Theme.BackgrounMain.rgb).fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeroSection()
        AboutSection()
        ServiceSections()
        PortfolioSection()
        TestimonialSection()
    }
}
