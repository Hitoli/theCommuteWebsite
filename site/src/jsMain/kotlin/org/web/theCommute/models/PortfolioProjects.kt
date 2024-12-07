package org.web.theCommute.models

import org.web.theCommute.utils.Res

enum class PortfolioProjects(var image:String, var title:String, var subtitle:String, var link:String) {
    Factal(image = Res.Image.factalMockup, title = "Factal", subtitle = "Interview Prep App", link = "https://github.com/Hitoli/factal"),
    Mizu(image = Res.Image.mizuMockup, title = "Mizu", subtitle = "Water Tracking App", link = "https://github.com/Hitoli/Mizu"),


}