package org.web.theCommute.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.InputSize
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.common.PlaceholderColor
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Theme
import org.web.theCommute.style.ButtonStyle


@Composable
fun ContactSection() {
    val breakpoint = rememberBreakpoint()
    var onTextValue by remember{
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxWidth()){
        TextInput(
            text = onTextValue,
            onTextChange = {
                onTextValue = it
            },
            modifier = Modifier.fillMaxWidth(if (breakpoint>Breakpoint.MD)100.percent else 50.percent).height(8.percent)
                .border(style = LineStyle.Solid, color = Theme.HeroColor.rgb, width = 1.px)
                .borderRadius(r = 5.px),
            placeholderColor = PlaceholderColor(Theme.BlackColor.rgb),
            placeholder = "Email@gmail.com",
            focusBorderColor = Theme.MainColor.rgb,
            size = if (breakpoint>Breakpoint.MD) InputSize.LG else InputSize.SM
        )

        Button(
            attrs = ButtonStyle.toModifier().height(if (breakpoint>Breakpoint.MD)50.px else 30.px).width(if (breakpoint>Breakpoint.MD)120.px else 80.px).onClick {

            }.toAttrs()
        ) {

            Link(
                path = Sections.Contact.path,
                modifier = Modifier.color(Colors.White).textDecorationLine(TextDecorationLine.None).fontSize(if (breakpoint>=Breakpoint.LG)16.px else 10.px),
                text = "Subscribe"
            )
        }

    }
}
