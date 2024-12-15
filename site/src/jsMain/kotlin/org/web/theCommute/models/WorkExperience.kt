package org.web.theCommute.models

enum class WorkExperience(
    var dateStart: String,
    var dateEnd: String,
    var description: String,
    var nameCompany: String,
    var position: String,
    var number:Int
) {
    GeeksForGeeks(
        dateStart = "July 2024",
        dateEnd = "Present",
        description = ".Working to add More products to the GFG app",
        nameCompany = "GeeksForGeeks",
        position = "Android Developer",
        number = 3
    ),
    Singsys(
        dateStart = "Oct 2023",
        dateEnd = "July 2024",
        description = "• Migrated 10+ App screens from XML to Jetpack Compose, added Api functionality and implemented Logic with\n" +
                "technologies like Kotlin, Ktor and Koin\n" +
                "• Developed an App using Flutter, and Getx State management libraries and followed MVVM architecture to make\n" +
                "the app scalable for 10,000+ users\n" +
                "• Collaborated with a team of 4 back-end developers and 2 front-end developers to complete Knight Frank App\n" +
                "• Attended 10+ client meetings to present 3 prototypes\n" +
                "• Used Leak Canary to spot memory leaks and solved them\n" +
                "• Solved multiple complex issues like conditional navigation and integrated third-party API like Video SDK\n" +
                "• Solved 5+ security issues in MOBSF test in production app",
        nameCompany = "Singsys",
        position = "Software Engineer",
        number = 2
    ),
    AnoopRefrigeration(
        dateStart = "Dec 2022",
        dateEnd = "May 2023",
        description = "• Developed an Inventory Management Android App with Kotlin and Firebase, which streamlined inventory tracking\n" +
                "and spending for businesses\n" +
                "• Worked on 12+ screens on technologies like XML, Dagger Hilt, Retrofit and Firebase\n" +
                "• Attended 5+ client meetings to understand requirements and presented 4+ prototypes\n" +
                "• Used MVVM architecture and practised separation of concerns to make app scalable",
        nameCompany = "Anoop Refrigeration",
        position = "Android Developer",
        number = 1
    ),



}