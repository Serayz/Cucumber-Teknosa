@Odev
Feature: Get
  Background:
    * url baseUrl

  Scenario: Odev Scenario
    Given params {s: 'Harry Potter'}
    When method get
    And print response
    * def getImdbID = $response.Search[?(@.Title=="Harry Potter and the Sorcerer's Stone")].imdbID
    * print getImdbID
    * params {i: #(getImdbID)}
    * method get
    * print response
    Then status 200
    *  match response.Title == "Harry Potter and the Sorcerer's Stone"
    * match response.Year == "2001"
    * match response.imdbID == "tt0241527"
    * match response.Released == "16 Nov 2001"