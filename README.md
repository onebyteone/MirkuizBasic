# 📱 Mirkuiz - Quiz de Desarrollo Móvil

<div align="center">
  
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![API](https://img.shields.io/badge/API-21%2B-brightgreen?style=for-the-badge)

*Una aplicación de quiz interactiva sobre desarrollo móvil para Android*

</div>

---

## 🎯 Descripción

**Mirkuiz** es una aplicación educativa de preguntas y respuestas diseñada para poner a prueba tus conocimientos sobre desarrollo de aplicaciones móviles. Con un enfoque en Android, iOS, y tecnologías multiplataforma, esta app te ayudará a repasar conceptos fundamentales del desarrollo móvil.

### ✨ Características Principales

- 🧠 **20 preguntas** cuidadosamente seleccionadas sobre desarrollo móvil
- 📚 **Explicaciones detalladas** para cada respuesta
- 🎨 **Interfaz moderna** con Material Design
- 📊 **Sistema de puntuación** y resultados finales
- 🔄 **Navegación fluida** entre pantallas
- 📱 **Optimizada para Android** con Kotlin

---

## 🏗️ Arquitectura de la Aplicación

La aplicación sigue el patrón **MVC (Model-View-Controller)** y está estructurada en tres actividades principales:

```
📦 com.example.s04_flores
 ┣ 📄 MainActivity.kt          # Pantalla de inicio
 ┣ 📄 QuestionView.kt          # Lógica del quiz
 ┣ 📄 ResultsView.kt           # Pantalla de resultados
 ┗ 📁 res/
   ┗ 📁 layout/
     ┣ 📄 activity_main.xml
     ┣ 📄 activity_question_view.xml
     ┗ 📄 activity_results_view.xml
```

### 🎭 Componentes Principales

| Actividad | Descripción | Funcionalidades |
|-----------|-------------|-----------------|
| `MainActivity` | Pantalla de bienvenida | • Botón de inicio<br>• Navegación al quiz |
| `QuestionView` | Motor del quiz | • Gestión de preguntas<br>• Validación de respuestas<br>• Sistema de puntuación |
| `ResultsView` | Pantalla de resultados | • Mostrar puntuación final<br>• Resumen del rendimiento |

---

## 🎮 Funcionalidades del Quiz

### 📋 Temáticas Incluidas

- **🤖 Desarrollo Android**: Kotlin, Activities, Fragments, Lifecycle
- **🍎 Desarrollo iOS**: Swift, UIKit, Xcode
- **🌐 Multiplataforma**: React Native, Flutter, Dart
- **🏗️ Arquitectura**: MVC, MVVM, MVP
- **🛠️ Herramientas**: Android Studio, ADB, Gradle
- **📚 Librerías**: Room, LiveData, Jetpack Compose

### 🎯 Mecánica del Juego

1. **Inicio**: Presiona "EMPEZAR" en la pantalla principal
2. **Preguntas**: Responde 20 preguntas de opción múltiple
3. **Retroalimentación**: Recibe explicación inmediata de cada respuesta
4. **Progreso**: Solo avanzas con respuestas correctas
5. **Resultados**: Visualiza tu puntuación final

---

## 🚀 Instalación

### 📋 Requisitos Previos

- **Android Studio** Arctic Fox o superior
- **SDK de Android** API 21 (Android 5.0) o superior
- **Kotlin** 1.5 o superior
- **Gradle** 7.0 o superior

### 🛠️ Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/onebyteone/mirkuiz.git
   cd mirkuiz
   ```

2. **Abrir en Android Studio**
   - Abre Android Studio
   - Selecciona "Open an existing project"
   - Navega hasta la carpeta del proyecto

3. **Sincronizar dependencias**
   ```gradle
   // El proyecto se sincronizará automáticamente
   // Si no, usa: Tools > Sync Project with Gradle Files
   ```

4. **Ejecutar la aplicación**
   - Conecta un dispositivo Android o inicia un emulador
   - Presiona el botón "Run" (▶️) o usa `Shift + F10`

---

## 🧑‍💻 Desarrollo

### 🏗️ Estructura del Código

```kotlin
// Modelo de datos para las preguntas
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String
)

// Gestión del estado del quiz
class QuestionView : AppCompatActivity() {
    private var currentQuestionIndex = 0
    private var score = 0
    private val questions = listOf(/* 20 preguntas */)
}
```

### 🎯 Características Técnicas

- **Patrón de Diseño**: Activity-based navigation
- **UI Framework**: XML Layouts con CardView
- **Gestión de Estado**: Variables de instancia
- **Navegación**: Intent-based
- **Dialogs**: AlertDialog para feedback

---

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! Si quieres mejorar Mirkuiz:

1. **Fork** el proyecto
2. **Crea** una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. **Push** a la rama (`git push origin feature/AmazingFeature`)
5. **Abre** un Pull Request

### 💡 Ideas para Contribuir

- [ ] Agregar más preguntas al banco de datos
- [ ] Implementar diferentes niveles de dificultad
- [ ] Añadir modo de práctica sin puntuación
- [ ] Crear categorías temáticas específicas
- [ ] Mejorar la UI con animaciones
- [ ] Agregar sonidos y efectos

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

## 👨‍💻 Autor

**Flores Luera Miguel** - *Desarrollo inicial*

---
