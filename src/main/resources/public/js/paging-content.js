var pagingcontent = angular.module('paging-content', ['ui.bootstrap']);

pagingcontent.controller('PagingContentController', function($scope) {
    $scope.filteredContents = []
        ,$scope.currentPage = 1
        ,$scope.numPerPage = 8
        ,$scope.maxSize = 5;

    $scope.makeTodos = function() {
        $scope.currentPage = 2;
    };
    $scope.makeTodos();


    $scope.$watch('currentPage + numPerPage', function() {
        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
            , end = begin + $scope.numPerPage;
        $scope.filteredContents = $scope.savedContents.slice(begin, end);
    });
});

