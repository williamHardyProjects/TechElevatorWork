BEGIN TRANSACTION;

SELECT park_id
    , name
    , location
    , establish_date
    , area
    , visitors
    , description
FROM park;

SELECT c.campground_id
    , c.park_id
    , c.name
    , c.open_from_mm
    , c.open_to_mm
    , c.daily_fee
FROM park AS p
INNER JOIN campground AS c
    ON p.park_id = c.park_id
WHERE p.park_id = 1;

SELECT count(s.site_id)
--    , s.campground_id
--    , s.site_number
--    , s.max_occupancy
--    , s.accessible
--    , s.max_rv_length
--    , s.utilities
FROM site AS s
INNER JOIN campground AS c
    ON s.campground_id = c.campground_id
INNER JOIN park AS p
    ON c.park_id = p.park_id
WHERE s.max_rv_length > 0
    AND s.utilities = true
--    AND p.park_id = 3;

SELECT * FROM reservation;


SELECT *
FROM reservation
WHERE name = 'TEST';

INSERT INTO reservation
(
    reservation_id
    , site_id
    , name
    , from_date
    , to_date
)
VALUES
(
    ?
    ,?
    , ?
    , ?
    , ?
); 

SELECT *
FROM reservation
WHERE name = 'TEST';

SELECT r.reservation_id
    , r.site_id
    , r.name
    , r.from_date
    , r.to_date
    , r.create_date
FROM reservation AS r
INNER JOIN site AS s
    ON r.site_id = s.site_id
INNER JOIN campground AS c
    ON s.campground_id = c.campground_id
INNER JOIN park AS p
    ON c.park_id = p.park_id
WHERE r.from_date BETWEEN current_date AND current_date + 30
    AND p.park_id = 1;

SELECT * FROM site;

SELECT s.site_id
    , s.campground_id
    , s.site_number
    , s.max_occupancy
    , s.accessible
    , s.max_rv_length
    , s.utilities
FROM site AS s
LEFT JOIN reservation AS r
    ON s.site_id = r.site_id
LEFT JOIN campground AS c
    ON s.campground_id = c.campground_id
LEFT JOIN park AS p
    ON c.park_id = p.park_id
WHERE r.reservation_id IS NULL
    AND p.park_id = 3;


SELECT nextval('reservation_reservation_id_seq');

ROLLBACK TRANSACTION;