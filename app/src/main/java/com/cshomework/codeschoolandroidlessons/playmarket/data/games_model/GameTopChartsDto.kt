package com.cshomework.codeschoolandroidlessons.playmarket.data.games_model

import com.cshomework.codeschoolandroidlessons.playmarket.data.base.BaseItemType

enum class GameTopChartsDto(
   override val title: String,
    val imageUrl: String,
    val rating: Int,
    val memory: Int
) : BaseItemType {
    PLANTS_VS_ZOMBIES(
        "Plants vs. Zombies",
        "https://play-lh.googleusercontent.com/hO7716hh7NCcFauJedDclX-R3Zh9JmbSs8AUU6TP2edGVILlZM7gmyt_8WPCZELiPQA=w240-h480-rw",
        5,
        350
    ),
    CHAMPION_SOCCER_STAR(
        "Champion Soccer Star",
        "https://play-lh.googleusercontent.com/pBwwXn3Qf41B66c-uMJl7uPFDbo2pKumEigW4sBBK0-HJosNT2S1AM1pt7_TrFDepCg=w240-h480-rw",
        1,
        75

    ),
    SIERRA7(
        "SIERRA 7",
        "https://play-lh.googleusercontent.com/0hqfav3heUSiO2MCFcYDsMlQqnmJDYJHBT6ybePVkAnrD71gG4mHREBiGOtXBN91kA=w240-h480-rw",
        3,
        25
    ),
    SURVIVOR(
        "Survivor",
        "https://play-lh.googleusercontent.com/E0FsoKjKcCg8RNCniPOry-zBO1B4sP7DTiGqf0JooDreUmoeXrtZs2BuQ0cDwtuAowg=w240-h480-rw",
        4,
        72

    ),
    GROW_EMPIRE(
        "Grow Empire: Rome",
        "https://play-lh.googleusercontent.com/Xov-Vk-62BsydcB61FqQU7AR3mIMs6VtbpVlS-CgzgDfPM_ortsCJd0mL5-gDc5f3aA=w240-h480-rw",
        1,
        260
    ),
    NEW_STAR_MANAGER(
        "New Star Manager",
        "https://play-lh.googleusercontent.com/M46AXck-yfwNdtWvtbYy0w8pUOnVVtdYtknGOtN_EkI2TyRbxkjS9Dd6jxzbhCNZhcs=w240-h480-rw",
        5,
        100
    ),
    STEAMPUNK_DEFENSE(
        "Steampunk Defense",
        "https://play-lh.googleusercontent.com/KQvv42kBv8A8WRqmPbkXyF05D9LlRV02JnqpCm5sM79QomIowalwYlaBN_FIKYGLfNU=w240-h480-rw",
        5,
        132
    ),
    HILL_CLIMB_RACING(
        "Hill Climb Racing",
        "https://play-lh.googleusercontent.com/N0UxhBVUmx8s7y3F7Kqre2AcpXyPDKAp8nHjiPPoOONc_sfugHCYMjBpbUKCMlK_XUs=w240-h480-rw",
        1,
        78
    ),
    HEX_COMMANDER(
        "Hex Commander",
        "https://play-lh.googleusercontent.com/ba-cailn8Uto89GapJ9IUill199RQuGG7MxKLhAcglJjaurwVvxiWBDKpZ9mbxE0rRg=w240-h480-rw",
        2,
        200
    ),
    JETPACK_JOYRIDE(
        "Jetpack Joyride",
        "https://play-lh.googleusercontent.com/FbtvBLOS_if0XOyFvVIRp7l5Uc-Noy-rWBINWk-lEg6zyur6W37-wpg627lw_TVUGcA=w240-h480-rw",
        1,
        103
    ),
    CRASH_ARENA_TURBO_STARS(
        "Crash Arena Turbo Stars",
        "https://play-lh.googleusercontent.com/OLUuGQSs41nyHl91rk7JZ8v7o1-TY-9O_Xq890PeHfasx1V0WZPf4mz7_u-CzYNL7A=w240-h480-rw",
        4,
        150
    )
}
