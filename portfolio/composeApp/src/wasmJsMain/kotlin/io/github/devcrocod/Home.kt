package io.github.devcrocod

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun HomePage(
    scrollState: ScrollState,
    onProjectClick: (String) -> Unit = {}  // Default empty callback
) {
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 32.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(vertical = 60.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(0.8f) // Constrain width for better readability
            ) {
                Text(
                    "Hello, I'm Pavel.",
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    "I design & build digital products",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Currently focused on Kotlin and modern web technologies.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    onClick = {
                        coroutineScope.launch {
                            scrollState.animateScrollTo(scrollState.maxValue)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp
                    )
                ) {
                    Text(
                        "View my work",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                    )
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 32.dp),
            thickness = 1.dp,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 60.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    "GitHub Activity",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Simplified GitHub activity visualization with fewer elements (6 instead of 12)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(6) { index ->
                        val height = (40 + Random.nextInt(10) * 7).dp

                        // Removed hover animation for better performance and simpler UI
                        Box(
                            modifier = Modifier
                                .width(32.dp) // Wider bars for better visibility
                                .height(height)
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 4.dp) // Added padding between bars
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    "Contributions last year",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 32.dp),
            thickness = 1.dp,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 60.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    "Selected Projects",
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ModernProjectCard(
                        title = "UI/UX Design System",
                        description = "A comprehensive design system for modern applications",
                        iconName = "design",
                        onClick = { onProjectClick("UI/UX Design System") }
                    )

                    ModernProjectCard(
                        title = "Kotlin Multiplatform App",
                        description = "Cross-platform application built with Kotlin",
                        iconName = "mobile",
                        onClick = { onProjectClick("Kotlin Multiplatform App") }
                    )

                    ModernProjectCard(
                        title = "Web Portfolio",
                        description = "Responsive portfolio website with modern UI",
                        iconName = "web",
                        onClick = { onProjectClick("Web Portfolio") }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ModernProjectCard(
                        title = "Data Visualization",
                        description = "Interactive data visualization dashboard",
                        iconName = "data",
                        onClick = { onProjectClick("Data Visualization") }
                    )

                    ModernProjectCard(
                        title = "AI Assistant",
                        description = "Intelligent assistant powered by machine learning",
                        iconName = "ai",
                        onClick = { onProjectClick("AI Assistant") }
                    )

                    ModernProjectCard(
                        title = "E-Commerce Platform",
                        description = "Modern shopping experience with seamless checkout",
                        iconName = "shop",
                        onClick = { onProjectClick("E-Commerce Platform") }
                    )
                }

                OutlinedButton(
                    onClick = { onProjectClick("all") },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(48.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Text(
                        "View all projects",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ModernProjectCard(
    title: String,
    description: String,
    iconName: String,
    onClick: () -> Unit = {}  // Default empty callback
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val elevation by animateDpAsState(
        targetValue = if (isHovered) 4.dp else 1.dp,
        animationSpec = tween(durationMillis = 200)
    )

    val padding by animateDpAsState(
        targetValue = if (isHovered) 0.dp else 2.dp,
        animationSpec = tween(durationMillis = 200)
    )

    Card(
        modifier = Modifier
            .width(220.dp)
            .hoverable(interactionSource)
            .fillMaxWidth(0.3f)
            .padding(padding)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when (iconName) {
                        "design" -> "△"
                        "mobile" -> "⬢"
                        "web" -> "◎"
                        "data" -> "◒"
                        "ai" -> "◇"
                        "shop" -> "▣"
                        else -> "◍"
                    },
                    fontSize = 40.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
