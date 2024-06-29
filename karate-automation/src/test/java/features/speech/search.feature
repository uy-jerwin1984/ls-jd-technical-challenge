Feature: Search Speech Utility

  Background:
    * url baseUrl

  @ignore
  Scenario: Search Speech
    * param author = karate.get('author', '');
    * param content = karate.get('content', '');
    * param keyword = karate.get('keyword', '');
    * param author_date = karate.get('author_date', '');

    Given path '/speeches'
    When method GET
