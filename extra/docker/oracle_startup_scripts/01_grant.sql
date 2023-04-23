connect sys/123@XEPDB1 as sysdba;

GRANT create session TO pdbadmin;
GRANT create table TO pdbadmin;
GRANT create any procedure TO pdbadmin;
GRANT create sequence TO pdbadmin;

GRANT UNLIMITED TABLESPACE TO pdbadmin;