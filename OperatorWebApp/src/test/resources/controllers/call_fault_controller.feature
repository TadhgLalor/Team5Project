Feature: CallFaultController API tests

  Background:
    * url 'http://localhost:8081/api'

  Scenario: Test API endpoint access
    Given path ''
    When method get
    Then status 200
    And match response == 'API Team5 endpoint accessed successfully!'

  Scenario: Test API2 endpoint access
    Given path 'api2'
    When method get
    Then status 200
    And match response == 'API Team5 endpoint 2 accessed successfully!'

  Scenario: Get all call faults
    Given path 'failures'
    When method get
    Then status 200
    And match response contains []

  Scenario: Get failures by customer
    Given path 'failures/customer/1'
    When method get
    Then status 200
    And match response contains []

  Scenario: Get failures by node
    Given path 'failures/node/1'
    When method get
    Then status 200
    And match response contains []

  Scenario: Get total failures
    Given path 'total-failures'
    When method get
    Then status 200
    And match response == []

  Scenario: Get failures by customer and timestamp
    Given path 'failures/customer/1/timestamp/2023-01-01 12:00:00'
    When method get
    Then status 200
    And match response contains []

  Scenario: Get failures by node and timestamp
    Given path 'failures/node/1/timestamp/2023-01-01 12:00:00'
    When method get
    Then status 200
    And match response contains []

  Scenario: Get failures by fault reason
    Given path 'failures/reason/HANDOVER_FAILED'
    When method get
    Then status 200
    And match response contains []
