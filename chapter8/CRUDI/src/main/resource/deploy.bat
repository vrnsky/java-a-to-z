psql --username=postgres -f create_db.sql
psql --username=postgres -f create_table.sql
psql --username=postgres -f fill_tables.sql
psql \c