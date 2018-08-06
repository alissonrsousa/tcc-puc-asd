DELETE FROM `oauth`.oauth_client_details;

INSERT INTO `oauth`.user (username, email, password, activated)
SELECT * FROM (SELECT 'admin', 'admin@admin.com', '$2a$10$WTKMZvqc.MYmg2/oXstNRedA.Gx8o4ws1lUF8marx8tOgtV0faQGa', true) AS tmp
WHERE NOT EXISTS (
    SELECT username FROM `oauth`.user WHERE username = 'admin'
) LIMIT 1;

INSERT INTO `oauth`.authority (name)
SELECT * FROM (SELECT 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM `oauth`.authority WHERE name = 'ROLE_USER'
) LIMIT 1;

INSERT INTO `oauth`.authority (name)
SELECT * FROM (SELECT 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM `oauth`.authority WHERE name = 'ROLE_ADMIN'
) LIMIT 1;

INSERT INTO `oauth`.user_authority (username, authority)
SELECT * FROM (SELECT 'admin', 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM `oauth`.user_authority WHERE username = 'admin' and authority = 'ROLE_USER'
) LIMIT 1;

INSERT INTO `oauth`.user_authority (username, authority)
SELECT * FROM (SELECT 'admin', 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM `oauth`.user_authority WHERE username = 'admin' and authority = 'ROLE_ADMIN'
) LIMIT 1;