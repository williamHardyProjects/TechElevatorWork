SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'project_manager';

DROP DATABASE project_manager;