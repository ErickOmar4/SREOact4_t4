# act4_t4 — API REST con Spring Security + JWT

Actividad 4, Tema 4. API REST pura en Spring Boot (sin vistas), con autenticación real mediante Spring Security y JWT, DTOs, validación con Bean Validation, y probada/documentada con Bruno.

## 📌 Descripción del proyecto

- **Entidad principal:** `Mascota` que es la que use en la Actividad 3, relacionada con `Especie` (`@ManyToOne`)
- **Autenticación:** registro y login con JWT real (`Usuario` con password encriptado con BCrypt)
- **Endpoints protegidos:** todo `/api/mascotas/**` y `/api/especies/**` 
- **Capas:** Controller , Service , Repository -> Entity, con DTOs de entrada y de salida (el password del usuario nunca se expone en ninguna respuesta)
- **Validación:** `@Valid` + `@NotBlank`/`@NotNull`/`@Positive`/`@Size`, con errores 400 claros y detallados
- **Códigos de estado:** 200, 201, 400, 401, 404, usando `ResponseEntity`

##  Tecnologías

- Spring Boot 4.1.0 (Web, Data JPA, Security, Validation)
- JJWT 0.12.6
- MySQL
- Bruno (bruno.io)
- Maven, VS Code

---

2. En Bruno, abre la carpeta `bruno/` como colección, selecciona el environment **Local**.
3. Corre en orden: `01 - Registro` → `02 - Login` (guarda el token automáticamente) → `03 - Listar mascotas` → `04 - Crear mascota` (guarda el id automáticamente) → `05/06/07` → `08 - Sin token` (debe regresar 401).


## proyecto en la (VPS)

- URL base: http://168.231.69.225:PUERTO_NUEVO

