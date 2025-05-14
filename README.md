# CarSeller

---

CarSeller es una aplicación Java Spring Boot para la gestión de un sistema de venta de autos. Permite registrar, autenticar y gestionar roles de usuarios como Clientes, Gerentes (Managers) y Vendedores. 

## Diagrama UML inicial

![UML Concesionaria.png](UML%20Concesionaria.png)

## Diagrama EER final

![EER Diagram CarSeller.png](EER%20Diagram%20CarSeller.png)

## Características principales

- **Autenticación JWT** para proteger las rutas de acceso.
- Gestión de:
  - Person: Client, Vendor, Manager
  - Roles: MANAGER, CLIENT, VENDOR
  - Cars
- Separación de capas: controladores, servicios, repositorios y DTOs.
- Base de datos con JPA/Hibernate.
- Servicios RESTful para acceso vía API.

---
### Tecnologias

- Java 
- Spring
- Lombok
- SQL 
- Git

### Programas

- IntelliJ
- MySQL Workbench
- Postman
- GitHub 


## Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/CarSeller/
│   │   ├── controllers/       # Controladores REST
│   │   ├── models/            # Entidades JPA
│   │   ├── dtos/              # Objetos de transferencia
│   │   ├── repositories/      # Interfaces de acceso a datos
│   │   ├── services/          # Lógica de negocio
│   │   ├── config/            # Configuración de seguridad y beans
│   │   ├── filters/           # Filtros JWT
│   │   └── CarSellerApplication.java
│   ├── resources/
│       ├── application.properties  # Configuración del entorno
├── test/
│   └── ... (tests de servicios)
```

---

## Cómo ejecutar la aplicación


### Pasos

1. **Clonar el repositorio:**

```bash
git clone https://github.com/franciscofarrando/Project-1-CarSeller
cd CarSeller
```

2. **Configurar la base de datos:**

Editar el archivo `src/main/resources/application.properties` y establecer:

```properties
spring.application.name=CarSeller

spring.security.user.name=admin
spring.security.user.password=admin123

spring.datasource.url=jdbc:mysql://localhost:3306/carseller3
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```
La aplicación estará disponible en: `http://localhost:8080/`

---

## Endpoints

(Todos los endpoints requieren token JWT, salvo `/auth/login`)

- `POST /api/auth/login` - Autenticación todos los roles pueden logearse.
- `GET /api/clients` - Listado de clientes (Se puede buscar TODOS, por Id y por contenido en el nombre).
- `GET /api/vendors` - Listado de vendedores(Se puede buscar TODOS, por Id, por contenido en el nombre o por autos vendidos o asignados).
- `GET /api/managers` - Listado de gerentes (Se puede buscar TODOS, por Id y por contenido en el nombre).


Los siguientes Endpoints son de acceso solo para el Rol de Manager (Admin):

Autos:
- `POST /api/admin/car/post` - Registrar autos
- `PUT /api/admin/car/put/id/{id}` - Actualizar toda la información de un auto en particular, lo que no se declare, pasará a sel NULL
- `PATCH /api/admin/car/patch/id/{id}` - Actualizar cierta información como: Vendor y Client
  
 
Clientes:
- `POST /api/admin/client/post` - Registrar clientes
- `PATCH /api/admin/client/patch/id/{id}` - Actualizar información como: Nombre, Dirección y Teléfono.
- `DELETE /api/admin/client/delete/id/{id}` - Eliminar clientes

Vendedores:
- `POST /api/admin/vendor/post` - Registrar vendedores
- `PUT /api/admin/vendor/put/id/{id}` - Actualizar toda la información de un auto en particular, lo que no se declare, pasará a sel NULL
- `PATCH /api/admin/vendor/patch/id/{id}` - Actualizar información como: Nombre, Dirección y Teléfono.
- `DELETE /api/admin/vendor/delete/id/{id}` - Eliminar clientes

Roles:
- `GET /api/private` - -Listado de todos los roles creados.
- `POST /api/private` - Registrar roles
- `PUT /api/private/id/{id}` - Actualizar toda la información del rol.
- `DELETE /api/private/id/{id}` - Eliminar roles

---

## Extra Links

Para consultar el Repositorio en GitHub:

https://github.com/franciscofarrando/Project-1-CarSeller

Para consultar el Task Manager de cómo se fue desarrollando éste proyecto:

https://trello.com/b/yxMCf0qf/project1-carseller

Para consultar la presentación de diapositivas:

https://docs.google.com/presentation/d/1f1mWZ_UyUY2rvqspmTuSZqBwu2QdpXwqkiBfzC1Xsiw/edit?usp=sharing

---

## Trabajo Futuro

Para poder dar por terminado el proyecto, me gustaría poder hacer los JUnit test para poder verificar un correcto funcionamiento de la aplicación antes de su posible demostración futura.


## Miembro

Francisco Ismael Farrando.