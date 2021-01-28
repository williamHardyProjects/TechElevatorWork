SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'campground';

DROP DATABASE campground;

CREATE DATABASE campground;