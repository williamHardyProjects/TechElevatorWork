#!/bin/bash

export PGPASSWORD='postgres1'

psql -U postgres -d postgres -f './drop_campground_db.sql' &&
psql -U postgres -d campground -f './campground.sql'
