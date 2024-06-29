Feature: Create Speech

  Background:
    * url baseUrl

  Scenario: Create Speech
    * def id = dataUtils.uuid();
    * def body = read('classpath:/features/speech/speech.json')

    Given path '/speeches'
    And request body
    When method POST
    Then status 201
    * print response.data
    * def data = response.data
