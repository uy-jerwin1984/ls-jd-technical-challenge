function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'local';
  }
  var config = {};

  if (env == 'local') {
    config.baseUrl = "http://localhost:8080";
  }

  config.dataUtils = Java.type('com.ph.juy.ls.automation.DataUtils');
  return config;
}