angular.module('app.controllers', [])
    .controller('InterestGetController',
        function ($scope, $stateParams, Interest) {
            $scope.savedInterests = Interest.query();
        })
    .controller('GetContentsByInterestController',
        function ($scope, $stateParams, Content, Interest) {
            $scope.savedContents = Content.query({
                interestId: $stateParams.interestId
            });
            $scope.savedInterests = Interest.query();

            //getting the id of selected interest for later use with jquery
            $("#divForInterests a").click(
                $("#selectedInterest").text($stateParams.interestId)
            );
        })
    .controller('ContentViewController',
        function ($scope, $stateParams, Content) {
            $scope.content = Content.get({
                id: $stateParams.id
            });
        })
    .controller('ContentCreateController',
        function ($scope, $state, $stateParams, Content) {
            $scope.content = new Content();
            //setting the interest id of create content form
            var selected = $("#selectedInterest").text();
            $scope.content.interestId = selected;
            $scope.addContent = function () {
                $scope.content.$save();
            };


        });