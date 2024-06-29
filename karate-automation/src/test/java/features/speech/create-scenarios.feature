Feature: Create Speech

  Background:
    * url baseUrl

  Scenario: Create Speech
    * def create_speech_param = {}
    * create_speech_param.author = dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 201

  Scenario: Create Speech without author
    * def create_speech_param = {}
    * create_speech_param.keyword = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 401

