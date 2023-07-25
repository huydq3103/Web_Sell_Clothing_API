window.tablesController = function ($scope,$location,$http) {
  $scope.listProducts = [];
  $scope.viTriUpdate = -1;

  let url = "http://localhost:8080/clothing-store";
  let api = url + "/hien-thi";




  $scope.pageNo = 0;

  $scope.hienThi = function (pageNo) {
    let apiUrl = api + "?pageNo=" + pageNo;
    $http.get(apiUrl).then(
      function (response) {
        // Kiểm tra dữ liệu có được in ra không
        $scope.listProducts = response.data;
        console.log(response.data);
      },
      function (error) {
        console.log(error);
      }
    );
  };

  $scope.PageNo = function (pageNo) {
    $scope.pageNo = pageNo;
    $scope.hienThi(pageNo); // Truyền giá trị pageNo vào hàm hienThi
  };

  // Gọi hàm hienThi() để lấy dữ liệu ban đầu
  $scope.hienThi($scope.pageNo);

  //delete data 

  $scope.removeProduct = function(event,index){
     event.preventDefault();

     let product = $scope.listProducts[index];
     let productId = product.maSanPham;
     let api = url + "/delete/"+productId;

     $http.delete(api).then(function(){
      $scope.listProducts.splice(index, 1);
      alert("xoa thanh cong");    
     }).catch(function(error){
             console.log(error);
     });
  };

     // details
     $scope.details = function(index) {
      let product = $scope.listProducts[index];
  
      // Truyền thông tin sản phẩm qua $routeParams
      $location.path("/form-update").search({
        maSanPham: product.maSanPham,
        tenSanPham: product.tenSanPham,
        chatLieu: product.chatLieu,
        giaHienHanh: product.giaHienHanh,
        soLuongTon: product.soLuongTon,
        moTa: product.moTa,
        loaiSanPham: product.loaiSanPham,
        mauSac: product.mauSac,
        nhaSanXuat: product.nhaSanXuat,
        trangThai: product.trangThai,
        hinhAnh: product.hinhAnh,
        viTriUpdate: index
      });
    };

   
};
