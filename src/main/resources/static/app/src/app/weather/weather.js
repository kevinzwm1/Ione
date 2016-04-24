angular.module('IOne-Weather', []);
angular.module('IOne-Weather').config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/weather', {
        controller: 'WeatherController',
        templateUrl: 'app/src/app/weather/weather.html'
    })
}]);


angular.module('IOne-Weather').controller('WeatherController', function ($scope,CityService, Constant, OpenWeatherService) {
    $scope.cityChangeHandler = function (cityId) {
       OpenWeatherService.get(cityId).success(function (data) {
             $scope.selectItem = data;
             $scope.selectItem.date = new Date();
       }).error(function(response) {
           $scope.showError("Service is not available");
       });
    };

    $scope.refreshList = function () {
        CityService.getAll().success(function (data) {
            $scope.allCities = data;
        });
    };

    $scope.refreshList();

    $scope.showInfo = function(info) {
        toastr["success"](info)
    };

    $scope.showError = function(info) {
        toastr["error"](info)
    };

    $scope.showWarn = function(info) {
        toastr["warning"](info)
    };
});




