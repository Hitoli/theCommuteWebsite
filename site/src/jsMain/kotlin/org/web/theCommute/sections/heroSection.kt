package org.web.theCommute.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.CSSFilter
import com.varabyte.kobweb.compose.css.functions.grayscale
import com.varabyte.kobweb.compose.css.functions.hueRotate
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.common.PlaceholderColor
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.shapes.Shape
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.Transition
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.EmailInput
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.web.theCommute.components.Header
import org.web.theCommute.models.Sections
import org.web.theCommute.models.Theme
import org.web.theCommute.style.BackgroundStyles
import org.web.theCommute.style.ButtonStyle
import org.web.theCommute.utils.Constants

@Page
@Composable
fun HeroSection() {
    val breakpoint = rememberBreakpoint()
    var textValue by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize().id(Sections.Home.id)) {
        Background()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            Hero(breakpoint, textValue = textValue, onTextChange = {
                textValue = it
            }, onSubmit = {
                textValue = it
                println(textValue)
            })


        }

    }

}

@OptIn(ExperimentalComposeWebApi::class)
@Page
@Composable
fun MainBackground(breakpoint: Breakpoint) {
    val size = if (breakpoint>=Breakpoint.MD) 80.percent else 50.percent
    Image(
        modifier = BackgroundStyles.toModifier().fillMaxWidth(size).objectFit(ObjectFit.Cover) .borderRadius(500.px),
        src = "hiteshbg.jpg",
        description = "hitesh bg"
    )
}

@OptIn(ExperimentalComposeWebApi::class)
@Page
@Composable
fun Background() {

        Image(
            modifier = Modifier.fillMaxWidth().objectFit(ObjectFit.Cover),
            src = "background.jpg",
            description = "background bg"
        )


}


@Page
@Composable
fun Hero(breakpoint: Breakpoint, textValue: String, onTextChange: (String) -> Unit,onSubmit:(String)->Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 70.percent else 80.percent)
                .align(Alignment.CenterHorizontally),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                P(
                    attrs = Modifier.fontFamily(Constants.FONT_FAMILY).margin(0.px).fontSize(if (breakpoint>=Breakpoint.LG)50.px else 20.px)
                        .color(Theme.MainColor.rgb).toAttrs()
                ) {
                    Text("Hello, I'm")
                }
                P(
                    attrs = Modifier.fontFamily(Constants.FONT_FAMILY).fontSize(if (breakpoint>=Breakpoint.LG)50.px else 20.px).color(Theme.MainColor.rgb)
                        .fontWeight(FontWeight.Bold).margin(0.px).toAttrs()
                ) {
                    Text("Hitesh Kohli")
                }
                P(
                    attrs = Modifier.fontFamily(Constants.FONT_FAMILY).fontSize(if (breakpoint>=Breakpoint.LG)20.px else 10.px).color(Theme.HeroColor.rgb)
                        .margin(top = 10.px, bottom = 10.px, right = 0.px, left = 0.px)
                        .toAttrs()
                ) {
                    Text("App Developer & Marketer")
                }

                P(
                    attrs = Modifier.fontFamily(Constants.FONT_FAMILY).fontSize(if (breakpoint>=Breakpoint.LG)20.px else 10.px).color(Theme.MainColor.rgb)
                        .margin(top = 10.px, bottom = 10.px, right = 0.px, left = 0.px)
                        .toAttrs()
                ) {
                    Text("I make apps and help other market their apps. Also, I document my journey on my website. I hope you enjoy your visit here :)")
                }

                P(
                    attrs = Modifier.fontFamily(Constants.FONT_FAMILY).fontSize(if (breakpoint>=Breakpoint.LG)16.px else 8.px).color(Color.black).fontStyle(
                        FontStyle.Italic
                    )
                        .margin(top = 20.px, bottom = 5.px, right = 0.px, left = 0.px)
                        .toAttrs()
                ) {
                    Text(
                        "If you want to receive App Development and Marketing Tips delivered straight to your inbox. "
                    )
                }

                P(
                    attrs = Modifier.fontFamily(Constants.FONT_FAMILY).fontSize(if (breakpoint>=Breakpoint.LG)16.px else 8.px).color(Color.black).fontStyle(
                        FontStyle.Italic
                    )
                        .margin(top = 5.px, bottom = 5.px, right = 0.px, left = 0.px)
                        .toAttrs()
                ) {
                    Text(
                        "Just enter your email below"
                    )
                }

                TextInput(
                    text = textValue,
                    onTextChange = onTextChange,
                    modifier = Modifier.fillMaxWidth().height(8.percent)
                        .border(style = LineStyle.Solid, color = Theme.HeroColor.rgb, width = 1.px)
                        .borderRadius(r = 5.px),
                    placeholderColor = PlaceholderColor(Theme.BlackColor.rgb),
                    placeholder = "Email@gmail.com",
                    focusBorderColor = Theme.MainColor.rgb
                )

                Button(
                    attrs = ButtonStyle.toModifier().onClick {
                        onSubmit(textValue)
                    }.toAttrs()
                ) {

                    Link(
                        path = Sections.Contact.path,
                        modifier = Modifier.color(Colors.White).textDecorationLine(TextDecorationLine.None).fontSize(14.px),
                        text = "Subscribe"
                    )
                }


            }
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MainBackground(breakpoint)
            }

        }
    }
}