
<?php

/**

d888b  db    db d88888b .d8888. d888888b   d8888b.  .d88b.   .d88b.  db   dD
88' Y8b 88    88 88'     88'  YP `~~88~~'   88  `8D .8P  Y8. .8P  Y8. 88 ,8P'
88      88    88 88ooooo `8bo.      88      88oooY' 88    88 88    88 88,8P
88  ooo 88    88 88~~~~~   `Y8b.    88      88~~~b. 88    88 88    88 88`8b
88. ~8~ 88b  d88 88.     db   8D    88      88   8D `8b  d8' `8b  d8' 88 `88.
Y888P  ~Y8888P' Y88888P `8888Y'    YP      Y8888P'  `Y88P'   `Y88P'  YP   YD


Program name:       Assignment 2 - Guest Book
Author:             Christopher Sigouin
Version:            1.0
Description:        A guest book  web application with user registration and authentication
Dependencies:       See README
Database file:      db/database.sql
Change History:     2015.10.03 Original version by CJS

 */

/**
 * Class DBConnection
 *
 * Static
 *      This class is used to create a connection to the DB as well as closing the connection.
 *      Does not require to be instantiated.
 *
 */

class DBConnection
{
    private static $connection;

    /**
     *  Returns a PDO object for a connection to the database
     *
     * @return PDO
     *
     */
    public static function getConnection()
    {
        // Credentials for the DB
        require(UTIL_DB_CREDS);

        // Only complete if the connection does not exist
        if (self::$connection === null) {
            try {
                // Create the DB connection
                self::$connection = new PDO($dsn, $user, $pass);
                # Fires exceptions.  Use try/catch with this
                self::$connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            } catch(PDOException $e) {
                    echo $e->getMessage();
                    die();
            }
        }
        return self::$connection;
    }
}