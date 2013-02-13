-- populate USERS tables with dummy data
DELETE FROM USERS;

INSERT INTO USERS (user_id,username,first_name,last_name,password_hashed,role_id) VALUES (1,'user1','us','er1','password',5);
INSERT INTO USERS (user_id,username,first_name,last_name,password_hashed,role_id) VALUES (2,'user2','us','er2','password',4);
INSERT INTO USERS (user_id,username,first_name,last_name,password_hashed,role_id) VALUES (3,'user3','us','er3','password',3);
INSERT INTO USERS (user_id,username,first_name,last_name,password_hashed,role_id) VALUES (4,'user4','us','er4','password',2);
INSERT INTO USERS (user_id,username,first_name,last_name,password_hashed,role_id) VALUES (5,'user5','us','er5','password',1);

