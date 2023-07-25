window.formCRUD = function ($scope, $http) {
  let url = "http://localhost:8080/clothing-store";
 
  $scope.listProducts = [];
  $scope.viTriUpdate = -1;

    $scope.request = {
      maSanPham: "",
      tenSanPham: "",
      chatLieu: "",
      giaHienHanh: "",
      soLuongTon: "",
      moTa: "",
      loaiSanPham: "",
      mauSac: "",
      nhaSanXuat: "",
      trangThai: "",
      hinhAnh: "",
    };
  
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
  
    
    // add New Products
  
    $scope.addProduct = function (event) {
      event.preventDefault();
      let apiAdd = url + "/insert";
      $http.post(apiAdd, JSON.stringify($scope.request))
        .then(function (response) {
          alert("Success");
        })
        .catch(function (error) {
          console.error(error);
        });
    };

 

    
  
  };
  