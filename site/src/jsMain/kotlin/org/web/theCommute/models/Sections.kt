package org.web.theCommute.models

enum class Sections(val id: String, val title: String, val subtitle: String, val path: String) {
    Home(id = "home", title = "Home", subtitle = "Hi ;)", path = "#home"),
    About(id = "about", title = "About", subtitle = "About me", path = "#about"),
    Services(id = "services", title = "Services", subtitle = "How can I help you?", path = "#services"),
    Blogs(id = "blogs", title = "Blogs", subtitle = "Start Learning", path = "#blogs"),
    Apps(id = "apps", title = "Apps", subtitle = "My apps", path = "#apps"),
    Contact(id = "contact", title = "Contact", subtitle = "Contact us", path = "#contact"),
}