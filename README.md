# Taller #1: API REST - Catálogo de Productos (Café Soluble S.A.)

**Materia:** Servicios Web  
**Tecnologías:** Spring Boot | IntelliJ IDEA | Java | Postman  

---

## Fase 1 — Especificación Técnica de la API

### Tabla de Endpoints

| Operación | Método HTTP | Ruta | Entrada | Respuesta esperada | Código HTTP |
| :--- | :---: | :--- | :--- | :--- | :---: |
| Consultar todos los productos | `GET` | `/api/productos` | No requiere cuerpo. | Colección JSON con todos los productos. | `200 OK` |
| Consultar producto por ID | `GET` | `/api/productos/{id}` | Variable en URI (`id`). | Objeto JSON con los datos del producto. | `200 OK` |
| Registrar producto | `POST` | `/api/productos` | Objeto JSON en el cuerpo (`RequestBody`). | Objeto JSON del producto registrado. | `201 Created` |
| Consultar producto inexistente | `GET` | `/api/productos/{id}` | Variable en URI (`id` no existente). | Cuerpo vacío o mensaje de error. | `404 Not Found` |

---

### Análisis Obligatorio

1. **¿Por qué la ruta utiliza un sustantivo y no una acción?**  
   En REST, las URIs identifican **recursos** (como `/productos`), mientras que la acción a realizar sobre ellos la determina el **método HTTP** (`GET`, `POST`, etc.).

2. **¿Qué diferencia existe entre una URI de colección y una URI de recurso individual?**  
   Una URI de colección (`/api/productos`) representa el conjunto global de elementos, mientras que una URI individual (`/api/productos/{id}`) apunta a un elemento específico mediante su identificador.

3. **¿Por qué el método HTTP forma parte del significado de la operación?**  
   Porque el verbo HTTP indica la intención: un `GET` solicita lectura de datos, mientras que un `POST` indica la creación de un recurso nuevo bajo esa misma URI.

4. **¿Qué información debe viajar en la URI y cuál en JSON?**  
   En la URI viajan los identificadores y parámetros de búsqueda. En el cuerpo JSON (`RequestBody`) viaja la información estructurada necesaria para crear o modificar el recurso.

5. **¿Qué código HTTP permite distinguir una consulta exitosa, una creación y un recurso inexistente?**  
   * `200 OK`: Para lecturas/consultas exitosas.  
   * `201 Created`: Para la creación exitosa de un recurso mediante `POST`.  
   * `404 Not Found`: Para indicar que el recurso buscado por ID no existe.

---

## Fase 4 — Matriz de Pruebas Técnicas (Postman)

| # Escenario | Método | URL | Entrada (JSON) | Código HTTP | Resultado Esperado / Conclusión |
| :---: | :---: | :--- | :--- | :---: | :--- |
| **1** | `GET` | `http://localhost:8080/api/productos` | N/A | `200 OK` | Retorna la colección completa con los 8 productos cargados en memoria. |
| **2** | `GET` | `http://localhost:8080/api/productos/1` | N/A | `200 OK` | Retorna un objeto JSON con los datos del producto con ID `1`. |
| **3** | `GET` | `http://localhost:8080/api/productos/2` | N/A | `200 OK` | La respuesta corresponde exactamente al segundo recurso solicitado. |
| **4** | `GET` | `http://localhost:8080/api/productos/99` | N/A | `404 Not Found` | Maneja la búsqueda de un recurso inexistente retornando el código de estado correcto. |
| **5** | `POST` | `http://localhost:8080/api/productos` | `{ "nombre": "Café Molido 500g", "presentacion": "500 g", "categoria": "Molido", "disponible": true }` | `201 Created` | Recibe el JSON, registra el nuevo producto en la lista en memoria y confirma su creación. |
| **6** | `GET` | `http://localhost:8080/api/productos` | N/A | `200 OK` | Retorna la colección actualizada incluyendo el producto registrado en la prueba anterior. |

