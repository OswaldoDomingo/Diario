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
- 🔍 **Búsqueda de entradas por palabra clave y fecha**: Desde el menú se puede buscar fácilmente contenido específico.
- 🧼 **Validación de entradas**: Control de errores de entrada para evitar fallos con datos incorrectos.
- 🗓️ **Formato de fecha flexible**: Se pueden introducir fechas con o sin ceros (ej. `2-2-2025` o `02-02-2025`).
- 🔒 **Compatibilidad binaria estable**: Uso de `serialVersionUID` en clases serializables para evitar errores al leer el archivo binario.
- ✍️ **Añadir entrada**: Permite crear nuevas notas personales con fecha y contenido.
- ✍️ **Añadir entrada**: Permite crear nuevas notas personales, frases célebres, reflexiones o apuntes de estudio.
- ✍️ **Añadir entrada**: Permite crear nuevas notas personales, frases célebres, reflexiones o apuntes de estudio.
- ✍️ **Añadir entrada**: Permite crear notas personales, reflexiones, frases célebres, apuntes de estudio o apuntes de libros.
- 🗑️ **Eliminar entrada por ID:** Permite eliminar una entrada específica indicando su número de identificación.
- 🗑️ **Eliminación avanzada desde menú:** permite eliminar por ID o por tipo de entrada (frases, reflexiones, apuntes...).
- 🗑️ **Añadir la opción de borrado completo:** el diario y los archivos exportados (txt, csv, y reinicio de contador de IDs).
-    **Mejora** de seguridad y validación en el menú de borrado.
- 🔎 **Búsqueda avanzada por fechas**: Ahora se puede buscar por fecha concreta o por rango de fechas desde un menú dedicado. Permite encontrar todas las entradas comprendidas entre dos fechas, ambos extremos incluidos.
- 📋 **Nuevo menú de búsquedas**: Menú específico donde se agrupan las búsquedas por fecha concreta y por rango, preparado para futuras ampliaciones (tipo, materia, etc).
- 🛠️ **Validación de fechas mejorada**:
   - Normalización automática del formato `dd-MM-yyyy` aunque se introduzcan valores incompletos.
   - Mensajes de error consistentes si el formato es incorrecto o la fecha es nula.
   - Evita errores de comparación (por ejemplo, con `isBefore()`).
- 🔁 **Lectura de entradas**.
- 💾 **Almacenamiento binario (`diario.dat`)**: Serialización de objetos.
- 📤 **Exportar** a `.txt` y `.csv` (con separador `;` para Excel).
- 🧹 **Borrado individual o por tipo de entrada**.

---

## 📁 Estructura del proyecto

```
.
├── docs/
│   └── progreso.md                  # Registro diario de tiempo e hitos
├── lib/                             # Dependencias externas para testing
│   ├── apiguardian-api-1.1.2.jar
│   ├── junit-jupiter-*.jar
│   ├── junit-platform-*.jar
│   └── opentest4j-1.3.0.jar
├── out/
│   └── production/
│       └── Diario/
│           ├── diario/              # Clases compiladas de producción
│           └── test/                # Clases compiladas de test
├── src/
│   ├── diario/
│   │   ├── Main.java
│   │   ├── NuevaEntrada.java
│   │   ├── FraseCelebre.java
│   │   ├── ReflexionPersonal.java
│   │   ├── ApunteEstudio.java
│   │   ├── ApunteLibro.java
│   │   ├── GestionFechas.java
│   │   ├── GestionFicheros.java
│   │   ├── GestionFicherosBin.java
│   │   ├── GestorEntradas.java
│   │   └── MenuBorrados.java
│   └── test/
│       ├── GestionFicherosBinTest.java
│       └── GestionFechasTest.java
├── CHANGELOG.md                    # Historial de cambios
├── diario.dat / diario.txt / diario.csv   # Archivos de datos (binario, texto y CSV)
├── id.txt                          # Control incremental de ID
├── Diario.iml                      # Archivo del proyecto IntelliJ
├── LICENSE.md                      # Documentación general
├── README.md                       # Documentación general

```


---

## 🗂️ Tipos de entradas
- Entrada general
- Frase célebre
- Reflexión personal
- Apunte de estudio
- Diario personal
- Apunte de libro (con autor, tipo de apunte y página)


---
## 🔮 Posibles funcionalidades futuras

Este proyecto se ha diseñado con posibilidad de ampliación. Algunas ideas para próximas versiones incluyen:

- 🗑️ Eliminación avanzada: Borrado masivo por tipo de entrada (frases, reflexiones, apuntes...).
- ✏️ Edición de entradas: Modificar contenido ya registrado.
- 🔍 Búsquedas avanzadas: Por tipo de entrada, materia, tema, subtema o rango de fechas.
- 📚 Gestión de apuntes de clase: Organización por módulos, temas y subtemas.
- 📖 Notas de lectura: Registro de fragmentos destacados o comentarios por libro y página.
- 💬 Frases célebres y reflexiones: Clasificación y reutilización como inspiración diaria.
- 🖼️ Contenido enriquecido: Posibilidad de incluir imágenes, enlaces o archivos adjuntos.
- 🖥️ Interfaz gráfica (GUI): Implementación con JavaFX para facilitar la interacción.
- 🌐 Versión web: Desarrollo de una interfaz web con base de datos y autenticación.
- 🔐 Cifrado y privacidad: Encriptación de entradas o control de acceso por usuario.
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
- Comprobación de tipo de entrada y exportación (`EntradaTest`)


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

