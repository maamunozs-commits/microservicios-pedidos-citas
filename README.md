# Microservicios de Pedidos y Citas

Proyecto desarrollado con **Spring Boot** y **Maven**, compuesto por dos microservicios independientes:

- **servicio-pedidos**
- **servicio-citas**

El objetivo del proyecto es separar responsabilidades en servicios distintos para tener un sistema más ordenado, claro y fácil de mantener.

---

## Estructura del proyecto

```text
microservicios-pedidos-citas
├── servicio-pedidos
└── servicio-citas
```

- **servicio-pedidos**: administra pedidos de productos para mascotas.
- **servicio-citas**: administra citas veterinarias.

---

## Ejecución de los microservicios

Ubicarse en la carpeta raíz del proyecto:

```powershell
cd "C:\Users\Matias\Desktop\Semana 3\Microservicios\microservicios-pedidos-citas"
```

### Ejecutar servicio-pedidos
```powershell
mvn -pl servicio-pedidos spring-boot:run
```

### Ejecutar servicio-citas
```powershell
mvn -pl servicio-citas spring-boot:run
```

---

## Puertos utilizados

- **servicio-pedidos** → `8081`
- **servicio-citas** → `8082`

---

## Endpoints principales

## Servicio Pedidos

### Listar todos los pedidos
```text
http://localhost:8081/api/pedidos
```

### Buscar pedido por id
```text
http://localhost:8081/api/pedidos/1
```

### Filtrar pedidos por estado
```text
http://localhost:8081/api/pedidos/estado/Pendiente
```

### Filtrar pedidos por categoría
```text
http://localhost:8081/api/pedidos/categoria/Accesorios
```

---

## Servicio Citas

### Listar todas las citas
```text
http://localhost:8082/api/citas
```

### Buscar cita por id
```text
http://localhost:8082/api/citas/1
```

### Filtrar citas por estado
```text
http://localhost:8082/api/citas/estado/Programada
```

### Filtrar citas por veterinario
```text
http://localhost:8082/api/citas/veterinario/Ramirez
```

---

## Ejemplo de POST para servicio-pedidos

Ubicarse en la carpeta del microservicio:

```powershell
cd "C:\Users\Matias\Desktop\Semana 3\Microservicios\microservicios-pedidos-citas\servicio-pedidos"
```

Luego ejecutar:

```powershell
$bodyPedido = @{
  nombreProducto = "Alimento Premium Gato 10kg"
  categoriaProducto = "Alimento"
  cantidad = 2
  precioUnitario = 15990.0
  nombreCliente = "Maria Lopez"
  fechaPedido = "2026-03-30"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8081/api/pedidos" `
  -Method Post `
  -ContentType "application/json" `
  -Body $bodyPedido
```

---

## Ejemplo de POST para servicio-citas

Ubicarse en la carpeta del microservicio:

```powershell
cd "C:\Users\Matias\Desktop\Semana 3\Microservicios\microservicios-pedidos-citas\servicio-citas"
```

Luego ejecutar:

```powershell
$bodyCita = @{
  nombreMascota = "Rocky"
  tipoMascota = "Perro"
  nombreDueno = "Maria Lopez"
  telefonoDueno = "+56912345678"
  servicio = "Consulta general"
  veterinario = "Dr. Ramirez"
  fechaHora = "2026-04-01 10:00"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8082/api/citas" `
  -Method Post `
  -ContentType "application/json" `
  -Body $bodyCita
```

---

## Tecnologías utilizadas

- **Java**
- **Spring Boot**
- **Maven**
- **REST API**

---

## Autor

**Matias Muñoz**
