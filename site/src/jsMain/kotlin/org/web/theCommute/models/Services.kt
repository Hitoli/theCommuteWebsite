package org.web.theCommute.models

import org.web.theCommute.utils.Res

enum class Services(var image:String, var imageDesc:String, var title:String, var description:String) {
    Android(image = Res.Image.android, imageDesc = "Android", title = "Android Development", description = "From concept to launch, I build apps that not only function seamlessly but also provide an engaging user experience. Whether you're looking to develop a brand-new app or improve an existing one, I combine technical expertise and creativity to deliver solutions that stand out on the Play Store"),
    AppMarketing(image = Res.Image.androidMarketing, imageDesc = "App Marketing", title = "App Marketing", description = "I offer expert app marketing services to help your app stand out and succeed in a competitive market. From crafting compelling app store listings to optimizing UI/UX, content marketing, and brand building, I ensure your app attracts and retains users.")
}