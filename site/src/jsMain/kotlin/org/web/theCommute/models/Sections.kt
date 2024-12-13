package org.web.theCommute.models

enum class Sections(val id: String, val title: String, val subtitle: String, val path: String) {
    Home(id = "home", title = "Home", subtitle = "Hi ;)", path = "#home"),
    About(id = "about", title = "About", subtitle = "About me", path = "#about"),
    Testimonials(id = "Testimonials", title = "Testimonials", subtitle = "Hear from people", path = "#testimonial"),
    Services(id = "services", title = "Services", subtitle = "How can I help you?", path = "#services"),
    Apps(id = "apps", title = "Apps", subtitle = "My apps", path = "#apps"),
    WorkExperience(id = "workExperience", title = "Experience", subtitle = "Work Experience", path = "#experience"),
    Contact(id = "contact", title = "Contact", subtitle = "Contact us", path = "#contact"),
}