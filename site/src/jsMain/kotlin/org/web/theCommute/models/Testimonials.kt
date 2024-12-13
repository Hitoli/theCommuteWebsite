package org.web.theCommute.models

import org.web.theCommute.utils.Res

enum class Testimonials(var client: String, var testimonial: String, var image: String) {
    Testimonial1(
        client = "Azim Siddqui",
        testimonial = "Communication is the skill where most of the people lack even in corporate, But you know very well how to share your thoughts with people. Having good knowledge in android is the another key factor which will definitely help you in getting a Good job.",
        image =  Res.Image.azimSir
    ),
    Testimonial2(
        client = "Gandharva Kumar",
        testimonial = "Highly curious, a critical thinker, and always asking the right questions to drive meaningful outcomes.",
        image =  Res.Image.gandharvaSir
    ),
}