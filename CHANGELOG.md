# 📜 CHANGELOG

Todas las modificaciones importantes de este proyecto se documentarán en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es/1.0.0/)
y este proyecto sigue el versionado [SemVer](https://semver.org/lang/es/).
---
## [1.4.1] - 2025-05-28

### ✨ Añadido
- Métodos específicos para editar entradas:
  - `editarApunteLibro`
  - `editarReflexion`
  - `editarFrase`
  - `editarApunteEstudio`
- Integración completa del sistema de edición en `editarEntrada(...)`.
- Posibilidad de conservar valores actuales pulsando ENTER.
- Mensajes de confirmación por consola tras cada edición.
- Validación de tipo usando `instanceof`.

### ✅ Mejorado
- Evitado uso erróneo de `ArrayList.get(id)` al buscar por identificador único.
- Refactor del flujo de selección para hacer la edición más robusta y modular.

### ⏱️ Duración estimada: 90 minutos

--- 
## [1.4.0] - 2025-05-26
### Añadido
- Método `convertirStringALocalDateBuscarPorFechas(String fecha)` mejorado para normalizar fechas con ceros en día, mes y año.
- Validación de fechas vacías y nulas.
- Mensajes de error más claros al introducir fechas inválidas.

### Cambiado
- Se reemplazó estructura `if` por `switch` en la opción de ingreso de fecha para mejorar la legibilidad.
- Se mejoró la gestión de excepciones al introducir opciones de menú (uso de `try-catch` para `InputMismatchException`).
- Se evita `NullPointerException` al validar fechas antes de compararlas.

### Comentario
Estas mejoras refuerzan la robustez del sistema, aportan claridad al usuario y evitan errores en el flujo de fechas.

---
## [1.3.5] - 2025-05-16

### ✨ Añadido
- Implementada búsqueda avanzada por rango de fechas en el diario.
- Creada la clase `MenuBusquedas` para centralizar las diferentes opciones de búsqueda (por fecha concreta y por rango de fechas).
- Mejorada la validación y conversión de fechas (`GestionFechas`), tolerando fechas con y sin ceros iniciales.

### 🛠️ Mejorado
- Ahora el menú de búsquedas es a prueba de errores de entrada y orientado a ampliaciones.
- Mejoras menores en la interacción del usuario y mensajes informativos.
---
## [1.3.4] - 2025-05-16

### ✨ Añadido
- Opción de eliminar todas las entradas de un tipo concreto desde `MenuBorrados`.
- Nueva opción para borrar TODO el diario, incluyendo los archivos exportados (`diario.txt`, `diario.csv`) y reiniciar el contador (`id.txt`).
- Validación robusta del menú de borrados: control de errores en entrada de usuario y tipo.
- Refuerzo de mensajes y confirmaciones de seguridad antes de cualquier borrado masivo.

### 🛠️ Mejorado
- El menú de borrados ahora es a prueba de errores: impide introducir texto en opciones numéricas y no se bloquea si el usuario comete errores de entrada.
- El contador de IDs (`id.txt`) se reinicia a 0 cuando se borra todo el diario.

### 🧹 Limpiado
- Documentación sincronizada en README, TODO, RESUMEN y progreso.

---
## [1.3.3] - 2025-05-14

### ✨ Añadido
- Submenú de eliminación en `MenuBorrados`:
  - Eliminar por tipo: `frase`, `libro`, `reflexion`, `apunte`
  - Validación del ID antes de eliminar (solo elimina si coincide tipo e ID)
- Actualización de `ApunteLibro.java` con campos completos y método `getTipoEntrada()`
- Añadido soporte en `MenuBorrados` para opción 5: Apuntes de clase (`apunte`)

### 🛠️ Corregido
- Se evita borrar entradas de tipo incorrecto aunque el ID coincida.
- Se estandariza el nombre del fichero en todos los métodos (`diario.dat`)

## [1.3.2] - 2025-05-14

### ✨ Añadido
- Funcionalidad para **eliminar entrada por ID** desde un submenú interactivo.
- Creación de clase `MenuBorrados` con opciones para eliminar entradas por tipo (próximamente).

### ✅ Completado
- Método `eliminarEntradaPorId(int id, ArrayList<NuevaEntrada>)` en `GestorEntradas`.
- Nuevo método `escribirFichero(List)` para sobrescribir el binario tras eliminar.


## [1.3.1] - 2025-05-12

### ✨ Añadido
- Nuevo tipo de entrada: **ApunteLibro**
    - Campos: título del libro, autor, tipo de apunte, número de página, texto del apunte.
    - Soporte completo para exportación (`toCSV`) y visualización (`toString`).
- Menú para introducir apuntes de libros, con validación y sugerencias de tipos de apunte.

### ✅ Completado
- Método `crearApunteLibro(Scanner)` para introducir la entrada de forma guiada.
- Inclusión del nuevo tipo en `getTipoEntrada()` para búsquedas y exportaciones.


## [1.3.0] - 2025-05-12

### ✨ Añadido
- Menú interactivo para seleccionar el tipo de entrada: Diario, Reflexión, Apunte, Frase célebre.
- Integración inicial de subclases `FraseCelebre`, `ReflexionPersonal`, `ApunteEstudio`.

### 🛠️ Corregido
- Solucionado el bug que permitía guardar entradas vacías por error de Scanner o flujo mal gestionado.

### 📤 Exportación
- `toString()` y `toCSV()` de cada subclase exportan correctamente sus datos al pasar de binario a texto o CSV.

## [1.2.2] - 2025-05-08
### 🔒 Corregido
- Se añadió `serialVersionUID` a las clases serializables (`NuevaEntrada`, `FraseCelebre`, `ReflexionPersonal`, `ApunteEstudio`) para evitar errores al leer el fichero binario.

### 🗓️ Mejorado
- Se actualizó el formateador de fechas para aceptar fechas con y sin ceros (ej. `2-2-2025` y `02-02-2025`).
- Ahora la búsqueda por fecha acepta formatos más flexibles.


## [1.2.1] - 2025-05-07
### Añadido
- Nuevos tipos de entrada: FraseCelebre, ReflexionPersonal, ApunteEstudio.
- Método getTipoEntrada() en todas las clases.
- Exportación CSV y toString actualizados con tipo de entrada.


## [1.2.0] - 2025-05-06

### ✨ Añadido
- Búsqueda por palabra clave y por fecha desde el menú de consola.
- Métodos `filtrarPorPalabra()` y `filtrarPorFecha()` reutilizables para pruebas.
- Separación entre fichero real (`diario.dat`) y de pruebas (`diario.test.dat`).
- Validación de entradas numéricas con `scanner.hasNextInt()`.
- Paso de `Scanner` compartido entre métodos para evitar errores de entrada.

### 🧪 Pruebas
- Nuevos tests en `GestionFicherosBinTest` para filtrar por palabra y fecha.
- Uso de `@BeforeEach` y `@AfterEach` para preparar datos controlados.


## [1.1.0] - 2025-05-05

### ✨ Añadido
- Exportación al formato CSV (`diario.csv`) desde el fichero binario (`diario.dat`) usando el nuevo método `toCSV()` en la clase `NuevaEntrada`.
- Cabecera incluida en el CSV: `ID;Fecha;Nota`.
- Separador `;` usado para compatibilidad con Excel (configuración regional en español).
- Soporte de salto de línea por entrada y formato de texto escapado cuando sea necesario.
- Borrado del archivo CSV al tiempo del TXT
- 
### 🧹 Cambiado
- El método `pasarDeBinarioATexto()` ahora también genera un fichero `diario.csv` además del `diario.txt`.
- El método `borrarArchivoTexto` ahora también elimina el archivo CSV.
---

## [1.0.0] - 2025-05-05

### ✨ Añadido
- Método `pasarDeBinarioATexto()` en `GestionFicherosBin` para exportar el contenido del fichero binario (`diario.dat`) a un archivo de texto (`diario.txt`) usando el `toString()` de `NuevaEntrada`.
- Opción en el menú principal para ejecutar la exportación a texto.
- Método `leerFicheroTexto()` en `GestionFicheros` para visualizar el archivo `diario.txt` si existe.
- Método `borrarArchivoTexto()` para eliminar el archivo de texto manualmente y confirmar la acción.
- Primer test unitario con JUnit Jupiter: `testPasarDeBinarioATexto()` que comprueba la existencia del archivo `.txt`.

### 🧹 Cambiado
- Se ha comentado todo el código relacionado con la escritura y lectura directa de archivos de texto como método principal de almacenamiento. Ahora el sistema solo guarda en binario.

---
