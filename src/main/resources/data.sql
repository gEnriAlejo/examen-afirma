CREATE TABLE cliente (
  id_cliente bigint primary key auto_increment NOT NULL,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  telefono varchar(15) NOT NULL,
  fecha_registro date NOT NULL
);


CREATE TABLE habitacion (
  id_habitacion bigint primary key auto_increment NOT NULL,
  numero varchar(20) NOT NULL,
  tipo varchar(30) check (tipo in ('individual', 'doble', 'suite', 'triple')),
  descripcion varchar(100) NOT NULL,
  capacidad int NOT NULL,
  precio_por_noche numeric NOT NULL
);

CREATE TABLE reserva (
  id_reserva bigint primary key auto_increment NOT NULL,
  id_cliente bigint NOT NULL,
  id_habitacion bigint NOT NULL,
  fecha_inicio date NOT NULL,
  fecha_fin date NOT NULL,
  total numeric NOT NULL,
  estado varchar(30) NOT NULL,
  FOREIGN KEY (id_cliente) references cliente(id_cliente),
  FOREIGN KEY (id_habitacion) references habitacion(id_habitacion)
);

insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (1, 'A1', 'doble', 'con vista al mar', 4, 1500); 
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (2, 'B1', 'suite', 'elegante', 2, 4500);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (3, 'C1', 'doble', 'sin vista al mar', 4, 1000);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (4, 'D1', 'individual', 'con vista al mar', 1, 850);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (5, 'E1', 'doble', 'con vista al mar', 2, 1500);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (6, 'F1', 'triple', 'con vista al mar', 6, 3000);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (7, 'G1', 'individual', 'con vista al mar', 2, 850);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (8, 'H1', 'doble', 'sin vista al mar', 4, 1500);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (9, 'I1', 'individual', 'sin vista al mar', 1, 700);
insert into habitacion (id_habitacion, numero, tipo, descripcion, capacidad, precio_por_noche) values (10, 'J1', 'triple', 'sin vista al mar', 3, 2750);