angular.module('IOne-Weather').service('OpenWeatherService', function($http,Constant) {
    this.get = function(id) {
        var url = '/weather?APPID='+ Constant.APPID;
        if(id !== undefined && id !== null) {
             url = url + '&id=' + id;
        }
        return $http.get(Constant.OPEN_WEATHER_BACKEND_BASE + url);
    };
});
