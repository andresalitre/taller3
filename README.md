# Taller 3 — Sistema de Magos y Hechizos

## Descripción

Este proyecto consiste en un sistema de gestión de magos y hechizos desarrollado en Java. La aplicación permite administrar un conjunto de magos y hechizos cargados desde archivos de texto, ofreciendo dos roles de usuario: un **Administrador** que puede crear, modificar y eliminar magos y hechizos, y un **Analista** que puede consultar rankings y estadísticas del sistema.

Los hechizos se dividen en cuatro tipos — Fuego, Agua, Planta y Tierra — cada uno con atributos propios además del daño base. El puntaje de un mago se calcula como la suma del daño de todos sus hechizos. Los datos se almacenan en archivos de texto (`Hechizos.txt` y `Magos.txt`) y se cargan en memoria al iniciar el sistema, persistiendo los cambios al guardar.

---

## Autores

> Andrés Rojas | RUT: 22.065.446-k | andresalitre
>
> Jorge Callejas | RUT: 21.926.182-9 | Satoolio

---

## Estructura del Proyecto

```
Taller3/
├── src/
│   └── Taller3/
│       ├── Main.java
│       ├── Sistema.java
│       ├── Administrador.java
│       ├── Analista.java
│       ├── Mago.java
│       ├── Hechizo.java
│       ├── Fuego.java
│       ├── Agua.java
│       ├── Planta.java
│       ├── Tierra.java
│       ├── LectorArchivos.java
│       └── EscritorArchivos.java
├── Hechizos.txt
├── Magos.txt
├── DiagramaDeClases.pdf
├── ModeloDeDominio.pdf
└── README.md
```

---

## Archivos de Datos

### `Hechizos.txt`
Contiene todos los hechizos disponibles en el sistema.
```
nombre;tipo;daño;atributos
```
El campo `atributos` varía según el tipo:
- **Fuego:** `quemadura`
- **Tierra:** `defensa`
- **Agua:** `heal,presion`
- **Planta:** `stun,plantas`

Ejemplo:
```
Escaldar;Agua;110;45,360
Lanzallamas;Fuego;38;5
Taladradora;Tierra;77;8
Polen Somnífero;Planta;81;3,10
```

### `Magos.txt`
Contiene los magos registrados en el sistema junto a sus hechizos.
```
nombre;Hechizo1|Hechizo2|...
```
Ejemplo:
```
Clapt;Pulso de Agua|Giro Fuego|Pedrada
MartinNegro;Acua Aro|Tumba Rocas|Polen Somnífero|Escaldar
```

---

## Instrucciones de Ejecución

1. Clonar el repositorio.
2. Asegurarse de que los archivos `Hechizos.txt` y `Magos.txt` estén en la raíz del proyecto (mismo nivel que `src/`).
3. Compilar y ejecutar `Main.java`.

> **Requiere Java 11 o superior.**

---

## Menús

### Menú Principal
```
1) Administrador
2) Analista
3) Cerrar menú
```

### Menú Administrador
```
1. Agregar Mago
2. Modificar Mago
3. Eliminar Mago
4. Agregar Hechizo
5. Modificar Hechizo
6. Eliminar Hechizo
7. Salir
```

### Menú Analista
```
1. Top 10 Mejores Hechizos
2. Top 3 Mejores Magos
3. Mostrar todos los Hechizos
4. Mostrar todos los Magos
5. Mostrar todos los Hechizos junto a su puntuacion
6. Mostrar todos los Magos junto a su puntuacion
7. Salir
```

---

## Mecánicas Principales

### Tipos de Hechizo

| Tipo   | Atributos extra          |
|--------|--------------------------|
| Fuego  | Duración de quemadura    |
| Agua   | Curación y presión       |
| Planta | Duración de stun y cantidad de plantas |
| Tierra | Mejora de defensa        |

### Puntaje
El puntaje de un mago se calcula como la **suma del daño** de todos sus hechizos. El puntaje de un hechizo es su **daño base**.

### Administrador
- Permite agregar magos asignándoles al menos un hechizo existente.
- Permite modificar el nombre de un mago, agregarle hechizos o quitárselos.
- Permite eliminar magos del sistema.
- Permite agregar hechizos de cualquier tipo con sus atributos correspondientes.
- Permite modificar nombre, daño y atributos propios de cada hechizo.
- Permite eliminar hechizos del sistema.
- Todos los cambios se persisten automáticamente en los archivos `.txt`.

### Analista
- Muestra el **Top 10** de hechizos ordenados por daño.
- Muestra el **Top 3** de magos ordenados por puntuación total.
- Lista todos los hechizos y magos del sistema, con o sin puntaje.

---

## Tecnologías y Librerías

- **Java** — lenguaje principal
- `Scanner` — lectura de archivos y entrada del usuario
- `BufferedWriter` — escritura y sobrescritura de archivos
- `ArrayList` — manejo de colecciones dinámicas
