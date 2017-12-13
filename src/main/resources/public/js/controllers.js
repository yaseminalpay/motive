angular.module('app.controllers', [])
    .controller('InterestGetController',
        function($scope, $stateParams, Interest) {
            $scope.savedInterests = Interest.query();
        })
    .controller('GetContentsByInterestController',
        function($scope, $stateParams, Content, Interest) {
            $scope.savedContents = Content.query({
                interestId: $stateParams.interestId
            });
            $scope.savedInterests = Interest.query();
        })
    .controller('ContentViewController',
        function($scope, $stateParams, Content) {
            $scope.content = Content.get({
                id : $stateParams.id
            });
        })
    .controller('ContentCreateController',
         function($scope, $state, $stateParams, Content) {
             $scope.content = new Content();
            $scope.addContent = function() {
                $scope.content.$save();
            };
        });