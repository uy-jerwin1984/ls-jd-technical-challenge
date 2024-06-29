Feature: Update Speech Utility

  Background:
    * url baseUrl

  @ignore
  Scenario: Update Speech
    * def id = karate.get('id', '');
    * def author = karate.get('author', '');
    * def content = karate.get('content', '');
    * def keyword = karate.get('keyword', '');
    * def author_date = karate.get('author_date', '');
    * def body = read('classpath:/features/speech/update.json')

    Given path '/speeches'
    And request body
    When method PUT
