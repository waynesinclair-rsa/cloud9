Feature: Should be able to add and delete comments

  Scenario: Adding a comment
  Given A local blog
   When I post a add request with postid 55 and body "New comment for Post ID 55"
    Then The response should be 201


  Scenario: Deleting a comment
    Given A local blog
    When I post a delete request for id 14
    Then The response should be 200




