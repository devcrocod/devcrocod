package io.github.devcrocod

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.devcrocod.style.PortfolioTheme
import kotlinx.coroutines.launch

enum class Screen {
    Home,
    About,
    Notes,
    Contact,
    ProjectDetail
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var currentScreen by remember { mutableStateOf(Screen.Home) }
    var selectedProject by remember { mutableStateOf("") }
    val homeScrollState = rememberScrollState()
    val aboutScrollState = rememberScrollState()
    val notesScrollState = rememberScrollState()
    val projectDetailScrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    val initialDarkTheme = isSystemInDarkTheme()
    var isDarkTheme by remember { mutableStateOf(initialDarkTheme) }

    PortfolioTheme(darkTheme = isDarkTheme) {
        val backgroundColor = MaterialTheme.colorScheme.background
        val textColor = MaterialTheme.colorScheme.onBackground
        val accentColor = MaterialTheme.colorScheme.primary

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Pavel Gorgulov",
                            fontSize = 18.sp,
                            color = textColor,
                            fontWeight = FontWeight.Light
                        )
                    },
                    actions = {
                        NavButton(
                            text = "Home",
                            isSelected = currentScreen == Screen.Home,
                            onClick = {
                                currentScreen = Screen.Home
                                coroutineScope.launch {
                                    homeScrollState.scrollTo(0)
                                }
                            }
                        )

                        NavButton(
                            text = "About",
                            isSelected = currentScreen == Screen.About,
                            onClick = {
                                currentScreen = Screen.About
                                coroutineScope.launch {
                                    aboutScrollState.scrollTo(0)
                                }
                            }
                        )

                        NavButton(
                            text = "Notes",
                            isSelected = currentScreen == Screen.Notes,
                            onClick = {
                                currentScreen = Screen.Notes
                                coroutineScope.launch {
                                    notesScrollState.scrollTo(0)
                                }
                            }
                        )

                        NavButton(
                            text = "Contact",
                            isSelected = currentScreen == Screen.Contact,
                            onClick = {
                                currentScreen = Screen.Contact
                            }
                        )

                        IconButton(
                            onClick = { isDarkTheme = !isDarkTheme },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = if (isDarkTheme) "Switch to light theme" else "Switch to dark theme",
                                tint = accentColor
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = backgroundColor
                    )
                )
            },
            containerColor = backgroundColor
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(if (isDarkTheme) 0xFF121212 else 0xFFF5F5F5))
                    .padding(paddingValues)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(if (isDarkTheme) 0.03f else 0.07f)
                        .background(
                            color = if (isDarkTheme) Color.White else Color.Black,
                            shape = androidx.compose.foundation.shape.GenericShape { size, _ ->
                                val dotSize = 2f
                                val spacing = 40f
                                for (x in 0..size.width.toInt() step spacing.toInt()) {
                                    for (y in 0..size.height.toInt() step spacing.toInt()) {
                                        addOval(
                                            androidx.compose.ui.geometry.Rect(
                                                x.toFloat(), 
                                                y.toFloat(), 
                                                x + dotSize, 
                                                y + dotSize
                                            )
                                        )
                                    }
                                }
                            }
                        )
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(backgroundColor)
                        .graphicsLayer {
                            alpha = 0.95f
                        }
                ) {
                AnimatedVisibility(
                    visible = currentScreen == Screen.Home,
                    enter = fadeIn(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)),
                    exit = fadeOut(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300))
                ) {
                    HomePage(
                        scrollState = homeScrollState,
                        onProjectClick = { projectTitle ->
                            selectedProject = projectTitle
                            currentScreen = Screen.ProjectDetail
                            coroutineScope.launch {
                                projectDetailScrollState.scrollTo(0)
                            }
                        }
                    )
                }

                AnimatedVisibility(
                    visible = currentScreen == Screen.About,
                    enter = fadeIn(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)),
                    exit = fadeOut(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300))
                ) {
                    AboutPage(aboutScrollState)
                }

                AnimatedVisibility(
                    visible = currentScreen == Screen.Notes,
                    enter = fadeIn(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)),
                    exit = fadeOut(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300))
                ) {
                    NotesPage(notesScrollState)
                }

                AnimatedVisibility(
                    visible = currentScreen == Screen.Contact,
                    enter = fadeIn(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)),
                    exit = fadeOut(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300))
                ) {
                    ContactPage()
                }

                AnimatedVisibility(
                    visible = currentScreen == Screen.ProjectDetail,
                    enter = fadeIn(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)) +
                            androidx.compose.animation.slideInHorizontally(
                                initialOffsetX = { it },
                                animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)
                            ),
                    exit = fadeOut(animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)) +
                            androidx.compose.animation.slideOutHorizontally(
                                targetOffsetX = { it },
                                animationSpec = androidx.compose.animation.core.tween(durationMillis = 300)
                            )
                ) {
                    ProjectDetailPage(
                        projectTitle = selectedProject,
                        scrollState = projectDetailScrollState,
                        onBackClick = {
                            currentScreen = Screen.Home
                        }
                    )
                }
                }
            }
        }
    }
}

@Composable
fun NavButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    TextButton(
        onClick = onClick,
        interactionSource = interactionSource,
        modifier = Modifier
            .hoverable(interactionSource)
            .padding(horizontal = 4.dp)
            .height(48.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = if (isSelected || isHovered) 
                MaterialTheme.colorScheme.primary 
            else 
                MaterialTheme.colorScheme.onBackground,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
        )
    }
}
