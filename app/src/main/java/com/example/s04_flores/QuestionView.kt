package com.example.s04_flores

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String
)

class QuestionView : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var buttons: List<Button>
    private var currentQuestionIndex = 0
    private var score = 0

    private val questions = listOf(
        Question(
            "¿Cuál es el pilar fundamental de las aplicaciones móviles?",
            listOf("Interfaz de usuario", "Rendimiento", "Experiencia del usuario", "Base de datos"),
            2,
            "La experiencia del usuario (UX) es esencial para garantizar que una app sea útil y agradable."
        ),
        Question(
            "¿Qué lenguaje es nativo para el desarrollo en Android?",
            listOf("Swift", "Kotlin", "JavaScript", "Python"),
            1,
            "Kotlin es el lenguaje recomendado por Google para el desarrollo de apps Android."
        ),
        Question(
            "¿Qué lenguaje se utiliza principalmente para desarrollar apps en iOS?",
            listOf("Java", "Objective-C", "Swift", "C#"),
            2,
            "Swift es el lenguaje moderno y oficial para el desarrollo de aplicaciones iOS."
        ),
        Question(
            "¿Qué patrón de arquitectura es común en el desarrollo móvil?",
            listOf("MVC", "MVVM", "MVP", "Todos los anteriores"),
            3,
            "MVC, MVVM y MVP son patrones comunes dependiendo del framework o plataforma."
        ),
        Question(
            "¿Qué herramienta se usa para construir interfaces en Android?",
            listOf("Storyboard", "Jetpack Compose", "Xcode", "UIKit"),
            1,
            "Jetpack Compose es la herramienta moderna de UI para Android."
        ),
        Question(
            "¿Cuál de los siguientes no es un componente del ciclo de vida en Android?",
            listOf("onCreate", "onDestroy", "onSubmit", "onResume"),
            2,
            "onSubmit no es parte del ciclo de vida de un Activity en Android."
        ),
        Question(
            "¿Qué es una 'Activity' en Android?",
            listOf("Una clase de base de datos", "Una pantalla o interfaz", "Un servicio en segundo plano", "Una API"),
            1,
            "Una Activity representa una pantalla con la que el usuario puede interactuar."
        ),
        Question(
            "¿Qué plataforma permite desarrollo móvil multiplataforma?",
            listOf("React Native", "Swift", "Kotlin", "Xcode"),
            0,
            "React Native permite desarrollar apps móviles para Android e iOS con un solo código base."
        ),
        Question(
            "¿Qué función cumple un ViewModel en MVVM?",
            listOf("Gestiona la UI", "Conecta la vista con el modelo", "Maneja la navegación", "Renderiza componentes"),
            1,
            "El ViewModel actúa como intermediario entre la vista y el modelo de datos."
        ),
        Question(
            "¿Cuál de estas tecnologías es usada en Flutter?",
            listOf("Java", "Dart", "Swift", "Kotlin"),
            1,
            "Flutter utiliza el lenguaje Dart para el desarrollo de aplicaciones."
        ),
        Question(
            "¿Qué es una 'ConstraintLayout' en Android?",
            listOf("Un tipo de base de datos", "Una herramienta de navegación", "Un sistema de diseño flexible", "Una API de red"),
            2,
            "ConstraintLayout permite crear interfaces complejas con reglas de posicionamiento."
        ),
        Question(
            "¿Cuál es el propósito del archivo AndroidManifest.xml?",
            listOf("Definir estilos", "Configurar dependencias", "Declarar componentes y permisos", "Diseñar layouts"),
            2,
            "El AndroidManifest.xml define actividades, servicios y permisos de la app."
        ),
        Question(
            "¿Qué librería facilita el enlace de datos en Android?",
            listOf("Retrofit", "Room", "LiveData", "Data Binding"),
            3,
            "Data Binding permite conectar la lógica con la interfaz directamente."
        ),
        Question(
            "¿Cuál es la principal ventaja del uso de LiveData?",
            listOf("Persistencia", "Actualización automática de UI", "Reducción de código", "Mayor rendimiento"),
            1,
            "LiveData permite que la UI observe datos y se actualice automáticamente."
        ),
        Question(
            "¿Qué herramienta permite la depuración de una app Android?",
            listOf("ADB", "Gradle", "ProGuard", "Lint"),
            0,
            "ADB (Android Debug Bridge) permite interactuar y depurar aplicaciones en dispositivos Android."
        ),
        Question(
            "¿Qué es un 'Fragment' en Android?",
            listOf("Un tipo de base de datos", "Una clase para manejar permisos", "Una porción reutilizable de UI", "Un archivo de configuración"),
            2,
            "Un Fragment representa una parte de la interfaz de usuario o comportamiento de una Activity."
        ),
        Question(
            "¿Qué archivo contiene la configuración de dependencias en un proyecto Android?",
            listOf("AndroidManifest.xml", "build.gradle", "MainActivity.kt", "res/values"),
            1,
            "El archivo build.gradle define las dependencias y configuraciones del proyecto."
        ),
        Question(
            "¿Qué es Room en Android?",
            listOf("Una librería de UI", "Una base de datos local", "Una herramienta de depuración", "Un framework de red"),
            1,
            "Room es una librería que facilita el acceso a bases de datos SQLite."
        ),
        Question(
            "¿Qué significa APK?",
            listOf("Android Package", "Android Programming Kit", "Application Key", "App Kernel"),
            0,
            "APK significa Android Package y es el archivo que contiene todos los elementos de una app Android."
        ),
        Question(
            "¿Qué componente permite ejecutar tareas en segundo plano en Android?",
            listOf("Activity", "BroadcastReceiver", "Service", "Layout"),
            2,
            "Un Service es un componente que permite ejecutar operaciones en segundo plano sin una interfaz de usuario."
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_view)

        tvQuestion = findViewById(R.id.tvQuestion)
        buttons = listOf(
            findViewById(R.id.btnOptionA),
            findViewById(R.id.btnOptionB),
            findViewById(R.id.btnOptionC),
            findViewById(R.id.btnOptionD)
        )

        showQuestion()

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener { checkAnswer(index) }
        }
    }

    private fun showQuestion() {
        val q = questions[currentQuestionIndex]
        tvQuestion.text = q.text
        buttons.forEachIndexed { index, button ->
            button.text = q.options[index]
        }
    }

    private fun checkAnswer(selectedIndex: Int) {
        val question = questions[currentQuestionIndex]

        val isCorrect = selectedIndex == question.correctAnswerIndex
        if (isCorrect) score++

        val alertDialog = AlertDialog.Builder(this)
            .setTitle(if (isCorrect) "¡Correcto!" else "Incorrecto")
            .setMessage(question.explanation)
            .setCancelable(false)
            .setPositiveButton(
                if (currentQuestionIndex == questions.size - 1) "Ver resultados"
                else if (isCorrect) "Siguiente pregunta"
                else "Intentar de nuevo"
            ) { dialog, _ ->
                dialog.dismiss()
                if (isCorrect) {
                    currentQuestionIndex++
                    if (currentQuestionIndex < questions.size) {
                        showQuestion()
                    } else {
                        showResults()
                    }
                }
            }

        alertDialog.show()
    }

    private fun showResults() {
        val intent = Intent(this, ResultsView::class.java)
        intent.putExtra("score", score)
        intent.putExtra("total", questions.size)
        startActivity(intent)
        finish()
    }
}
