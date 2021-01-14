-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

BEGIN TRANSACTION;
-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
SELECT * 
FROM actor;

INSERT INTO actor
(
        first_name
        , last_name
)
VALUES
(
        'Hampton',
        'Avenue'      
),
(
        'Lisa',
        'Byway'      
);


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

INSERT INTO film
(
        title
        , description
        , release_year
        , language_id
        , original_language_id
        , length
)
VALUES
(
        'Euclidean PI'
        , 'The epic story of Euclid as a pizza delivery boy in
-- ancient Greece'
        , 2008
        , 1
        , 1
        , 198
);

SELECT *
FROM film
WHERE title = 'Euclidean PI';
--203
--204

--1001

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

SELECT actor_id
FROM actor
WHERE first_name = 'Hampton'
        OR first_name = 'Lisa';
        
INSERT INTO film_actor
(
        actor_id
        , film_id
)
VALUES
(
        203
        , 1001
),
(
        204
        , 1001
);

SELECT *
FROM film_actor
WHERE actor_id = 203
        OR actor_id = 204;

-- 4. Add Mathmagical to the category table.

INSERT INTO category
(
        name
)
VALUES
(
        'Mathematical'
);

SELECT *
FROM category;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
--17

--274
--494
--714
--996

INSERT INTO film_category
(
        film_id
        , category_id
)
VALUES
(
        1001
        , 17
),
(
        274
        , 17
),
(
        494
        , 17
),
(
        714
        , 17
),
(
        996
        , 17
);

SELECT film_id
FROM film
WHERE title = 'EGG IGBY'
        OR title = 'KARATE MOON'
        OR title = 'RANDOM GO'
        OR title = 'YOUNG LANGUAGE';

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

UPDATE film
SET rating = 'G'
WHERE film_id
        IN (
                SELECT film_id
                FROM film_category
                WHERE category_id = 17
        );

-- 7. Add a copy of "Euclidean PI" to all the stores.

INSERT INTO inventory
(
        film_id
        , store_id
)
VALUES
(
        1001
        , 1
),
(
        1001
        , 2
);

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <did not succeed because there are dependencies for example film_actor has foreign key to film>

DELETE FROM film
WHERE film_id = 1001;




-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <did not succeed because there are dependencies for example film_category has foreign key to category>

DELETE FROM category
WHERE category_id = 17;



-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <succeeded because there are not foreign keys that point to film_category table>

DELETE FROM film_category
WHERE category_id = 17;



-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <The first worked because foreign keys pointing to row in category table were removed. The second one didn't work because foreign keys to film table still exist>

DELETE FROM category
WHERE category_id = 17;

DELETE FROM film
WHERE film_id = 1001;

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

--SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
--SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;
--constraint_name                
------------------------------ 
--rows relating to film_id of "Euclidean PI" in film_actor need to be removed
--rows relating to film_id of "Euclidean PI" in film_category need to be removed
--rows relating to film_id of "Euclidean PI" in inventory need to be removed

COMMIT TRANSACTION;