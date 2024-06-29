Feature: Create Speech

  Background:
    * url baseUrl

    * def create_speech_param = {}
    * create_speech_param.author = dataUtils.uuid() + " " + dataUtils.uuid();
    * create_speech_param.content = dataUtils.uuid() + '|' + dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid() + ',' + dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant_plus_days(5);

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 201

  Scenario: Search Speech Author Exact
    * def search_speech_param = {}
    * search_speech_param.author = create_speech_param.author

    * def search_speech_result = call read('classpath:/features/speech/search.feature') search_speech_param
    * assert search_speech_result.response.items.length === 1

  Scenario: Search Speech Author Substring
    * def search_speech_param = {}
    * search_speech_param.author = create_speech_param.author.substring(0, 5)

    * def search_speech_result = call read('classpath:/features/speech/search.feature') search_speech_param
    * assert search_speech_result.response.items.length === 1

  Scenario: Search Speech Content
    * def search_speech_param = {}
    * search_speech_param.content = create_speech_param.content

    * def search_speech_result = call read('classpath:/features/speech/search.feature') search_speech_param
    * assert search_speech_result.response.items.length === 1

  Scenario: Search Speech Content Substring
    * def search_speech_param = {}
    * search_speech_param.content = create_speech_param.content.substring(0, 5)

    * def search_speech_result = call read('classpath:/features/speech/search.feature') search_speech_param
    * assert search_speech_result.response.items.length === 1

  Scenario: Search Speech Keyword
    * def search_speech_param = {}
    * search_speech_param.keyword = create_speech_param.keyword

    * def search_speech_result = call read('classpath:/features/speech/search.feature') search_speech_param
    * assert search_speech_result.response.items.length === 1

  Scenario: Search Speech Keyword Substring
    * def search_speech_param = {}
    * search_speech_param.keyword = create_speech_param.keyword.substring(0, 5)

    * def search_speech_result = call read('classpath:/features/speech/search.feature') search_speech_param
    * assert search_speech_result.response.items.length === 1

  Scenario: Search Speech Author Date
    * def create_speech_param_2 = {}
    * create_speech_param_2.author = dataUtils.uuid() + " " + dataUtils.uuid();
    * create_speech_param_2.content = dataUtils.uuid() + '|' + dataUtils.uuid();
    * create_speech_param_2.keyword = dataUtils.uuid() + ',' + dataUtils.uuid();
    * create_speech_param_2.author_date = dataUtils.instant_plus_days(10);

    * def create_speech_result_2 = call read('classpath:/features/speech/create.feature') create_speech_param_2
    * assert create_speech_result_2.responseStatus === 201

    * def search_speech_param_2 = {}
    * search_speech_param_2.author_date = create_speech_param_2.author_date

    * def search_speech_result_2 = call read('classpath:/features/speech/search.feature') search_speech_param_2
    * assert search_speech_result_2.response.items.length !== 0