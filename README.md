# Fase 1 – Preparación y configuración

1. Crear proyecto nuevo con Spring Boot (Web, JPA, Lombok).
2. Elegir BD de arranque:
    - **MySQL** (si ya lo tienes a mano).
3. `application.properties`:
    - MySQL:

        ```
        spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager_db?createDatabaseIfNotExist=true&serverTimezone=UTC
        spring.datasource.username=root
        spring.datasource.password=tu_password
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.format_sql=true
        
        ```

4. Arrancar la app y comprobar que levanta.

## Fase 2 – Modelo de datos (Entidades + Relaciones)

1. Paquete `entity`.
2. Entidades mínimas:
    - `Proyecto` (id, nombre único, descripción, timestamps).
    - `Tarea` (id, título, descripción, estado[PENDING/IN_PROGRESS/DONE], prioridad[LOW/MEDIUM/HIGH], fechaLimite, timestamps).
3. Relaciones:
    - `Proyecto` ↔ `Tarea` (**1:N**).
4. Semilla opcional con un `CommandLineRunner` que cree un **Proyecto “Personal”** si no existe.

## Fase 3 – Repositorios (Acceso a datos)

1. Paquete `repository`.
2. `ProyectoRepository` y `TareaRepository` (interfaces `JpaRepository`).
3. Métodos de consulta útiles:
    - `ProyectoRepository.existsByNombre(...)`, `findByNombre(...)`.
    - `TareaRepository.findByProyectoId(...)`, y filtros por `estado`/`prioridad`.

## Fase 4 – Servicios (Lógica de negocio)

1. Paquete `service`.
2. Interfaces: `ProyectoService`, `TareaService`.
3. Implementaciones `@Service` con transacciones:
    - CRUD de Proyecto.
    - CRUD de Tarea vinculado a un `proyectoId`.

## Fase 5 – API REST (Controladores)

1. Paquete `controller`.
2. Endpoints:
    - `/api/proyectos` (CRUD completo).
    - `/api/proyectos/{proyectoId}/tareas` (CRUD de tareas anidadas).
3. Probar con Postman/Insomnia o `curl`.

## Fase 6 – DTOs y Validación

1. Paquete `dto`.
2. DTOs de entrada/salida para Proyecto y Tarea.
3. Validaciones con `@Valid`, `@NotBlank`, `@Size`, etc.
4. Mappers manuales o MapStruct (si quieres).

## Fase 7 – Manejo global de errores

1. Paquete `exception`.
2. `ResourceNotFoundException`, `BadRequestException`, etc.
3. `@ControllerAdvice` con `@ExceptionHandler` y payload consistente.

## Fase 8 – Persistencia y utilidades

1. Paginación/ordenación en listados.
2. Filtros por estado, prioridad y fecha límite.
3. Búsqueda por texto (título/descr.).

## Fase 9 – Documentación y calidad

1. Swagger/OpenAPI (springdoc-openapi).
2. Logs y formateo SQL.
3. Tests: `@DataJpaTest` y tests de controlador con `@WebMvcTest`.

## Fase 10 – Seguridad (a futuro)

1. Cuando decidas multiusuario:
    - Introducir entidad `Usuario`.
    - Añadir `usuario_id` en `Proyecto`.
    - Endpoints anidados por usuario si aplica.
2. Spring Security/JWT más adelante.

## Orden recomendado

1. Crear proyecto + configuración BD.
2. Entidades y relación 1:N.
3. Repositorios y prueba rápida (semilla opcional).
4. Servicios y controladores CRUD.
5. DTOs + validación + manejo de errores.
6. Paginación/filtros + Swagger.
7. Más adelante, seguridad y multiusuario.
