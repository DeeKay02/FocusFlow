package com.learn.focusflow.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.learn.focusflow.R
import com.learn.focusflow.domain.model.Task
import com.learn.focusflow.domain.model.Topic
import com.learn.focusflow.presentation.components.CountCard
import com.learn.focusflow.presentation.components.TopicCard
import com.learn.focusflow.presentation.components.tasksList

@Composable
fun DashboardScreen() {

    val topics = listOf(
        Topic(name = "Learn", goalHours = 10f, colors = Topic.topicCardColors[0], topicId = 0),
        Topic(name = "Work", goalHours = 10f, colors = Topic.topicCardColors[1], topicId = 0),
        Topic(name = "Exercise", goalHours = 10f, colors = Topic.topicCardColors[2], topicId = 0),
        Topic(name = "Break", goalHours = 10f, colors = Topic.topicCardColors[3], topicId = 0),
        Topic(name = "Sleep", goalHours = 10f, colors = Topic.topicCardColors[4], topicId = 0)
    )

    val tasks = listOf(
        Task(
            title = "Exercise",
            description = "",
            dueDate = 0L,
            priority = 1,
            relatedToSubject = "",
            isComplete = false,
            taskTopicId = 0,
            taskId = 1
        ),
        Task(
            title = "Meditate",
            description = "",
            dueDate = 0L,
            priority = 2,
            relatedToSubject = "",
            isComplete = false,
            taskTopicId = 0,
            taskId = 1
        ),
        Task(
            title = "Study",
            description = "",
            dueDate = 0L,
            priority = 3,
            relatedToSubject = "",
            isComplete = true,
            taskTopicId = 0,
            taskId = 1
        ),
        Task(
            title = "Work",
            description = "",
            dueDate = 0L,
            priority = 1,
            relatedToSubject = "",
            isComplete = false,
            taskTopicId = 0,
            taskId = 1
        ),
        Task(
            title = "Read Book",
            description = "",
            dueDate = 0L,
            priority = 1,
            relatedToSubject = "",
            isComplete = false,
            taskTopicId = 0,
            taskId = 1
        ),
    )

    Scaffold(
        topBar = { DashboardScreenTopBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CountCardsSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    topicCount = 5,
                    focusedHours = "10",
                    goalHours = "15"
                )
            }
            item {
                SubjectCardsSection(
                    modifier = Modifier.fillMaxWidth(),
                    topicList = topics
                )
            }
            item { 
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp, vertical = 20.dp)
                ) {
                    Text(text = "Start Focus Session")
                }
            }
            tasksList(
                sectionTitle = "UPCOMING TASKS",
                emptyListText = "You don't have any upcoming tasks.\nClick + button in topics screen to add new task",
                tasks = tasks,
                onCheckBoxClick = {},
                onTaskCardClick = {}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardScreenTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "FocusFlow",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    )
}

@Composable
private fun CountCardsSection(
    modifier: Modifier,
    topicCount: Int,
    focusedHours: String,
    goalHours: String
) {
    Row(modifier = modifier) {
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Topic Counts",
            count = "$topicCount"
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Focused Hours",
            count = focusedHours
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Goal Focus Hours",
            count = goalHours
        )
    }
}

@Composable
private fun SubjectCardsSection(
    modifier: Modifier,
    topicList: List<Topic>,
    emptyListText: String = "You don't have any topics yet.\n Click the + button to add new topic."
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "TOPICS",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Subject"
                )
            }
        }
        if (topicList.isEmpty()) {
           Image(
               modifier = Modifier
                   .size(120.dp)
                   .align(Alignment.CenterHorizontally),
               painter = painterResource(R.drawable.img_books),
               contentDescription = emptyListText
           )
           Text(
               modifier = Modifier.fillMaxWidth(),
               text = emptyListText,
               style = MaterialTheme.typography.bodySmall,
               color = Color.Gray,
               textAlign = TextAlign.Center
           )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            items(topicList) {topic ->
                TopicCard(
                    topicName = topic.name,
                    gradientColors = topic.colors,
                    onClick = {}
                )
            }
        }
    }
}