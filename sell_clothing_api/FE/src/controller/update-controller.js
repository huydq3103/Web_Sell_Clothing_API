window.FormUpdateController = function ($scope, $routeParams,$http) {
  let url = "http://localhost:8080/clothing-store";
  // Lấy thông tin sản phẩm từ $routeParams
  $scope.request = {
    maSanPham: $routeParams.maSanPham,
    tenSanPham: $routeParams.tenSanPham,
    chatLieu: $routeParams.chatLieu,
    giaHienHanh: $routeParams.giaHienHanh,
    soLuongTon: $routeParams.soLuongTon,
    moTa: $routeParams.moTa,
    loaiSanPham: $routeParams.loaiSanPham,
    mauSac: $routeParams.mauSac,
    nhaSanXuat: $routeParams.nhaSanXuat,
    trangThai: $routeParams.trangThai,
    hinhAnh: $routeParams.hinhAnh,
  };

  $scope.viTriUpdate = $routeParams.viTriUpdate;

  //selected file image
  $scope.selectedFileName = "";

  $scope.selectFile = function () {
    var fileInput = document.getElementById("fileInput");
    fileInput.click();
  };

  document
    .getElementById("fileInput")
    .addEventListener("change", function (event) {
      var file = event.target.files[0];
      if (file) {
        $scope.selectedFileName = file.name;
        $scope.request.hinhAnh = file.name.toString();
        console.log($scope.request.hinhAnh);
        $scope.$apply(); // Cập nhật scope để hiển thị tên file đã chọn
        // Xử lý dữ liệu file ở đây
        console.log(file);
      } else {
        $scope.selectedFileName = "";
        $scope.$apply(); // Cập nhật scope để ẩn tên file khi không có file nào được chọn
        console.log("Chưa chọn file.");
      }
    });

  //update

  $scope.updateProduct = function (event) {
    let productId = $scope.request.maSanPham;
    let api = url + "/update/" + productId;

    $http.put(api, JSON.stringify($scope.request)).then(function (response) {
      alert("Product updated successfully");
    }).catch(function(error) {
        // Xử lý lỗi nếu có
        console.error("Lỗi khi cập nhật sản phẩm:", error);
      });;
  };

};
