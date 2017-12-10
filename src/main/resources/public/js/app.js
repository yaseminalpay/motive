(function() {
	var app = angular.module('app', ['ui.router', 'navController', 'ngAnimate', 'ui.bootstrap', 'ngResource', 'app.controllers', 'app.services'])

	// define for requirejs loaded modules
	define('app', [], function() { return app; });

	// function for dynamic load with requirejs of a javascript module for use with a view
	// in the state definition call add property `resolve: req('/views/ui.js')`
	// or `resolve: req(['/views/ui.js'])`
	// or `resolve: req('views/ui')`
	function req(deps) {
		if (typeof deps === 'string') deps = [deps];
		return {
			deps: function ($q, $rootScope) {
				var deferred = $q.defer();
				require(deps, function() {
					$rootScope.$apply(function () {
						deferred.resolve();
					});
					deferred.resolve();
				});
				return deferred.promise;
			}
		}
	}

	app.config(function($stateProvider, $urlRouterProvider, $controllerProvider){
		var origController = app.controller
		app.controller = function (name, constructor){
			$controllerProvider.register(name, constructor);
			return origController.apply(this, arguments);
		}

		var viewsPrefix = 'views/';

		// For any unmatched url, send to /
		$urlRouterProvider.otherwise("/")

		$stateProvider
			// you can set this to no template if you just want to use the html in the page
		.state('home', {
				url: "/",
				templateUrl: viewsPrefix + "home.html",
				controller:'InterestGetController',
				data: {
					pageTitle: 'Home'
				}
		}).state('queries',{
            url:'/queries',
            templateUrl: viewsPrefix + 'queries.html',
            controller:'QueryListController',
            data: {
                pageTitle: 'Saved Queries'
            }
        }).state('newQuery',{
            url:'/queries/new',
            templateUrl: viewsPrefix + 'query-add.html',
            controller:'QueryCreateController'
        }).state('viewQuery',{
            url:'/queries/:id/view',
            templateUrl: viewsPrefix + 'query-view.html',
            controller:'QueryViewController'
        }).state('editQuery',{
            url:'/queries/:id/edit',
            templateUrl: viewsPrefix + 'query-edit.html',
            controller:'QueryEditController'
        }).state('deleteQuery',{
            url:'/queries/:id/delete',
            templateUrl: viewsPrefix + 'queries.html',
            controller:'QueryDeleteController'
        }).state('tweets', {
            url: "/tweets",
            templateUrl: viewsPrefix + "tweets.html",
            data: {
                pageTitle: 'Saved Tweets'
            }
        }).state('contents', {
        	url:'/contents/:interestId',
        	templateUrl: viewsPrefix + 'home.html',
            controller:'GetContentsByInterestController'
        }).state('search', {
        	url:'/search/:queryString',
        	templateUrl: viewsPrefix + 'home.html',
            controller:'TweetSearchController'
        })
	})
	.directive('updateTitle', ['$rootScope', '$timeout',
		function($rootScope, $timeout) {
			return {
				link: function(scope, element) {
					var listener = function(event, toState) {
						var title = 'Project Name';
						if (toState.data && toState.data.pageTitle) title = toState.data.pageTitle + ' - ' + title;
						$timeout(function() {
							element.text(title);
						}, 0, false);
					};

					$rootScope.$on('$stateChangeSuccess', listener);
				}
			};
		}
	]);
}());