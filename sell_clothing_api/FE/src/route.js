var myApp = angular.module("myApp",["ngRoute"]);
// chuyen trang
myApp.config(function ($routeProvider, $locationProvider) {
  // xoa khoang trang trinh duyet
  $locationProvider.hashPrefix("");
  // $routeProvider : chuyen trang
  $routeProvider
    .when("/trang-chu", {
      templateUrl: "../tables.html",
      controller :  tablesController, 
    })
    .when("/form", {
      templateUrl: "../form-add.html",
      controller :  formCRUD, 
    })
    .when("/form-update", {
      // lam gi thi lam
      // noi dung cua trang chu
      templateUrl: "../form-update.html",
       controller: FormUpdateController,
    })
    .otherwise({
      redirectTo: "/trang-chu",
    });
});