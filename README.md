## Environment

Install Maven (3.8.6) and Java (11) via

[SDK Man](https://sdkman.io/install)

> sdk install java 11.0.16.1-tem

> sdk install maven 3.8.6

Switch Java in your shell

> sdk use java 11.0.16.1-tem

## Building and Running Spring Boot

> mvn clean install

> java -jar main/target/main-1.0.0-SNAPSHOT.jar

## Running Karate Automation

> cd karate-automation

> mvn clean install

* This will produce an HTML report that you can view to see the test results

> karate-automation/target/karate-reports/karate-summary.html

An example of the file in my local (copy paste the URL with the file protocol in your favourite browser)

```
Karate version: 1.4.0
======================================================
elapsed:   1.99 | threads:    2 | thread time: 1.42
features:     4 | skipped:    4 | efficiency: 0.36
scenarios:   20 | passed:    20 | failed: 0
======================================================

HTML report: (paste into browser to view) | Karate version: 1.4.0
file:///Users/juy/var/git/uy-jerwin1984/ls-jd-technical-challenge/karate-automation/target/karate-reports/karate-summary.html
```

## Solution Choices and Preview

* Given that there was no database specified in the challenge, I chose H2 in memory so that there will be less dependencies to install
* Author should be normalized but assumed text entry based on the screens hence not allowing us to check for permissions when another author tries to delete, update or create speeches on behalf of others
* Content, Author and Keyword search is not efficient (induces full table scan). SQL databases are not meant for this. ElasticSearch should be used instead but need to tackle Eventual Consistency
* Assumed basic pagination based on offset but did not provide the total record size based on the filter because this is inefficient
* Unit test is lack luster because there is no core domain logic to test - most are purely framework code
* Karate Automation gives more value than running integration test or unit test in this example

