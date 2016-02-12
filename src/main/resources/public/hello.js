/**
 * Created by zais on 9/15/2015.
 */
function Hello($scope, $http) {
    $http.get('http://localhost:8080/greeting').
        success(function(data) {
            $scope.greeting = data;
        });
}
