-- ============================================================
--  BASE DE DATOS: clinic_animal_master
-- ============================================================
drop database  clinic_animal_master;
CREATE DATABASE IF NOT EXISTS clinic_animal_master
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE clinic_animal_master;
-- ------------------------------------------------------------
-- ROLES
-- ------------------------------------------------------------
CREATE TABLE roles (
                       id_roles          BIGINT          NOT NULL AUTO_INCREMENT,
                       nombre_rol  VARCHAR(100)    NOT NULL,
                       descripcion VARCHAR(255),
                       acceso_Web  TINYINT(1)      NOT NULL DEFAULT 0,
                       is_active   TINYINT(1)      NOT NULL DEFAULT 1,
                       created_at  DATETIME        NOT NULL,
                       updated_at  DATETIME        NOT NULL,
                       PRIMARY KEY (id_roles)
);
-- ------------------------------------------------------------
-- AREAS
-- ------------------------------------------------------------
CREATE TABLE areas (
                       id_areas          BIGINT          NOT NULL AUTO_INCREMENT,
                       nombre_area  VARCHAR(100)    NOT NULL,
                       descripcion VARCHAR(255),
                       is_active   TINYINT(1)      NOT NULL DEFAULT 1,
                       created_at  DATETIME        NOT NULL,
                       updated_at  DATETIME        NOT NULL,
                       PRIMARY KEY (id_areas)
);
-- ------------------------------------------------------------
-- CLIENTE
-- ------------------------------------------------------------
CREATE TABLE cliente (
                         id_cliente  BIGINT          NOT NULL AUTO_INCREMENT,
                         nombre      VARCHAR(100)    NOT NULL,
                         apellido    VARCHAR(100)    NOT NULL,
                         dni         VARCHAR(20)     NOT NULL UNIQUE,
                         telefono    VARCHAR(20),
                         direccion   VARCHAR(255),
                         email       VARCHAR(150),
                         is_active   TINYINT(1)      NOT NULL DEFAULT 1,
                         created_at  DATETIME        NOT NULL,
                         updated_at  DATETIME        NOT NULL,
                         PRIMARY KEY (id_cliente)
);
-- ------------------------------------------------------------
-- MASCOTA
-- ------------------------------------------------------------
CREATE TABLE mascota (
                         id_mascota  BIGINT          NOT NULL AUTO_INCREMENT,
                         nom_mascota VARCHAR(100)    NOT NULL,
                         especie     VARCHAR(100),
                         raza        VARCHAR(100),
                         edad        INT,
                         sexo        VARCHAR(10),
                         id_cliente  BIGINT          NOT NULL,
                         is_active   TINYINT(1)      NOT NULL DEFAULT 1,
                         created_at  DATETIME        NOT NULL,
                         updated_at  DATETIME        NOT NULL,
                         PRIMARY KEY (id_mascota),
                         CONSTRAINT fk_mascota_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);
-- ------------------------------------------------------------
-- PERSONAL
-- ------------------------------------------------------------
CREATE TABLE personal (
                          id_personal         BIGINT          NOT NULL AUTO_INCREMENT,
                          nombre_personal     VARCHAR(100)    NOT NULL,
                          apellido_personal   VARCHAR(100)    NOT NULL,
                          edad                INT,
                          dni                 VARCHAR(20)     NOT NULL UNIQUE,
                          email               VARCHAR(150),
                          telefono            VARCHAR(20),
                          fecha_registro      DATE,
                          estado              VARCHAR(20),
                          codigo_rol          BIGINT,
                          codigo_area         BIGINT,
                          is_active           TINYINT(1)      NOT NULL DEFAULT 1,
                          created_at          DATETIME        NOT NULL,
                          updated_at          DATETIME        NOT NULL,
                          PRIMARY KEY (id_personal),
                          CONSTRAINT fk_personal_rol  FOREIGN KEY (codigo_rol)  REFERENCES roles (id_roles),
                          CONSTRAINT fk_personal_area FOREIGN KEY (codigo_area) REFERENCES areas (id_areas)
);
-- ------------------------------------------------------------
-- SERVICIOS
-- ------------------------------------------------------------
CREATE TABLE servicios (
                           id_servicios    BIGINT          NOT NULL AUTO_INCREMENT,
                           nombre          VARCHAR(150)    NOT NULL,
                           descripcion     VARCHAR(255),
                           duracion        INT,
                           precio          DOUBLE          NOT NULL,
                           codigo_area     BIGINT,
                           is_active       TINYINT(1)      NOT NULL DEFAULT 1,
                           created_at      DATETIME        NOT NULL,
                           updated_at      DATETIME        NOT NULL,
                           PRIMARY KEY (id_servicios),
                           CONSTRAINT fk_servicio_area FOREIGN KEY (codigo_area) REFERENCES areas (id_areas)
);
-- ============================================================
--  DATOS DE PRUEBA
-- ============================================================
-- ROLES
INSERT INTO roles (nombre_rol, descripcion, acceso_Web, is_active, created_at, updated_at) VALUES
                                                                                               ('Administrador',    'Gestión general del sistema',         1, 1, NOW(), NOW()),
                                                                                               ('Recepcionista',    'Atención al cliente y agenda',        1, 1, NOW(), NOW()),
                                                                                               ('Veterinario',      'Médico veterinario titulado',         1, 1, NOW(), NOW()),
                                                                                               ('Asistente',        'Asistente de veterinario',            0, 1, NOW(), NOW()),
                                                                                               ('Auxiliar',         'Apoyo general en clínica',            0, 1, NOW(), NOW());
-- AREAS
INSERT INTO areas (nombre_area, descripcion, is_active, created_at, updated_at) VALUES
                                                                                    ('Consulta General',    'Atención médica general para mascotas',    1, NOW(), NOW()),
                                                                                    ('Cirugía',             'Procedimientos quirúrgicos',               1, NOW(), NOW()),
                                                                                    ('Peluquería',          'Estética y grooming',                      1, NOW(), NOW());
-- CLIENTES
INSERT INTO cliente (nombre, apellido, dni, telefono, direccion, email, is_active, created_at, updated_at) VALUES
                                                                                                               ('Carlos',   'Mendoza',   '12345678', '987001001', 'Av. Lima 101',       'carlos.mendoza@email.com',   1, NOW(), NOW()),
                                                                                                               ('Lucia',    'Torres',    '23456789', '987001002', 'Jr. Huancayo 202',   'lucia.torres@email.com',     1, NOW(), NOW()),
                                                                                                               ('Pedro',    'Quispe',    '34567890', '987001003', 'Calle Arequipa 303', 'pedro.quispe@email.com',     1, NOW(), NOW()),
                                                                                                               ('Ana',      'Rojas',     '45678901', '987001004', 'Av. Cusco 404',      'ana.rojas@email.com',        1, NOW(), NOW()),
                                                                                                               ('Miguel',   'Vargas',    '56789012', '987001005', 'Jr. Puno 505',       'miguel.vargas@email.com',    1, NOW(), NOW());
-- MASCOTAS
INSERT INTO mascota (nom_mascota, especie, raza, edad, sexo, id_cliente, is_active, created_at, updated_at) VALUES
                                                                                                                ('Rex',      'Perro', 'Labrador',         3, 'M', 1, 1, NOW(), NOW()),
                                                                                                                ('Luna',     'Gato',  'Siamés',           2, 'F', 1, 1, NOW(), NOW()),
                                                                                                                ('Toby',     'Perro', 'Beagle',           5, 'M', 2, 1, NOW(), NOW()),
                                                                                                                ('Mia',      'Gato',  'Persa',            1, 'F', 3, 1, NOW(), NOW()),
                                                                                                                ('Rocky',    'Perro', 'Pastor Alemán',    4, 'M', 4, 1, NOW(), NOW()),
                                                                                                                ('Coco',     'Perro', 'Golden Retriever', 2, 'F', 5, 1, NOW(), NOW());
-- PERSONAL
INSERT INTO personal (nombre_personal, apellido_personal, edad, dni, email, telefono, fecha_registro, estado, codigo_rol, codigo_area, is_active, created_at, updated_at) VALUES
                                                                                                                                                                              ('Sofia',    'Paredes Huamani',   30, '71000001', 'sofia.paredes@clinica.com',   '991001001',  '2023-01-10', 'DISPONIBLE',    1, 1, 1, NOW(), NOW()),
                                                                                                                                                                              ('Jorge',    'Huamani Mamani',   35, '71000002', 'jorge.huamani@clinica.com',   '991001002',  '2023-02-15', 'DISPONIBLE',    1, 2, 1, NOW(), NOW()),
                                                                                                                                                                              ('Valeria',  'Castro Lazo',    28, '71000003', 'valeria.castro@clinica.com',  '991001003', '2023-03-20', 'DISPONIBLE',       2, 1, 1, NOW(), NOW()),
                                                                                                                                                                              ('Luis',     'Mamani',    40, '71000004', 'luis.mamani@clinica.com',     '991001004',  '2022-11-05', 'DISPONIBLE',    4, 1, 1, NOW(), NOW()),
                                                                                                                                                                              ('Carmen',   'Flores Ato',    26, '71000005', 'carmen.flores@clinica.com',   '991001005',  '2024-01-08', 'DISPONIBLE',      3, 3, 1, NOW(), NOW());
-- SERVICIOS
INSERT INTO servicios (nombre, descripcion, duracion, precio, codigo_area, is_active, created_at, updated_at) VALUES
                                                                                                                  ('Consulta General',        'Revisión médica completa de la mascota',   30, 50.00,  1, 1, NOW(), NOW()),
                                                                                                                  ('Vacunación',              'Aplicación de vacunas preventivas',      15, 35.00,  1, 1, NOW(), NOW()),
                                                                                                                  ('Triaje',      'Evaluación física general, triaje y diagnóstico inicial.', 40, 60.00, 1, 1, NOW(), NOW()),
                                                                                                                  ('Vacunación (Quíntuple)',      'Protección contra Parvovirus, Distemper, Hepatitis, etc.', 30, 50.00, 1, 1, NOW(), NOW()),
                                                                                                                  ('Desparasitación',      'Control de parásitos internos y externos (según el peso).', 15, 40.00, 1, 1, NOW(), NOW()),
                                                                                                                  ('Esterilización (Hembra)','Cirugía para remover ovarios y útero (varía según tamaño).',    120, 260.00, 2, 1, NOW(), NOW()),
                                                                                                                  ('Castración (Macho)','Procedimiento quirúrgico para remover testículos.',    80, 120.00, 2, 1, NOW(), NOW()),
                                                                                                                  ('Profilaxis Dental','Limpieza profunda con ultrasonido bajo anestesia general.',    100, 120.00, 2, 1, NOW(), NOW()),
                                                                                                                  ('Cirugía de Esterilización','Procedimiento de esterilización',    120, 250.00, 2, 1, NOW(), NOW()),
                                                                                                                  ('Baño y Corte',            'Servicio completo de grooming',    60, 45.00,  3, 1, NOW(), NOW()),
                                                                                                                  ('Atención de Urgencia',    'Revisión de patas',        45, 80.00,  3, 1, NOW(), NOW()),
                                                                                                                  ('Análisis de Sangre',      'Corte de pelo y peinado', 20, 120.00, 3, 1, NOW(), NOW());