# Modelo Entidad Relación (MER)

El modelo entidad realación de la aplicación "HearthStone info" consta de cinco tablas las cuales son:

- USUARIOS
- FAVORITOS
- MAZOS
- MAZO-CARTAS
- CARTAS



## Tabla USUARIOS

La tabla "USUARIOS" consta de dos atributos los cuales son: 

- Nombre, que es la clave primaria y de tipo varchar(20).
- Password, que es de tipo varchar(20).

## Tabla MAZOS

La tabla "MAZOS" cosnta de tres atributos los cuales son:

- ID, que es clave primaria y de tipo int,
- Nombre, que es de tipo varchar(20).
- NombreUsuario, que es la clave foranea de la tabla "USUARIOS".

## Tabla MAZO-CARTAS

La tabla "MAZO-CARTAS" consta de dos atributos los cuales son:

- IdMazo, clave primaria y clave foránea de la tabla "MAZOS" de tipo int.
- IdCarta, clave primaria y clave foránea de la tabla "CARTAS" de tipo varchar(10).

## Tabla CARTAS

La tabla "CARTAS" consta de un único atributo el cuál es:

- ID, clave primaria y es de tipo varchar(10).

## Tabla FAVORITOS

La tabla "FAVORITOS" consta de dos atributos los cuales son:

- NombreUsuario, clave primaria y clave foránea de la tabla "USUARIOS" de tipo varchar(20).
- IdCarta, clave primaria y clave foránea de la tabla "CARTAS" de tipo varchar(10).