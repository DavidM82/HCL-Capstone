/* 
create database capstone;
use capstone;

create user 'capstone'@'%' identified by 'team4';
grant all on capstone.* to 'capstone'@'%';
*/

-- SELECT m.name, m.track_number, a.name, a.artist FROM MUSIC m JOIN ALBUM a ON m.album_id = a.id WHERE a.id = 2;
-- SELECT * FROM MUSIC;
-- SELECT * FROM USER;
-- INSERT INTO SHOPPING_CART (id, user_id, music_id, album_id, product_id) VALUES (1, 1, 4, NULL, NULL); 

SELECT * FROM CATEGORY;
INSERT INTO CATEGORY VALUES (1, 'Instruments', NULL);

INSERT INTO USER (id, username, email, password, is_admin) VALUES (1, 'Bob', 'bob@mail.net', '$2y$12$IUrHjs5tRVqIZhJt7uk6Su3uJIage69oGaY6FDGk68l2kw4pgS9WO', false); -- password is "secret"
INSERT INTO USER (id, username, email, password, is_admin) VALUES (2, 'Alice', 'alice@mail.net', '$2y$12$EHw2LrcEVjVNma4Jm3RqJ..GXAhOhcdgKqzpmC/g3ei4b/JW5CyiG', true); -- password is "hidden"

SELECT * FROM shopping_cart;
INSERT INTO shopping_cart VALUES (1, 1, null, 1);
INSERT INTO shopping_cart VALUES (2,2, null, 1);
INSERT INTO shopping_cart VALUES (3,4, null, 1);

INSERT INTO genre VALUES (1, "Alternative Rock", NULL);
INSERT INTO genre VALUES (2, "Heavy Metal", NULL);

INSERT INTO album VALUES (1, "American Idiot", "Green Day", 1);
INSERT INTO album VALUES (2, "British Steel", "Judas Priest", 2);

INSERT INTO music VALUES (1, "American Idiot", 2.99, 1, 1);
INSERT INTO music VALUES (2, "Jesus of Suburbia", 2.99, 2, 1);
INSERT INTO music VALUES (3, "Holiday", 2.99, 3, 1);
INSERT INTO music VALUES (4, "Boulevard of Broken Dreams", 2.99, 4, 1);
INSERT INTO music VALUES (5, "Are We the Waiting", 2.99, 5, 1);
INSERT INTO music VALUES (6, "St. Jimmy", 2.99, 6, 1);
INSERT INTO music VALUES (7, "Give Me Novacaine", 2.99, 7, 1);
INSERT INTO music VALUES (8, "She's a Rebel", 2.99, 8, 1);
INSERT INTO music VALUES (9, "Extraordinary Girl", 2.99, 9, 1);
INSERT INTO music VALUES (10, "Letterbomb", 2.99, 10, 1);
INSERT INTO music VALUES (11, "Wake Me Up When September Ends", 3.99, 11, 1);
INSERT INTO music VALUES (12, "Homecoming", 2.99, 12, 1);
INSERT INTO music VALUES (13, "Whatshername", 2.99, 13, 1);

INSERT INTO music VALUES (14, "Breaking the Law", 1.99, 1,2);
INSERT INTO music VALUES (15, "Rapid Fire", 1.99, 2,2);
INSERT INTO music VALUES (16, "Metal Gods", 1.99, 3,2);
INSERT INTO music VALUES (17, "Grinder", 1.99, 4,2);
INSERT INTO music VALUES (18, "United", 1.99, 5,2);
INSERT INTO music VALUES (19, "Living After Midnight", 1.99, 6,2);
INSERT INTO music VALUES (20, "Don't Have to Be Old to Be Wise", 1.99, 7,2);
INSERT INTO music VALUES (21, "The Rage", 1.99, 8,2);
INSERT INTO music VALUES (22, "Steeler", 1.99, 9, 2);