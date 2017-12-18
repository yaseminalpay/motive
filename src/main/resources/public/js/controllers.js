angular.module('app.controllers', [])
    .controller('InterestGetController',
        function ($scope, $stateParams, Interest, Content) {
            $scope.savedInterests = Interest.query();
            $scope.savedContents = Content.query({
                interestId: ''
            });
        })
    .controller('GetContentsByInterestController',
        function ($scope, $stateParams, Content, ContentByInterest) {
            $scope.savedContents = ContentByInterest.query({
                interestId: $stateParams.interestId
            });
            $scope.savedInterests = ContentByInterest.query();

            //getting the id of selected interest for later use with jquery
            $("#divForInterests a").click(
                $("#selectedInterest").text($stateParams.interestId)
            );
        })
    .controller('ContentViewController',
        function ($scope, $stateParams, Content, $http, $compile) {
           
            $scope.content = Content.get({
                id: $stateParams.id
            });
            
            console.log("content",  $scope.content);
            
             $scope.addComment = function (comment) {
                $http.put('/api/v1/contents/' + $stateParams.id + '/comment', comment);
                var myEl = angular.element( document.querySelector( '#div-for-new-comment' ) );
                var html = "<div class=\"card\">" +
								"<div class=\"card-block\">" + 
									"<p class=\"card-text\">" + comment + "</p>" +
								"</div>" +
							"</div>";
							
     			myEl.append(html);
            };
        })
     .controller('InterestCreateController',
        function ($scope, $state, $stateParams, $http, Interest) {
        	$scope.interest = new Interest();
            $scope.addInterest = function () {
            	$scope.interest.properties = [];
                $scope.interest.$save();
            };
        })
    .controller('ContentCreateController',
        function ($scope, $state, $sce, $stateParams, Content, InterestProperties) {
            
            $scope.content = new Content();

            //setting the interest id of create content form
            var selected = $("#selectedInterest").text();
            $scope.content.interestId = selected;

            //generating interest-custom fields
            $scope.interestProperties = InterestProperties.query({
                id: selected
            });

			$scope.values = new Array($scope.interestProperties.length);

            $scope.addContent = function () {
            	$scope.content.customProperties = [];
			    for (i = 0; i < $scope.interestProperties.length; i++) {
			      $scope.content.customProperties.push({
			        value: $scope.values[i],
			        name: $scope.interestProperties[i].name,
			        type: $scope.interestProperties[i].type,
			        description: $scope.interestProperties[i].description
			      });
			    }
			    
                $scope.content.$save();
            };
            
        })
    ;