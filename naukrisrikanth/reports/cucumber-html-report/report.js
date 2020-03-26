$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/naukritestcase.feature");
formatter.feature({
  "line": 2,
  "name": "naukri website",
  "description": "",
  "id": "naukri-website",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@naukri_Feature"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "check that the user can login naukri account",
  "description": "",
  "id": "naukri-website;check-that-the-user-can-login-naukri-account",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@tc01_login"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "user launched the chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user opens naukri homepage",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user clicks login",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});