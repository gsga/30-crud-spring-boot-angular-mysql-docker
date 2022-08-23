DROP DATABASE IF EXISTS tareas;
CREATE DATABASE IF NOT EXISTS tareas DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
DROP USER IF EXISTS `tareasuser`;
CREATE USER IF NOT EXISTS `tareasuser` @`%` IDENTIFIED BY 'tareaspassword';
GRANT USAGE ON *.* TO `tareasuser` @`%`;
GRANT ALL PRIVILEGES ON `tareas`.* TO 'tareasuser ' @' % ';
USE tareas;
DROP TABLE IF EXISTS tarea;
CREATE TABLE IF NOT EXISTS tarea (
  id int UNSIGNED NOT NULL AUTO_INCREMENT,
  tarea varchar(200) NOT NULL,
  finalizado tinyint(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = MyISAM AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
INSERT INTO tarea (id, tarea, finalizado)
VALUES (1, 'Reunión diaria | 08:30', 0),
  (2, 'Coordinar reunión ActivaLogic', 0);