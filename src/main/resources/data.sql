--- Usuarios
 INSERT INTO user_entity (user_id, username, correo, contrasena, int_fallidos_ingreso, activo) VALUES
 (1, 'matias', 'matias@mail.com', 'pass123', 0, true),
 (2, 'admin', 'admin@mail.com', 'adminpass', 0, true);

 -- Roles
 INSERT INTO role_entity (id, role_name) VALUES
 (1, 'ROLE_USER'),
 (2, 'ROLE_ADMIN');

 -- Permisos
 INSERT INTO permission_entity (id, permission_name) VALUES
 (1, 'READ_PRIVILEGES'),
 (2, 'WRITE_PRIVILEGES'),
 (3, 'DELETE_PRIVILEGES');

 -- Relación Role-Permission (tabla intermedia role_permission)
 INSERT INTO role_permission (role_id, permission_id) VALUES
 (1, 1),  -- ROLE_USER tiene READ_PRIVILEGES
 (2, 1),  -- ROLE_ADMIN tiene READ_PRIVILEGES
 (2, 2),  -- ROLE_ADMIN tiene WRITE_PRIVILEGES
 (2, 3);  -- ROLE_ADMIN tiene DELETE_PRIVILEGES

 -- Relación Usuario-Rol
 INSERT INTO usuario_role (user_id, role_id) VALUES
 (1, 1),
 (2, 2);

 -- Amenidades
 INSERT INTO amenitie_entity (id, nombre, tipo_de_amenitie) VALUES
 (1, 'Pileta', 'Exterior'),
 (2, 'Quincho', 'Comedor'),
 (3, 'Estacionamiento', 'Accesibilidad');

 -- Fincas
 INSERT INTO finca_entity (id, name, ubication, price_per_hour, user_id, description, active) VALUES
 (1, 'Finca El Sol', 'Mendoza', 1500.00, 1, 'Hermosa finca en la montaña', true);

 -- Relación finca - amenidad
 INSERT INTO amenitie_finca (finca_id, amenitie_id) VALUES
 (1, 1),
 (1, 2);

-- Comentarios
 INSERT INTO commentary_entity (id, user_id, finca_id, description) VALUES
 (1, 1, 1,'PEPEPEPEPEPEPEPEPEPEPPE'),
 (2, 2, 1,'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA');
 -- Descuentos
 INSERT INTO discount_entity (id, name, discount_percentage) VALUES
 (1, 'Primera reserva', 10.0);

 -- Uso de descuento
 INSERT INTO user_discount_entity (id, user_id, discount_id, number_of_uses, active) VALUES
 (1, 1, 1, 1, true);

 -- Imágenes
 INSERT INTO image_entity (id, finca_id, url_image) VALUES
 (1, 1, 'https://example.com/img1.jpg');

 -- Horarios disponibles
 INSERT INTO hour_hand_entity (id, date, arrival_time, departure_time) VALUES
 (1, '2025-07-03', '12:00:00', '16:00:00');

 -- Relación finca - horarios
 INSERT INTO finca_hour_hand_entity (id, finca_id, hour_hand_id, reserved, price_per_hour) VALUES
 (1, 1, 1, false, 1500.00);

 -- Estado
 INSERT INTO state_entity (id, description) VALUES
 (1, 'Reservado'),
 (2, 'Pagado');

 -- Reserva
 --INSERT INTO reservation_entity (id, user_id, active, expiration_date, total_cost) VALUES
 --(1, 1, true, '2025-07-31', 6000.00);

 -- Histórico de estados
 --INSERT INTO state_history_entity (id, state_id, reservation_id, fecha) VALUES
 --(1, 1, 1, '2025-07-03');

 -- Ticket
 --INSERT INTO ticket_entity (id, reservation_id, total, payment_method, payment_date) VALUES
 --(1, 1, 6000.00, 'MercadoPago', '2025-07-03');

 -- Métodos de pago
 INSERT INTO payment_details_entity (id, user_id, cbu, alias) VALUES
 (1, 1, 123456789, 'finca.matias');