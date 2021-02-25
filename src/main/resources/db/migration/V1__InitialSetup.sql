CREATE TABLE TODOS (
  ID BIGSERIAL PRIMARY KEY,
  TITLE VARCHAR NOT NULL,
  COMPLETED BOOLEAN NOT NULL,
  ORDERING INT
);

INSERT INTO TODOS (TITLE, COMPLETED, ORDERING) VALUES ('pick up kids tomorrow', false, 1),
                                                      ('buy food', false, 2),
                                                      ('feed dog', true, 2)