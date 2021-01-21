-- connected to the POSTGRES database when you are creating another db
-- kill and db locks
SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'campground';

DROP DATABASE campground;

CREATE DATABASE campground;
