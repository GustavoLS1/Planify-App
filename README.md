📱 Planify
Planify es una aplicación de gestión financiera desarrollada en Android Studio con Jetpack Compose. Su objetivo es ayudar a los usuarios a administrar sus finanzas de manera intuitiva, permitiendo realizar seguimiento de ahorros, inversiones, pagos de recibos y metas.

🚀 Tecnologías Utilizadas
Lenguaje: Kotlin 2.0.0

Framework UI: Jetpack Compose (BOM 2024.04.01)

Gestión de imágenes: Landscapist (Glide, Coil, Fresco) 2.2.1

Material Design 3 para una interfaz moderna y accesible.

📦 Configuración del Proyecto
Requisitos previos
Android Studio Iguana | 2023.2.1 o superior

Kotlin 2.0.0

Compose BOM 2024.04.01

JDK 11

📂 Instalación
Clona el repositorio:

bash
Copiar
Editar
git clone https://github.com/tu-usuario/planify.git
Abre el proyecto en Android Studio.

Sincroniza las dependencias en gradle.build.kts.

Ejecuta el proyecto en un emulador o dispositivo físico.

🛠️ Dependencias principales

dependencies {

    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.github.skydoves:landscapist-glide:2.2.1")
    implementation("com.github.skydoves:landscapist-coil:2.2.1")
    implementation("com.github.skydoves:landscapist-fresco:2.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    
}
🎨 Diseño de la Aplicación
Planify utiliza Material 3 para brindar una experiencia de usuario fluida y moderna, asegurando accesibilidad y usabilidad en toda la aplicación.

📌 Características Clave
✔ Gestión de ahorros y gastos
✔ Registro y seguimiento de inversiones
✔ Configuración de metas financieras
✔ Notificaciones para recordatorios de pagos

📄 Licencia
Este proyecto está bajo la licencia MIT.
