Feature: Update Speech

  Background:
    * url baseUrl

    * def create_speech_param = {}
    * create_speech_param.author = dataUtils.uuid();
    * create_speech_param.content = dataUtils.uuid();
    * create_speech_param.keyword = dataUtils.uuid();
    * create_speech_param.author_date = dataUtils.instant();

    * def create_speech_result = call read('classpath:/features/speech/create.feature') create_speech_param
    * assert create_speech_result.responseStatus === 201

  Scenario: Update Speech

    * def update_speech_param = {}
    * update_speech_param.id = create_speech_result.response.data.id
    * update_speech_param.author = dataUtils.uuid();
    * update_speech_param.content = dataUtils.uuid();
    * update_speech_param.keyword = dataUtils.uuid();
    * update_speech_param.author_date = dataUtils.instant();

    * def update_speech_result = call read('classpath:/features/speech/update.feature') update_speech_param
    * assert update_speech_result.responseStatus === 200

    * def update_speech_result_data = update_speech_result.response.data
    * assert update_speech_param.author === update_speech_result_data.author
    * assert update_speech_param.content === update_speech_result_data.content
    * assert update_speech_param.keyword === update_speech_result_data.keyword
    * assert update_speech_param.author_date === update_speech_result_data.author_date

  Scenario: Update Speech without author
    * def update_speech_param = {}
    * update_speech_param.id = create_speech_result.response.data.id
    * update_speech_param.content = dataUtils.uuid();
    * update_speech_param.keyword = dataUtils.uuid();
    * update_speech_param.author_date = dataUtils.instant();

    * def update_speech_result = call read('classpath:/features/speech/update.feature') update_speech_param
    * assert update_speech_result.responseStatus === 400

  Scenario: Update Speech without content
    * def update_speech_param = {}
    * update_speech_param.id = create_speech_result.response.data.id
    * update_speech_param.author = dataUtils.uuid();
    * update_speech_param.keyword = dataUtils.uuid();
    * update_speech_param.author_date = dataUtils.instant();

    * def update_speech_result = call read('classpath:/features/speech/update.feature') update_speech_param
    * assert update_speech_result.responseStatus === 400

  Scenario: Update Speech without keyword
    * def update_speech_param = {}
    * update_speech_param.id = create_speech_result.response.data.id
    * update_speech_param.author = dataUtils.uuid();
    * update_speech_param.content = dataUtils.uuid();
    * update_speech_param.author_date = dataUtils.instant();

    * def update_speech_result = call read('classpath:/features/speech/update.feature') update_speech_param
    * assert update_speech_result.responseStatus === 400

  Scenario: Update Speech without author date
    * def update_speech_param = {}
    * update_speech_param.id = create_speech_result.response.data.id
    * update_speech_param.content = dataUtils.uuid();
    * update_speech_param.keyword = dataUtils.uuid();
    * update_speech_param.author = dataUtils.uuid();

    * def update_speech_result = call read('classpath:/features/speech/update.feature') update_speech_param
    * assert update_speech_result.responseStatus === 400





