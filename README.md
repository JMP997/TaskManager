# TaskManager

Aplicación web desarrollada con **Spring Boot** para la gestión personal de proyectos y tareas.  
Este proyecto sigue una arquitectura **limpia y modular**, basada en capas (`entity`, `repository`, `service`, `controller`), y está diseñado inicialmente como **aplicación single-user** (sin autenticación ni gestión de usuarios).

---

## Objetivo

TaskManager permite crear proyectos y asignarles tareas de manera sencilla, ofreciendo un entorno de desarrollo base sobre el que posteriormente se pueden añadir características más avanzadas como:
- Multiusuario con autenticación (Spring Security / JWT)
- Paginación, filtros y búsqueda avanzada
- Persistencia en MySQL o PostgreSQL
- Documentación de API con Swagger / OpenAPI

---

## Tecnologías principales

| Tipo | Tecnología |
|------|-------------|
| Backend | **Spring Boot 3.4.2** |
| Lenguaje | **Java 21** |
| Dependencias clave | Spring Web, Spring Data JPA, Lombok |
| Base de datos inicial | **H2 Database** (en memoria) |
| Build system | **Maven** |

---

## Estructura del proyecto

```
src/
 └─ main/java/com/jmp/taskmanager/
     ├─ entity/          → Entidades JPA (`Proyecto`, `Tarea`)
     ├─ repository/      → Interfaces `JpaRepository`
     ├─ service/         → Lógica de negocio (interfaces + impl)
     ├─ controller/      → API REST
     ├─ dto/             → (Opcional) DTOs para validación
     └─ exception/       → Manejo global de errores
```

---

## Configuración rápida

### `application.properties`
```properties
spring.datasource.url=jdbc:h2:mem:taskdb;DB_CLOSE_DELAY=-1;MODE=MySQL
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

Una vez ejecutado, la consola H2 estará disponible en:
```
http://localhost:8080/h2-console
```
*(JDBC URL: `jdbc:h2:mem:taskdb`)*

---

## API REST prevista

### Proyectos
| Método | Endpoint | Descripción |
|--------|-----------|--------------|
| GET | `/api/proyectos` | Lista todos los proyectos |
| GET | `/api/proyectos/{id}` | Obtiene un proyecto por ID |
| POST | `/api/proyectos` | Crea un nuevo proyecto |
| PUT | `/api/proyectos/{id}` | Actualiza un proyecto |
| DELETE | `/api/proyectos/{id}` | Elimina un proyecto |

### Tareas
| Método | Endpoint | Descripción |
|--------|-----------|--------------|
| GET | `/api/proyectos/{proyectoId}/tareas` | Lista tareas de un proyecto |
| GET | `/api/proyectos/{proyectoId}/tareas/{tareaId}` | Obtiene una tarea específica |
| POST | `/api/proyectos/{proyectoId}/tareas` | Crea una tarea en un proyecto |
| PUT | `/api/proyectos/{proyectoId}/tareas/{tareaId}` | Actualiza una tarea |
| DELETE | `/api/proyectos/{proyectoId}/tareas/{tareaId}` | Elimina una tarea |

---

## Roadmap del desarrollo

| Fase | Descripción |
|------|--------------|
| **Fase 1** | Configuración del proyecto y dependencias |
| **Fase 2** | Creación del modelo de datos (`Proyecto`, `Tarea`) |
| **Fase 3** | Implementación de repositorios JPA |
| **Fase 4** | Servicios y lógica de negocio |
| **Fase 5** | Controladores REST |
| **Fase 6** | DTOs y validación |
| **Fase 7** | Manejo global de errores |
| **Fase 8** | Mejoras: filtros, paginación, documentación |
| **Fase 9** | Seguridad y multiusuario (futuro) |

---

## Concepto clave

**Un único usuario, múltiples proyectos, múltiples tareas.**

No hay autenticación ni gestión de usuarios en esta primera versión: todo lo que se crea pertenece al mismo propietario.  
Esto simplifica la estructura inicial y facilita la expansión posterior.

---


## Autor

**Jesús Martín Pineda**  
Desarrollador web & data enthusiast  
[LinkedIn](https://www.linkedin.com/in/jesus-martin-pineda) · [GitHub](https://github.com/jesusmpineda)
