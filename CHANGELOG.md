# 📜 CHANGELOG

Todas las modificaciones importantes de este proyecto se documentarán en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es/1.0.0/)
y este proyecto sigue el versionado [SemVer](https://semver.org/lang/es/).

---

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
