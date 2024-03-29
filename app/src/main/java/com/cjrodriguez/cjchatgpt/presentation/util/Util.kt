package com.cjrodriguez.cjchatgpt.presentation.util

fun <T> tryCatch(input: T): String {
    var errorMessage = ""
    try {
        input
    } catch (ex: Exception) {
        errorMessage = ex.message.toString()
    }
    return errorMessage
}

val SYNONYMS_OF_IMAGE = arrayOf(
    "picture",
    "image",
    "portrait",
    "illustration",
    "depiction",
    "photograph",
    "likeness",
    "representation",
    "drawing",
    "view",
    "icon",
    "collage",
    "resemblance",
    "sketch",
    "silhouette",
    "diagram",
    "etching",
    "montage",
    "delineation",
    "caricature",
    "cartoon",
    "doodle",
    "daub",
    "hieroglyph",
    "ideogram",
    "ideograph",
    "pictograph",
    "hieroglyphic"
)

fun shouldTriggerImageModel(prompt: String): Boolean {
    return prompt.contains("/imagine")
}

fun String.removeImagine(): String {
    return this.replace("/imagine", "")
}
