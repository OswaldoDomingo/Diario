# 📜 CHANGELOG

Todas las modificaciones importantes de este proyecto se documentarán en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es/1.0.0/)
y este proyecto sigue el versionado [SemVer](https://semver.org/lang/es/).

---

## [1.1.0] - 2025-05-05

### ✨ Añadido
- Exportación al formato CSV (`diario.csv`) desde el fichero binario (`diario.dat`) usando el nuevo método `toCSV()` en la clase `NuevaEntrada`.
- Cabecera incluida en el CSV: `ID;Fecha;Nota`.
- Separador `;` usado para compatibilidad con Excel (configuración regional en español).
- Soporte de salto de línea por entrada y formato de texto escapado cuando sea necesario.

### 🧹 Cambiado
- El método `pasarDeBinarioATexto()` ahora también genera un fichero `diario.csv` además del `diario.txt`.

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
