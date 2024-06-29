Feature: Create Speech Utility

  Background:
    * url baseUrl

  @ignore
  Scenario: Create Speech
    * def author = karate.get('author', '');
    * def keyword = karate.get('keyword', '');
    * def author_date = karate.get('author_date', '');
    * def body = read('classpath:/features/speech/speech.json')

    Given path '/speeches'
    And request body
    When method POST
