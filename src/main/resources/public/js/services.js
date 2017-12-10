angular.module('app.services', [])
.factory('Shipwreck', function($resource) {
  return $resource('/api/v1/shipwrecks/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
})
.factory('Query', function($resource) {
    return $resource('/api/v1/queries/:id', { id: '@id' }, {
        update: {
            method: 'PUT'
        }
    });
})
.factory('Interest', function($resource) {
    return $resource('/api/v1/interests/:queryString', { queryString: '' });
})
.factory('SearchedTweet', function($resource) {
    return $resource('/api/v1/search/:queryString', { queryString: '@queryString' });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});