Feature:Google Search UI
  Testing the UI of https://www.google.com

  Background:
   Given browser opens successfully
   And www.google.com is accessed

  Scenario: Verifying logo, search box are displayed and Language is in Arabic format with keyboard and mic icons displayed
    Given browser navigates to Google's homepage
    Then Company's logo is displayed
    And Company's search box is displayed
    And Language is in arabic
    And Menu is located on the left
    Then verify keyboard icon is located and clickable
    Then verify Mic icon is displayed
    Then verify that virtual keyboard opened in arabic format with clickable buttons
    Then click on english option
    Then Menu is located on the right


  Scenario Outline: Alphanumeric data can be entered in the search box and autosuggestions appears and verify search button is clickable
    When user enters "<data>" to search box
    Then auto suggestions appears
    Then Verify URI contains "<keyword>"
    And verify time taken to fetch data and total number of results are displayed
    When user clicks on first link
    Then user is navigated to the desired location

    Examples:
      | data | keyword  |
      | fac  | facebook |

  Scenario: Verifying the mic icon is working
    Given language is in english
    When user clicks on mic icon
    Then search by voice window is displayed
    And verify listening action started and message is displayed

  Scenario Outline: Validating the I'm feeling lucky button is clickable
    Given language is in english
    When user enters "<data>" to search box
    Then press on the I'm feeling lucky button
    Then user is transferred to the first link of the searched keyword

    Examples:
      | data    |
      | youtube |

  Scenario Outline: Testing the pagination tab
    Given language is in english
    When user enters "<data>" to search box
    Then press on the search button
    Then a pagination tab should be displayed in the results
    When user clicks on next button
    Then the next page is displayed
    When user clicks on Google's logo
    Then user is directed back to Google's homepage

    Examples:
      | data      |
      | barcelona |

  Scenario Outline: Testing the image link and search UI
    Given language is in english
    When user clicks on image link
    Then image icon is displayed in the search box
    When user enters "<data>" to search box
    Then user press enter key
    Then search result with multiple images is displayed
    And a filter menu is displayed

    Examples:
      | data  |
      | Egypt |

