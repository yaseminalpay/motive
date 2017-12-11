angular.module('navController', [])
	.controller('nav', function($scope, $state) {
		$scope.title = 'Motive';
		$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
		};
		$scope.pages = [
			{
				name: 'Home',
				url: '#/'
			},
			{
                name: 'Profile',
                url: '#/queries'
            },
            {
                name: 'Notifications',
                url: '#/tweets'
            }
		]
	});