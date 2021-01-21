-- database name: campground;

DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS site;
DROP TABLE IF EXISTS campground;
DROP TABLE IF EXISTS park;

DROP SEQUENCE IF EXISTS reservation_reservation_id_seq;
DROP SEQUENCE IF EXISTS site_site_id_seq;
DROP SEQUENCE IF EXISTS campground_campground_id_seq;
DROP SEQUENCE IF EXISTS park_park_id_seq;

CREATE SEQUENCE park_park_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE park 
(
  park_id integer DEFAULT nextval('park_park_id_seq'::regclass) NOT NULL,
  name varchar(80) NOT NULL,          -- Name of the park
  location varchar(50) NOT NULL,      -- State name(s) where park is located
  establish_date date NOT NULL,       -- Date park was established
  area integer NOT NULL,              -- Area in acres
  visitors integer NOT NULL,          -- Latest recorded number of annual visitors
  description varchar(500) NOT NULL,  --
  CONSTRAINT pk_park_park_id PRIMARY KEY (park_id)
);


CREATE SEQUENCE campground_campground_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE campground 
(
  campground_id integer DEFAULT nextval('campground_campground_id_seq'::regclass) NOT NULL,
  park_id integer NOT NULL,               -- Parent park
  name varchar(80) NOT NULL,              -- Name of the campground
  open_from_mm varchar(2) NOT NULL,       -- Campground is open from month: 01=January, 02=February, ... 12=December
  open_to_mm varchar(4) NOT NULL,         -- Campground is open to month: 01=January, 02=February, ... 12=December
  daily_fee money NOT NULL,
  CONSTRAINT pk_campground_campground_id PRIMARY KEY (campground_id)
);

CREATE SEQUENCE site_site_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE site 
(
  site_id integer DEFAULT nextval('site_site_id_seq'::regclass) NOT NULL,
  campground_id integer NOT NULL,
  site_number integer NOT NULL,                   -- Site numbers are
  max_occupancy integer NOT NULL DEFAULT 6,       -- Sites are limited to 6 people, however some sites are "doubled" (12 people)
  accessible boolean NOT NULL DEFAULT FALSE,      -- Accessible site, reserved for campers with disabilities
  max_rv_length integer NOT NULL DEFAULT 0,       -- RVs/Trailers not permitted if length is 0
  utilities boolean NOT NULL DEFAULT FALSE,       -- Electricity, running water available.
  CONSTRAINT pk_site_site_number_campground_id PRIMARY KEY (site_id)
);

CREATE SEQUENCE reservation_reservation_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE reservation 
(
  reservation_id integer DEFAULT nextval('reservation_reservation_id_seq'::regclass) NOT NULL,
  site_id integer NOT NULL,
  name varChar(80) NOT NULL,
  from_date date NOT NULL,
  to_date date NOT NULL,
  create_date date NOT NULL DEFAULT now(),
  CONSTRAINT pk_reservation_reservation_id PRIMARY KEY (reservation_id)
);

-- add foreign keys
ALTER TABLE campground 
ADD FOREIGN KEY (park_id) REFERENCES park(park_id);

ALTER TABLE site 
ADD FOREIGN KEY (campground_id) REFERENCES campground(campground_id);

ALTER TABLE reservation 
ADD FOREIGN KEY (site_id) REFERENCES site(site_id);