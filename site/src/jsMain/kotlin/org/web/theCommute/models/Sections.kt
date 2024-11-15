package org.web.theCommute.models

enum class Sections(val id: String, val title: String, val subtitle: String, val path: String) {
    Home(id = "home", title = "Home", subtitle = "", path = "#home"),
    Blogs(id = "blogs", title = "Blogs", subtitle = "", path = "#blogs"),
    Apps(id = "apps", title = "Apps", subtitle = "All of the apps", path = "#apps"),
    Contact(id = "contact", title = "Contact", subtitle = "Contact us", path = "#contact"),
}