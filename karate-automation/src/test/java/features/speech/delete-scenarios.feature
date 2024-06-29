Feature: Delete Speech

  Background:
    * url baseUrl

  Scenario: Delete Speech
    * def create_speech_param = {}
    * create_speech_param.author = dataUtils.uuid();
    * create_speech_param.content = dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 201

    Given path '/speeches/' + create_speech_result.response.data.id
    When method DELETE
    Then status 200

    * def get_speech_param = {}
    * get_speech_param.id = create_speech_result.response.data.id
    * print get_speech_param
    * def get_speech_result = call read('classpath:/features/speech/get.feature') get_speech_param
    * assert get_speech_result.responseStatus === 400

  Scenario: Delete Speech with random id
    Given path '/speeches/' + dataUtils.uuid();
    When method DELETE
    Then status 400
