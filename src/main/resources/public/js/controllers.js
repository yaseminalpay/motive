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
    .controller('ItemCreateController',
         function($scope, $state, $stateParams, Item) {
            $scope.item = new Item();

            $scope.addQuery = function() {
                $scope.item.$save(function() {
                    $state.go('items');
                });
            };
        });