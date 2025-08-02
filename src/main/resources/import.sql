INSERT INTO genre (id, name) VALUES (1, 'Ação');
INSERT INTO genre (id, name) VALUES (2, 'Comédia');

INSERT INTO movie (id, title, synopsis, release_year, rent_price, img_url, genre_id) VALUES (1, 'Matrix', 'Um hacker descobre a verdade sobre a realidade.', 1999, 9.99, 'https://img.com/matrix.jpg', 1);
INSERT INTO movie (id, title, synopsis, release_year, rent_price, img_url, genre_id) VALUES (2, 'Se Beber, Não Case', 'A turma acorda sem lembrar da noite anterior.', 2009, 7.99, 'https://img.com/sebeber.jpg', 2);

INSERT INTO client (id, name, email, cpf) VALUES (1, 'Caio Lessa', 'caio@example.com', '12345678900');
INSERT INTO client (id, name, email, cpf) VALUES (2, 'Joana Lima', 'joana@example.com', '98765432100');

INSERT INTO rental (id, moment, total, client_id) VALUES (1, '2025-08-02T15:00:00Z', 17.98, 1);
INSERT INTO rental (id, moment, total, client_id) VALUES (2, '2025-08-01T10:30:00Z', 7.99, 2);

INSERT INTO rental_item (rental_id_fk, movie_id_fk, quantity, price) VALUES (1, 1, 1, 9.99);
INSERT INTO rental_item (rental_id_fk, movie_id_fk, quantity, price) VALUES (1, 2, 1, 7.99);
INSERT INTO rental_item (rental_id_fk, movie_id_fk, quantity, price) VALUES (2, 2, 1, 7.99);
