<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>TOSCA Blueprint - DevOps Pipeline Helper</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body ng-app="myapp">
   <div class="container" ng-controller="MyController">
  <h2>TOSCA Blueprint Reviewer</h2>
 
    <div class="form-group">
      <label for="Blueprint">Blueprint</label>
      <input type="text" class="form-control" id="email" ng-model="myData.bpname" placeholder="Enter blueprint yaml file path" name="Blueprint">
    </div>
    <button type="submit" class="btn btn-default" ng-click="myData.doClick(item, $event)">Submit</button>
 <h5> Data from server: {{myData.fromServer}}</h5>
</div>


  <script>
    angular.module("myapp", [])
        .controller("MyController", function($scope, $http) {
        	
        	$scope.myData = {bpname:'Enter bppath', bpinput:'path location'};
        	$scope.myData.doClick = function(item, event) {
        		
        		var data = $.param({
                    bp_path: $scope.myData.bpname
                });
            
                var config = {
                    headers : {
                        'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                    }
                }

                var responsePromise = $http.post("/TOSCABPReview/blueprintStats",data,config);

                responsePromise.success(function(data, status, headers, config) {
                	console.log(data,status,headers,config);
                    $scope.myData.fromServer = data + $scope.myData.bpname;
                });
                responsePromise.error(function(data, status, headers, config) {
                    alert("AJAX failed!");
                });
            }


        } );
  </script>

</body>
</html>

