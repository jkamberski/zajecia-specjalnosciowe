INSERT INTO users (username, email, password)
VALUES
('jan', 'jan@test.pl', 'hash1'),
('anna', 'anna@test.pl', 'hash2'),
('mateusz', 'mateusz@test.pl', 'hash3');

INSERT INTO posts (user_id, content)
VALUES
(1, 'Mój pierwszy wpis na MicroBlog!'),
(2, 'Co za piękny dzień!'),
(1, 'Drugi wpis użytkownika Jan');

INSERT INTO follows (follower_id, followed_id)
VALUES
(1, 2),
(2, 1),
(3, 1);
