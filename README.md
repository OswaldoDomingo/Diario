# 📔 Diario Personal en Java

Este proyecto es una aplicación de diario personal desarrollada en Java. Su objetivo principal es permitir registrar anotaciones personales de forma sencilla y persistente, utilizando archivos binarios para almacenar las entradas.

---

## ✅ Funcionalidades actuales

- ✍️ **Añadir entrada**: Permite crear nuevas notas personales con fecha y contenido.
- 📅 **Fecha automática o manual**: El usuario puede introducir la fecha manualmente o utilizar la actual.
- 💾 **Almacenamiento binario (`diario.dat`)**: Las entradas se guardan de forma segura mediante serialización de objetos.
- 🔁 **Lectura de entradas**: Se pueden visualizar todas las entradas almacenadas en el archivo binario.
- 📤 **Exportar a texto**: Conversión del archivo binario a un archivo de texto (`diario.txt`).
- 📊 **Exportar a CSV (`diario.csv`)**: Se genera un archivo CSV con separador `;` para fácil apertura en Excel o Google Sheets. Incluye cabecera y soporte para campos con texto largo.
- 📂 **Lectura y eliminación de los archivos TXT y CSV**: Visualización o borrado manual de los archivos exportados.
- 🧪 **Pruebas unitarias con JUnit**: Test de exportación implementado (`GestionFicherosBinTest`, `GestionFechasTest`).

---

## 📁 Estructura del proyecto

```
src/
├── diario/
│   ├── Main.java                  # Clase principal con menú interactivo
│   ├── NuevaEntrada.java          # Clase que representa una entrada de diario
│   ├── GestionFechas.java         # Métodos de gestión y validación de fechas
│   ├── GestionFicheros.java       # Herramientas para archivos de texto (secundarias)
│   └── GestionFicherosBin.java    # Lógica de lectura/escritura en binario
└── test/
    ├── GestionFicherosBinTest.java
    └── GestionFechasTest.java
```

---

## 🔮 Posibles funcionalidades futuras

Este proyecto se ha diseñado con posibilidad de ampliación. Algunas ideas para próximas versiones incluyen:

- 📚 **Apuntes de clase** organizados por módulos y temas.
- 📖 **Notas de lectura** de libros, con análisis o fragmentos destacados.
- 💬 **Frases célebres o reflexiones** personales.
- 🔍 **Búsqueda de entradas** por palabras clave, fechas o tipo.
- 🖼️ **Soporte para contenido enriquecido** (imágenes, enlaces).
- 🖥️ **Interfaz gráfica (GUI)** usando JavaFX o Swing.
- 🌐 **Versión web** con backend y base de datos.
- 🔐 **Autenticación de usuario** o cifrado de entradas.

---

## 🚀 Cómo ejecutar

1. Clona este repositorio:
   ```bash
   git clone https://github.com/OswaldoDomingo/Diario.git
   ```
2. Abre el proyecto en NetBeans o tu IDE preferido.
3. Ejecuta la clase `Main.java`.
4. Utiliza el menú interactivo para añadir o leer entradas.

---

## 🧪 Tests

Este proyecto incluye pruebas unitarias con JUnit Jupiter:

- Validación de fechas (`GestionFechasTest`)
- Comprobación de exportación a texto (`GestionFicherosBinTest`)

---

## 📦 Requisitos

- Java 17 o superior
- NetBeans, IntelliJ IDEA u otro IDE compatible

---

## 👤 Autor

**Oswaldo Domingo**  
GitHub: [OswaldoDomingo](https://github.com/OswaldoDomingo)

---

## 📝 Licencia

Este proyecto está bajo la licencia MIT.  
Consulta el archivo `LICENSE` si decides añadirlo en el futuro.

---

## 📌 Estado del proyecto

✅ En uso — desarrollo activo.  
🛠️ En evolución — nuevas funcionalidades en planificación.

