# Quotes - README #

Project created as a coding assignment.

### Preparing the environment ###

#### Checking out repository ####

* Type in terminal: git clone https://github.com/Hladeo/quotes.git

#### Running application ####

* In terminal, go to the quotes module
* Type in terminal: gradlew build
* In IntelliJ: run as SpringBoot application
* After successful starting, application will be available here: http://localhost:8080

#### Available REST endpoints ####

* Fetching random quote (GET): http://localhost:8080/
* Adding like to the selected quote (PATCH): http://localhost:8080/like/{quote_id}

#### Available GraphQL queries ####

* Fetching random quote:

````graphql
query {
  fetchRandomQuote {
    quote,
    author
  }
}
````

* Adding like to the selected quote:

````graphql
mutation {
  addLikeToQuote(id: {quote_id}) {
    quote
    author
    likes
  }
}
````

#### Running jUnit and Integration tests ####

* In terminal, go to the quotes module
* Type in terminal: gradlew test
* In IntelliJ: in Project tree go to: quotes/src/test
* Right click on test directory and choose: Run 'All Tests'