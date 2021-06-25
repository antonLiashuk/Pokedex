# Pokedex
                                                API documentation 
Database that I use in the program is h2 in the in-memory mode.<br />
To get the h2 console (UI Database Management System, DBMS) just type: <br />
``localhost:8080/h2-console``.<br />
Every endpoint that operates on certain http request is written in the <br />
``PokemonController.java`` <br />

URL:

1. ``localhost:8080/api/pokemon`` <br />
is the default endpoint, which allows us to send POST http request.<br />
By doing this, we can easily add a Pokemon to a database, and if we do this properly, the http response will be 200 (OK), otherwise we will get a 400 code(BAD REQUEST).
To perform this we need to pass a body of the Pokemon using Json (Personally I prefer to use postman in order to do this).
2. ``localhost:8080/api/pokemon/all`` <br />
is an endpoint that returns us a Json representation of the list of the Pokemon objects, that are currently in our database.
No additional arguments are needed.
3. ``localhost:8080/api/pokemon/id/{id}`` GET http request does search in the database for the Pokemon object with the id value, as passed in the url path.
4. ``localhost:8080/api/pokemon/name/{name}`` GET http request does search in the database for the Pokemon object with the name value, as passed in the url path.
5. ``localhost:8080/api/pokemon/type/{type}`` GET http request does search in the database for the all Pokemon objects with the same type value, as passed in the url path.
6. ``localhost:8080/api/pokemon/delete/{id}`` DELETE http request, which deletes the Pokemon with the same value of id as passed in argument.
7.  ``localhost:8080/api/pokemon/delete/all`` DELETE http request, which deletes all the Pokemons from the database.
8.  ``localhost:8080/api/pokemon/edit/{id}`` endpoint that performs PUT http request, takes an id value in the path of the URL and also a boy of the new Pokemon object that we need to change, then updates the chosen Pokemon with the same id value as typed in the URL path, and change it to the Pokemon that we typed as a Json.
