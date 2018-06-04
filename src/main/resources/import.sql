INSERT INTO USER (USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES ('abc', '1234', 'kimsu', 'abc@mail.com', CURRENT_TIMESTAMP());
INSERT INTO USER (USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES ('efg', '1234', 'collin', 'efg@mail.com', CURRENT_TIMESTAMP());
INSERT INTO USER (USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES ('hij', '1234', 'Nicolay', 'hij@mail.com', CURRENT_TIMESTAMP());
INSERT INTO USER (USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES ('klm', '1234', 'dongyoung', 'klm@mail.com', CURRENT_TIMESTAMP());
INSERT INTO USER (USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES ('nop', '1234', 'youngjun', 'nop@mail.com', CURRENT_TIMESTAMP());

INSERT INTO ACTIVITY (id, writer_id, title, contents, create_date, count_of_answer, location, behaviour, hashtag, like_hit, dislike_hit, content_type) VALUES ( 1, 1, 'Today Lunch', 'What is the menu for lunch for today? We have a soup today!!', CURRENT_TIMESTAMP(), 0, 'test','test','food',1,1,'TEXT');
INSERT INTO ACTIVITY (id, writer_id, title, contents, create_date, count_of_answer, location, behaviour, hashtag, like_hit, dislike_hit, content_type) VALUES ( 2, 2, 'Summit in Singpore', 'They will do summit in Singapore!! AWESOME!!', CURRENT_TIMESTAMP(), 0 , 'test','test','News',1,1,'TEXT');
INSERT INTO ACTIVITY (id, writer_id, title, contents, create_date, count_of_answer, location, behaviour, hashtag, like_hit, dislike_hit, content_type) VALUES ( 3, 4, 'Hot', 'Temperature today will be over 30 :) ', CURRENT_TIMESTAMP(), 0 , 'test','test','Weather',1,1,'TEXT');

