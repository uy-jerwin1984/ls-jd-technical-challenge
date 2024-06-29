Feature: Create Speech

  Background:
    * url baseUrl

  Scenario: Create Speech
    * def create_speech_param = {}
    * create_speech_param.author = dataUtils.uuid();
    * create_speech_param.content = dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 201

    * def get_speech_param = {}
    * get_speech_param.id = create_speech_result.response.data.id
    * print get_speech_param
    * def get_speech_result = call read('classpath:/features/speech/get.feature') get_speech_param
    * assert get_speech_result.responseStatus === 200

    * assert create_speech_param.author === get_speech_result.response.data.author
    * assert create_speech_param.content === get_speech_result.response.data.content
    * assert create_speech_param.keyword === get_speech_result.response.data.keyword
    * assert create_speech_param.author_date === get_speech_result.response.data.author_date

  Scenario: Create Speech by passing id
    * def id = dataUtils.uuid();
    * def author = dataUtils.uuid();
    * def content = dataUtils.uuid();
    * def keyword = dataUtils.uuid();
    * def author_date = dataUtils.instant();
    * def body = read('classpath:/features/speech/create.json')

    Given path '/speeches'
    And request body
    When method POST
    Then status 201

  Scenario: Create Speech without author
    * def create_speech_param = {}
    * create_speech_param.content = dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 400
    * assert create_speech_result.response.errors.length === 1
    * assert create_speech_result.response.errors[0].code === 'data.author'

  Scenario: Create Speech without keyword
    * def create_speech_param = {}
    * create_speech_param.content = dataUtils.uuid();
    * create_speech_param.author = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 400
    * assert create_speech_result.response.errors.length === 1
    * assert create_speech_result.response.errors[0].code === 'data.keyword'

  Scenario: Create Speech without author date
    * def create_speech_param = {}
    * create_speech_param.content = dataUtils.uuid();
    * create_speech_param.author = dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 400
    * assert create_speech_result.response.errors.length === 1
    * assert create_speech_result.response.errors[0].code === 'data.authorDate'

  Scenario: Create Speech without content
    * def create_speech_param = {}
    * create_speech_param.author = dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 400
    * assert create_speech_result.response.errors.length === 1
    * assert create_speech_result.response.errors[0].code === 'data.content'

