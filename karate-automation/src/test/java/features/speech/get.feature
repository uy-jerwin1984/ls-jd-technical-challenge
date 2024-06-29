Feature: Get Speech Utility

  Background:
    * url baseUrl

  @ignore
  Scenario: Get Speech
    * def id = karate.get('id', '');

    Given path '/speeches/' + id
    When method GET
