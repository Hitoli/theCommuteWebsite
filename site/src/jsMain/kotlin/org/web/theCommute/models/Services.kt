package org.web.theCommute.models

import org.web.theCommute.utils.Res

enum class Services(var image:String, var imageDesc:String, var title:String, var description:String) {
    Android(image = Res.Image.android, imageDesc = "Android", title = "Android Development", description = "Working on Android Development"),
    AppMarketing(image = Res.Image.androidMarketing, imageDesc = "App Marketing", title = "App Marketing", description = "Working on App Marketing")
}