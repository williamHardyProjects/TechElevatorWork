
export PGPASSWORD='postgres1'

psql -U postgres -f "./create_database.sql" &&
psql -U postgres -d user-manager -f "./user-manager.sql" 