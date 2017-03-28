(function(){
	var app=angular.module("Project2");

app.service("submitStudentRecord",submitStudentRecord);
app.service("getAllStudentRecord",getAllStudentRecord);
app.service("getRecordsByRank",getRecordsByRank);
	
	function getAllStudentRecord($http){

		var self = this;
		self.getRecords= function(data){
			console.log("inside service");
			console.log(data);
			
			var p1= $http.get('http://localhost:8080/object2');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
	}

	function getRecordsByRank($http){

		var self = this;
		self.getRecords= function(data){
			console.log("inside service");
			console.log("inside getRecordsByRank Data =" + data);
			
			var p1= $http.get('http://localhost:8080/topic/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
	}

	function submitStudentRecord($http){

		var self=this;	
		
		self.saveRecord = function(data){
			self.local=data;
			console.log("inside service");
			console.log(self.local.name);
			console.log(self.local.age);
			console.log(self.local.rank);
			console.log(self.local.year);
			console.log(self.local.belts);
			console.log("End of user input");
			var promise1 = $http.post("http://localhost:8080/students",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}
	}
})();