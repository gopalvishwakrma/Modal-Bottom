package com.example.learningtimepass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainFunction()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainFunction() {
        var showSheet by remember { mutableStateOf(false) }
        if (showSheet) {
            BottomSheet() {
                showSheet = false
            }
        }
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(
                            "Gopal Vishwakarma",
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Let's connect and share knowledge.",
                        fontStyle = FontStyle.Italic,
                        fontSize = 16.sp
                    )
                }
            },
            content = { innerPadding ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Bottom sheets",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Text(
                        text = "Click on the button to show bottom sheet",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(15.dp)
                    )
                    Button(
                        onClick = {
                            showSheet = true
                        }
                    ) {
                        Text(
                            text = "Show BottomSheet",
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(6.dp)
                        )
                    }
                }
            }
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BottomSheet(onDismiss: () -> Unit) {
        val modalBottomSheetState = rememberModalBottomSheetState()

        ModalBottomSheet(
            onDismissRequest = {
                onDismiss()
            },
            sheetState = modalBottomSheetState,
            dragHandle = {
                BottomSheetDefaults.DragHandle()
            }
        ) {
            CountryList()
        }
    }

    @Composable
    fun CountryList() {
        val allProgrammingLanguagesWithUnicode = listOf(
            Triple(
                "Java",
                "\uD83C\uDDEF\uD83C\uDDF5",
                "General-purpose, class-based, object-oriented programming language."
            ),
            Triple(
                "Python",
                "\uD83D\uDC0D",
                "Interpreted, high-level, general-purpose programming language."
            ),
            Triple(
                "JavaScript",
                "\uD83D\uDD25",
                "High-level, just-in-time compiled, object-oriented programming language."
            ),
            Triple(
                "C++",
                "\uD83D\uDC68\u200D\uD83D\uDCBB",
                "General-purpose programming language created as an extension of the C programming language."
            ),
            Triple(
                "Kotlin",
                "\uD83C\uDDF7\uD83C\uDDFA",
                "Cross-platform, statically typed, general-purpose programming language with type inference."
            ),
            Triple(
                "Swift",
                "\uD83D\uDC1D",
                "General-purpose, multi-paradigm, compiled programming language developed by Apple Inc."
            ),
            Triple(
                "Go",
                "\uD83D\uDEA9",
                "Statistically typed, compiled programming language designed at Google."
            ),
            Triple(
                "Rust",
                "\uD83D\uDD28",
                "Multi-paradigm programming language designed for performance and safety."
            ),
            Triple(
                "Ruby",
                "\uD83D\uDC8E",
                "Interpreted, high-level, general-purpose programming language."
            ),
            Triple(
                "PHP",
                "\uD83D\uDC3E",
                "General-purpose scripting language especially suited to web development."
            ),
            Triple(
                "Perl",
                "\uD83D\uDC0A",
                "High-level, general-purpose, interpreted, dynamic programming language."
            ),
            Triple(
                "R",
                "\uD83D\uDC3B",
                "Software environment for statistical computing and graphics supported by the R Foundation."
            ),
            Triple(
                "Scala",
                "\uD83D\uDC79",
                "General-purpose programming language providing support for functional programming and a strong static type system."
            ),
            Triple(
                "Groovy",
                "\uD83D\uDC7B",
                "Object-oriented programming language for the Java platform."
            ),
            Triple(
                "Lua",
                "\uD83D\uDC1F",
                "High-level, multi-paradigm programming language designed primarily for embedded use in applications."
            ),
            Triple(
                "MATLAB",
                "\uD83D\uDCC8",
                "Multi-paradigm numerical computing environment and proprietary programming language developed by MathWorks."
            ),
            Triple(
                "TypeScript",
                "\uD83D\uDD27",
                "Open-source language which builds on JavaScript by adding static type definitions."
            ),
            Triple(
                "Shell",
                "\uD83D\uDC68\u200D\uD83D\uDCBB",
                "Command-line interpreter that provides a command line user interface for Unix-like operating systems."
            ),
            Triple(
                "Objective-C",
                "\uD83D\uDCBB",
                "General-purpose, object-oriented programming language that adds Smalltalk-style messaging to the C programming language."
            ),
            Triple(
                "HTML",
                "\uD83D\uDCC4",
                "Standard markup language for documents designed to be displayed in a web browser."
            ),
            Triple(
                "CSS",
                "\uD83C\uDFA8",
                "Style sheet language used for describing the look and formatting of a document written in HTML."
            ),
            Triple(
                "SQL",
                "\uD83D\uDD0E",
                "Domain-specific language used in programming and designed for managing data held in a relational database management system."
            ),
            Triple(
                "C#",
                "\uD83D\uDC68\u200D\uD83D\uDCBB",
                "General-purpose, multi-paradigm programming language encompassing static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."
            ),
            Triple(
                "Dart",
                "\uD83C\uDFA8",
                "Client-optimized programming language for apps on multiple platforms."
            ),
            Triple(
                "Elixir",
                "\uD83E\uDD55",
                "Dynamic, functional language designed for building scalable and maintainable applications."
            ),
            Triple(
                "Clojure",
                "\uD83D\uDC0A",
                "Modern, dynamic, and functional dialect of the Lisp programming language on the Java platform."
            ),
            Triple(
                "Haskell",
                "\uD83D\uDC3A",
                "Purely functional programming language with strong static typing and lazy evaluation."
            ),
            Triple(
                "Julia",
                "\uD83D\uDC31",
                "High-level, high-performance dynamic programming language for technical computing."
            ),
            Triple(
                "F#",
                "\uD83D\uDC3C",
                "Strongly typed, multi-paradigm programming language that encompasses functional, imperative, and object-oriented programming methods."
            ),
            Triple(
                "Erlang",
                "\uD83D\uDC1E",
                "General-purpose, concurrent, functional programming language, as well as a garbage-collected runtime system."
            )
        )

        LazyColumn {
            items(allProgrammingLanguagesWithUnicode) { (languageName, emoji, description) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                ) {
                    Text(
                        text = emoji,
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Column {
                        Text(text = languageName, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                        Text(text = description, fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }
        }
    }
}