package com.example.codeschoolandroidlessons.playmarket.data.apps_model

import com.example.codeschoolandroidlessons.playmarket.data.base.BaseItemType

enum class AppsTopChartsDto(
   override val title: String,
    val imageUrl: String,
    val rating: Int,
    val memory: Int
): BaseItemType {
    WHATSAPP(
        "WhatsApp",
        "https://play-lh.googleusercontent.com/bYtqbOcTYOlgc6gqZ2rwb8lptHuwlNE75zYJu6Bn076-hTmvd96HH-6v7S0YUAAJXoJN=w240-h480-rw",
        4,
        25
    ),
    FACEBOOK(
        "Facebook",
        "https://play-lh.googleusercontent.com/ccWDU4A7fX1R24v-vvT480ySh26AYp97g1VrIB_FIdjRcuQB2JP2WdY7h_wVVAeSpg=w240-h480-rw",
        5,
        40
    ),
    SNAPCHAT(
        "Snapchat",
        "https://play-lh.googleusercontent.com/KxeSAjPTKliCErbivNiXrd6cTwfbqUJcbSRPe_IBVK_YmwckfMRS1VIHz-5cgT09yMo=w240-h480-rw",
        3,
        20
    ),
    TELEGRAM(
        "Telegram",
        "https://play-lh.googleusercontent.com/ZU9cSsyIJZo6Oy7HTHiEPwZg0m2Crep-d5ZrfajqtsH-qgUXSqKpNA2FpPDTn-7qA5Q=w240-h480-rw",
        5,
        35
    ),
    SPOTIFY(
        "Spotify",
        "https://play-lh.googleusercontent.com/UrY7BAZ-XfXGpfkeWg0zCCeo-7ras4DCoRalC_WXXWTK9q5b0Iw7B0YQMsVxZaNB7DM=w240-h480-rw",
        2,
        215
    ),
    XBOX(
        "Xbox",
        "https://play-lh.googleusercontent.com/hihXCV-0wxOXB5N7uBREaJeCVK0BDjNEBtKwNAncftZMflpEvasiKXn7vCKxu9qGpvk=w240-h480-rw",
        5,
        85
    ),
    UPWORK(
        "UpWork",
        "https://play-lh.googleusercontent.com/y4bswMT02OROjzOPa5zDGsnXX5-cBABjF93j26seJH2cEHD4PuBW1d5VvwfYleeKf4_X=w240-h480-rw",
        3,
        111
    ),
    PINTEREST(
        "Pinterest",
        "https://play-lh.googleusercontent.com/dVsv8Hc4TOUeLFAahxR8KANg22W9dj2jBsTW1VHv3CV-5NCZjP9D9i2j5IpfVx2NTB8=w240-h480-rw",
        1,
        68
    ),
    REDDIT(
        "Reddit",
        "https://play-lh.googleusercontent.com/nlptFyxNsb8J0g8ZLux6016kunduV4jCxIrOJ7EEy-IobSN1RCDXAJ6DTGP81z7rr5Zq=w240-h480-rw",
        4,
        150
    ),
    KHAN_ACADEMY(
        "Khan Academy",
        "https://play-lh.googleusercontent.com/TpK0AcjPn5-XDKgSZ5jAob1H7MsQuJILOMR4M4QYkTt5CBPgTJVr7mysrKM6Ia8SrX8=w240-h480-rw",
        1,
        10
    ),
    SAMSUNG_MEMBERS(
        "Samsung Members",
        "https://play-lh.googleusercontent.com/5MlRrSa9Wm47Ig9kd9mDD9J3ekq_Pj1LXqeEJ3korTCsrc2d68HBWJYNYs6_p_fMBw=w240-h480-rw",
        5,
        170
    )
}