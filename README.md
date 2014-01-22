turbine-data-loader
===================

A turbine data loader written in clojure


Getting Started
---------------

Compile

    $ lein compile

Run

    $ lein run <conf.json> <optional input file>

Package (Create Jar)

    $ lein uberjar


Running
-------

Provides two alternate modes

Input file (Loads data via input file)

    $ java -jar data-loader.jar <conf.json> <input.json>

Stdin (Loads data via standard in

    $ java -jar data-loader.jar <conf.json>)


Configuration
-------------

```
    {
        "turbine-base": "http://localhost:8080",
        "database": "mydb",
        "collection": "mycoll"
    }
```

Input
-----

All input (via file or stdin) is a list of json events delimited by a newline '\n'