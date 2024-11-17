package com.example.logotypes

//{
//    "records": {
//    "1password": [
//    {
//        "example_description": "1Password helps you keep your digital life secure by storing passwords, credit card details, and documents in an encrypted vault. Generate strong passwords, access your data from any device, and enjoy peace of mind with 1Password\\'s robust security features.",
//        "example_title": "Secure your digital life",
//        "logo": "https://logotypes.dev/static/logos/1password-glyph-color.svg",
//        "name": "1password",
//        "variant": "glyph",
//        "version": "color"
//    },
//    {
//        "example_description": "1Password helps you keep your digital life secure by storing passwords, credit card details, and documents in an encrypted vault. Generate strong passwords, access your data from any device, and enjoy peace of mind with 1Password\\'s robust security features.",
//        "example_title": "Secure your digital life",
//        "logo": "https://logotypes.dev/static/logos/1password-wordmark-color.svg",
//        "name": "1password",
//        "variant": "wordmark",
//        "version": "color"
//    }
//    ],
//    "abstract": [
//    {
//        "example_description": "Abstract is a design collaboration tool that streamlines the design process. It enables teams to work together on design projects with version control, feedback management, and seamless integrations, enhancing productivity and creativity in the design workflow.",
//        "example_title": "Design collaboration redefined",
//        "logo": "https://logotypes.dev/static/logos/abstract-glyph-color.svg",
//        "name": "Abstract",
//        "variant": "glyph",
//        "version": "color"
//    }

data class Logo(
    val name: String,
    val variant: String,
    val version: String,
    val logo: String,
    val example_description: String?,
    val example_title: String?
)

data class ApiResponse(
    val records: Map<String, List<Logo>>
)
