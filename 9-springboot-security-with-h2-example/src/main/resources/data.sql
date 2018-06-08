INSERT INTO USERS VALUES('user1','{noop}12345',TRUE);
INSERT INTO USERS VALUES('user2','{noop}secrett',TRUE);
INSERT INTO USERS VALUES('celal','{noop}secret',TRUE);

INSERT INTO AUTHORITIES VALUES('user1','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('user2','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('user2','ROLE_EDITOR');
INSERT INTO AUTHORITIES VALUES('celal','ROLE_USER');
INSERT INTO AUTHORITIES VALUES('celal','ROLE_EDITOR');
INSERT INTO AUTHORITIES VALUES('celal','ROLE_ADMIN');

INSERT INTO p_personel (id,first_name,last_name) VALUES (1, 'Ziya', 'Ferit');
INSERT INTO p_personel (id,first_name,last_name) VALUES (2, 'Beşir', 'Dal');
INSERT INTO p_personel (id,first_name,last_name) VALUES (3, 'Eda', 'Rize');
INSERT INTO p_personel (id,first_name,last_name) VALUES (4, 'Hadi', 'Duru');
INSERT INTO p_personel (id,first_name,last_name) VALUES (5, 'Pınar', 'Mus');
INSERT INTO p_personel (id,first_name,last_name) VALUES (6, 'Çiğdem', 'Su');
INSERT INTO p_personel (id,first_name,last_name) VALUES (7, 'Aslı', 'Zor');
INSERT INTO p_personel (id,first_name,last_name) VALUES (8, 'Murat', 'Eski');
INSERT INTO p_personel (id,first_name,last_name) VALUES (9, 'Davut', 'Saz');
INSERT INTO p_personel (id,first_name,last_name) VALUES (10, 'Kadir', 'Mutlu');

INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (1, 'Maviş', '2005-09-07', 1);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (2, 'Donetello', '2008-08-06', 2);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (3, 'Karabaş', '2001-04-17', 1);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (4, 'Joe', '2009-03-07', 2);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (5, 'Canavar', '2010-11-30', 2);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (6, 'Tatlım', '2010-01-20', 3);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (7, 'Samanta', '2008-09-04', 5);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (8, 'Boncuk', '2008-09-04', 5);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (9, 'Şanslı', '2007-08-06', 5);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (10, 'Karaburun', '2009-02-24', 6);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (11, 'Twetty', '2000-03-09', 7);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (12, 'Tarçın', '2000-06-24', 8);
INSERT INTO p_pet (id,first_name,birth_date,personel_id) VALUES (13, 'Sarı', '2002-06-08', 9);