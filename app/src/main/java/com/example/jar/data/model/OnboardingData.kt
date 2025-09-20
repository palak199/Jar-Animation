package com.example.jar.data.model

data class EducationData(
    val toolBarText: String,
    val introTitle: String,
    val introSubtitle: String,
    val educationCardList: List<EducationCard>,
    val saveButtonCta: SaveBtn,
    val ctaLottie: String,
    val screenType: String?,
    val cohort: String?,
    val combination: String?,
    val collapseCardTiltInterval: Int,
    val collapseExpandIntroInterval: Int,
    val bottomToCenterTranslationInterval: Int,
    val expandCardStayInterval: Int,
    val seenCount: Int?,
    val actionText: String,
    val shouldShowOnLandingPage: Boolean,
    val toolBarIcon: String,
    val introSubtitleIcon: String,
    val shouldShowBeforeNavigating: Boolean

)
