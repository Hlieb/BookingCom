Feature: Search on Booking.com

  Scenario Outline: Search by city criteria
    Given User is looking for hotels in '<City>' city
    When User search
    Then Hotel '<Hotel>' should be on the first page
    And '<Hotel>' score should be '<Rating>'
    Examples:
      | City     | Hotel                               | Rating |
      | Minsk    | Hampton by Hilton Minsk City Centre | 8,9    |
      | Brest    | Hampton by Hilton Brest             | 9,3    |
      | Wroclaw  | 30th+ Floor Apartments in Sky Tower | 8,8    |


#  Scenario Outline: Search by different city criteria
#    Given User is looking for hotels in '<City>' city
#    When User search
#    Then Hotel '<Hotel>' should be on the first page
#    And Its rate should be '<Rate>'
#    Examples:
#      | City  | Hotel                                     | Rate
#      | Minsk | Hampton by Hilton Minsk City Centre       | 8.9
#      | Brest | Hampton by Hilton Brest                   | 9.3

