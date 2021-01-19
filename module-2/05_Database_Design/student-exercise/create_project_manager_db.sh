export PGPASSWORD='postgres1'

psql -U postgres -f "./dropdb.sql" &&
createdb -U postgres project_manager &&
psql -U postgres -d project_manager -f "./project_manager.sql" 