Turbine Data Loader
===================

A data loader for [TurbineDB](https://github.com/sparcedge/turbinedb) written in [Clojure](http://clojure.org/).


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


License
-------

This project is Copyright (c) 2015 [SPARC](https://github.com/sparcedge/) and open sourced under the [MIT License](LICENSE.md).
