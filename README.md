# Equifax app

Proyecto de prueba realizado con Angular 17, Spring Boot 3.2.4 (Java 17) y PostgreSQL para Equifax.


## Requisitos previos

Asegúrese de tener instalado Docker y Docker Compose en su sistema. Puede encontrar instrucciones de instalación en los siguientes enlaces:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Configuración y ejecución
1. Clone este repositorio

   ```bash
   git clone https://github.com/leonelalejandroppp/equifaxapp.git

2. Navegue hasta la carpeta

    ```bash
    cd equifaxapp

3. Ejecute Docker Compose para construir e iniciar los contenedores:

    ```bash
    docker-compose up --build
    
Esto iniciará los contenedores Docker para la aplicación.
No es necesario ejecutar Scripts ya que la aplicación lo hace por si sola, tanto el crear la base de datos como las tablas.

## Acceder a la app

Una vez que los contenedores estén en funcionamiento, puede acceder a la aplicación desde su navegador web a través de la siguiente URL:

- [http://localhost:4200/auth/login](http://localhost:4200/auth/login)

#### Usuarios para ingresar a la app:

| Email  | Password |
| ------------- | ------------- |
| hola@hola.cl  | TestApp123!  |
| leonelalejandro.cb@gmail.com  | Hunter2!  |

#### Archivo para la carga de personas

El archivo para cargar las personas se encuentra en la carpeta **excel-file**

## Testing

Para correr los tests de las aplicaciones, se deben ejecutar por separados:

- Backend

    ```bash
    cd api
    mvn tests

- Frontend
    ```bash
    cd front
    ng test