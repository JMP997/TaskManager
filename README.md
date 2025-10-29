# TaskManager

**TaskManager** es una aplicación web desarrollada con **Spring Boot** que permite gestionar proyectos y tareas de forma sencilla y organizada.  
El sistema sigue una arquitectura **RESTful** y un enfoque basado en capas (entidades, repositorios, servicios y controladores).

---

## Roadmap

1. ✅**Fase 1 – Configuración inicial**  
   Crear proyecto, configuración MySQL y comprobación de arranque.

2. ✅**Fase 2 – Modelo de datos**  
   Entidades `Proyecto` y `Tarea` con relación 1:N.

3. 🚧**Fase 3 – Repositorios**  
   Interfaces `JpaRepository` y consultas personalizadas.

4. 🚧**Fase 4 – Servicios**  
   Implementar lógica de negocio con transacciones.

5. 🚧**Fase 5 – API REST**  
   Controladores con endpoints CRUD.

6. 🚧**Fase 6 – DTOs y validación**

7. 🚧**Fase 7 – Manejo global de errores**

8. 🚧**Fase 8 – Filtros y utilidades**

9. 🚧**Fase 9 – Documentación y tests**

10. 🚧**Fase 10 – Seguridad y multiusuario (futuro)**

---

## Características principales

- Creación y gestión de **proyectos**.
- CRUD completo de **tareas** asociadas a cada proyecto.
- Filtros por estado, prioridad y fecha límite.
- Validación de datos y manejo global de errores.
- Documentación automática con **Swagger / OpenAPI**.
- Preparada para futura integración de **usuarios y seguridad (JWT)**.

---

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.x**
    - Spring Web
    - Spring Data JPA
    - Spring Validation
- **Lombok**
- **MySQL** / **H2 (en memoria para pruebas)**
- **Maven**
- **Swagger (springdoc-openapi)**

---

## Estructura del proyecto

```
src/
 └── main/
     ├── java/com/taskmanager/
     │   ├── controller/     → Controladores REST
     │   ├── dto/            → Objetos de transferencia (DTOs)
     │   ├── entity/         → Entidades JPA
     │   ├── exception/      → Gestión global de errores
     │   ├── repository/     → Interfaces JpaRepository
     │   ├── service/        → Lógica de negocio
     │   └── TaskManagerApplication.java
     └── resources/
         ├── application.properties
         └── static / templates (si aplica)
```

---

## Configuración de la base de datos

Por defecto, el proyecto utiliza **MySQL**.  
Puedes cambiar fácilmente a H2 en memoria para desarrollo rápido.

### 🔹 MySQL

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager_db?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 🔹 H2 (opcional)

```properties
spring.datasource.url=jdbc:h2:mem:taskdb;DB_CLOSE_DELAY=-1;MODE=MySQL
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

---

## Ejecución del proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/TaskManager.git
   cd TaskManager
   ```
2. Compila y ejecuta:
   ```bash
   mvn spring-boot:run
   ```
   o bien:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Accede a la aplicación:
    - API base: [http://localhost:8080](http://localhost:8080)
    - Consola H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Endpoints principales

| Método | Endpoint | Descripción |
|--------|-----------|--------------|
| **GET** | `/api/proyectos` | Listar todos los proyectos |
| **POST** | `/api/proyectos` | Crear nuevo proyecto |
| **GET** | `/api/proyectos/{id}` | Obtener proyecto por ID |
| **PUT** | `/api/proyectos/{id}` | Actualizar proyecto |
| **DELETE** | `/api/proyectos/{id}` | Eliminar proyecto |
| **GET** | `/api/proyectos/{proyectoId}/tareas` | Listar tareas de un proyecto |
| **POST** | `/api/proyectos/{proyectoId}/tareas` | Crear tarea dentro de un proyecto |
| **PUT** | `/api/proyectos/{proyectoId}/tareas/{id}` | Actualizar tarea |
| **DELETE** | `/api/proyectos/{proyectoId}/tareas/{id}` | Eliminar tarea |

---

## Validación y manejo de errores

- Validaciones con anotaciones como `@NotBlank`, `@Size`, `@NotNull`.
- Excepciones personalizadas:
    - `ResourceNotFoundException`
    - `BadRequestException`
- Manejadas globalmente con `@ControllerAdvice`.

---

## Autor

Desarrollado por **Jesús Martín Pineda**  
    Granada, España  
    Proyecto educativo y personal didáctico **Spring Boot**, **JPA** y **arquitectura RESTful**.

---

## Licencia

Este proyecto se distribuye bajo la licencia **MIT**. Puedes usarlo, modificarlo y compartirlo libremente.
