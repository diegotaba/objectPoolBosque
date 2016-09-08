#!/bin/bash

echo "deb http://apt.postgresql.org/pub/repos/apt/ trusty-pgdg main" > pgdg.list
sudo mv pgdg.list /etc/apt/sources.list.d/
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | \
  sudo apt-key add -
sudo apt-get update
sudo apt-get -y install postgresql-9.4
sudo su postgres << EOF
 cd ~
 /usr/lib/postgresql/9.4/bin/psql -c "CREATE USER swii WITH PASSWORD 'swii'"
 echo "Creando base de datos swii"
 /usr/lib/postgresql/9.4/bin/createdb swii -O swii
 sed -i "s/#listen_addresses = 'localhost'/listen_addresses = '*'/" /etc/postgresql/9.4/main/postgresql.conf
 sed -i "s/127.0.0.1\/32/0.0.0.0\/0/" /etc/postgresql/9.4/main/pg_hba.conf
 psql -c "ALTER ROLE swii CONNECTION LIMIT 5"
 psql -c "CREATE TABLE data (dato character varying(200)) WITH ( OIDS=FALSE );"
 pg_ctlcluster 9.4 main restart
EOF