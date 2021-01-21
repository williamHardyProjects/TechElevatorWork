export PGPASSWORD='postgres1'

# drop and create campground database (connect to postgres db for this)
psql -U postgres -d postgres -f "./create_campground_database.sql"

# create the tables and other schema
psql -U postgres -d campground -f "./create_campground_tables.sql"

# create the tables and other schema
psql -U postgres -d campground -f "./insert_campground_data.sql"
