BEGIN;

CREATE TABLE sentences
(
	id serial PRIMARY KEY,
	sentence TEXT NOT NULL
);

INSERT INTO sentences(id, sentence) VALUES (1, 'Test Sentence');
INSERT INTO sentences(id, sentence) VALUES (2, 'Another test sentence another test sentence');
INSERT INTO sentences(id, sentence) VALUES (3, 'Lisey Piecey I love you so so so so much');

SELECT setVal(pg_get_serial_sequence('sentences', 'id'), 4);

COMMIT;