================================================================================
===        Spring PetClinic sample application - Database Configuration      ===
================================================================================

@author Costin Leau

--------------------------------------------------------------------------------

In its default configuration, Petclinic uses an in-memory database (HSQLDB) which
gets populated at startup with data. A similar setup is provided for Mysql in case
a persistent database configuration is needed.
Note that whenever the database type is changed, the jdbc.properties file needs to
be updated.

BJM 20150526 - This has been used for the room usage.  For simplicity the hsqldb has been completely
removed and the mysql is the database for the room usage application.