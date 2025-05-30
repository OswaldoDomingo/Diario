# 🕓 Registro de Tiempo y Hitos - Proyecto Java Diario

#### Este documento recoge el seguimiento diario del desarrollo del proyecto **Java Diario**, incluyendo las horas dedicadas y los avances alcanzados en cada sesión.
---

# 🗓️ Progreso del proyecto - Diario en Java

## 🧪 Día: 28/05/2025
**Duración**: 90 minutos

### ✅ Tareas realizadas:
- Se ha corregido el error crítico `IndexOutOfBoundsException` al buscar entradas por ID.
- Se ha implementado correctamente el método `editarEntrada(ArrayList, id)` con control de tipo dinámico.
- Se han creado los métodos individuales de edición:
  - ApunteLibro: edición completa de campos relevantes.
  - ReflexionPersonal: edición de fecha y nota.
  - FraseCelebre: edición de fecha, nota y autor.
  - ApunteEstudio: edición de fecha, materia, tema, subtema y nota.
- Validación de entrada de usuario.
- Confirmación visual del resultado tras cada edición.
- Planificación para evitar modificar el tipo de entrada ni el ID.

### 🛠️ Pendiente:
- Revisión de Scanner compartido para evitar múltiples instancias.
- Mejoras de validación para la fecha.


---
### 🗓️ 26 de mayo de 2025 - Jornada completada

#### 🛠️ Mejoras implementadas:
- Normalización automática de fechas en método `convertirStringALocalDateBuscarPorFechas`.
- Control de errores si se introduce una fecha en formato incorrecto.
- Validación de fechas nulas antes de realizar comparaciones.
- Sustitución de `if` por `switch` en `pedirFecha` para hacer el código más legible.
- Manejo de errores más claro para opciones no válidas.
- Mejora en la robustez general del flujo de fechas.

#### ⏱️ Tiempo estimado invertido:
- 1h (aprox.)

#### 🧩 Próximos pasos:
- Preparar test unitarios para fechas.
- Posible internacionalización de los mensajes.
- Exportación y búsqueda avanzada por rango de fechas.

---
## 📅 2025-05-19

### 🕑 Horario del día
- **9:00 – 9:40**
- **10:05 – 10:30**
- **12:25 – 12:55**
- **16:20 – 17:45**
- 
### ⏱️ Tiempo total dedicado: **~3h 35min**

---

### ✅ Hitos alcanzados

- Implementada búsqueda avanzada por rango de fechas.
- Añadida clase `MenuBusquedas` con menú para búsqueda por fecha concreta y rango de fechas.
- Mejoradas comprobaciones y conversión de fechas en `GestionFechas`.
- Probadas búsquedas con diferentes escenarios y validaciones.
- Actualizados README, CHANGELOG, TODO y progreso.

---

### 🔜 Próximo objetivo

- Añadir búsquedas avanzadas por tipo, materia y subtema.
- Evaluar nuevas opciones de exportación o borrado por rango de fechas.

---

> **Comentario:**  
> Día caótico, pero productivo. La mañana fue menos eficiente por interrupciones, pero la tarde ha sido muy productiva con el avance clave en búsquedas por fechas.



--- 
## 📅 2025-05-16

### 🕒 Horario: 10:45 - 12:00

### ⏱️ Tiempo invertido: 1h 15min

✅ Hitos alcanzados:
- Implementada eliminación masiva de entradas por tipo en MenuBorrados.
- Añadida opción para borrar TODO el diario (diario.dat), los archivos exportados (diario.txt, diario.csv), y reiniciar el contador (id.txt).
- Refuerzo de validaciones en menú de borrados: menú a prueba de fallos de entrada.
- README, CHANGELOG, TODO, RESUMEN y progreso actualizados y sincronizados.
- Preparado commit, push, tag y release en GitHub.

🔜 Próximo objetivo:
- Avanzar con búsquedas avanzadas (por materia, tema, subtema, tipo, rango de fechas).
- Valorar integración de base de datos y edición de entradas.

---
## 📅 2025-05-14

### 🕒 Horario: 08:30 - 09:30

### ⏱️ Tiempo invertido: 1h

✅ Hitos alcanzados:
- - Añadido método borrarEntradaPorTipoYId() reutilizable en MenuBorrados.
- - Borrado funcional por tipo: frase, libro, reflexion, apunte.
- - Validación del tipo e ID antes de eliminar.
- - Modificado MenuBorrados con submenú completo.
- - Confirmada persistencia de cambios en diario.dat.
- - Archivos actualizados: MenuBorrados.java, ApunteLibro.java, GestorEntradas.java, README.md, TODO.md, CHANGELOG.md.
- - Preparado commit, push, y tag v1.3.3 para GitHub.
- 🔜 Próximo objetivo:
- - Implementar eliminación masiva por tipo.
- - Añadir edición de entradas.

## 📅 2025-05-14

### 🕒 Horario: 09:30
### ⏱️ Tiempo invertido: 2h
- ✅ Hitos alcanzados:
  - Creada clase `MenuBorrados` para gestionar eliminaciones.
  - Implementado método `eliminarEntradaPorId()`.
  - Reescritura del fichero binario tras eliminar entrada.
  - Pruebas realizadas: eliminación funcional confirmada.
- 🔜 Próximo objetivo:
  - Añadir eliminación por tipo de entrada (frase, reflexión...).
---

## 📅 2025-05-13

- 🕒 Horario: 19:30 - 20:45  
- ⏱️ Tiempo invertido: 1h 15min  
- ✅ Hitos alcanzados:
  - Implementado el nuevo tipo de entrada `ApunteLibro`.
  - Añadido método `toCSV()` en `ApunteLibro` para exportación CSV.
  - Actualizados `README.md` y `CHANGELOG.md`.
  - Creado tag en GitHub: `v1.3.1`.

---

## 📅 2025-05-14

- 🕒 Horario: 
- ⏱️ Tiempo invertido: 
- ✅ Hitos alcanzados:
  - 
- 🔜 Próximo objetivo:
  - 
