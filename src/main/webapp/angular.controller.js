(function(){
	var app= angular.module("Project2", []);

	app.controller('studentSearch', function(getAllStudentRecord,submitStudentRecord){

		var self=this;
		self.searchType= "All";
		var studentRecord ;
		self.pageTypeSearch=true;
		self.recordNotInserted=false;
		self.recInsertedSuccessfully=true;

	//varibables to send data to backend
	self.studentStruct={
		"name":"",
		"age":"",
		"rank":"",
		"year":"",
		"belts": ""
	};

	self.saveStudent = function(){
		console.log(self.studentStruct);
		self.recordNotInserted=true;
		submitStudentRecord.saveRecord(self.studentStruct)
		.then(function (argument) {
			console.log("Success");
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	

	//initialise structure for next student insertion	
	self.refreshData = 	function(){
		self.studentStruct.name = "";
		self.studentStruct.age = "";
		self.studentStruct.rank = "";
		self.studentStruct.year = "";
		self.studentStruct.belts = "";
	}

	self.searchCall= function(data){
		if(data == 'All'){
			self.searchType= "All";	
			self.apiCall();	
		}
		else if(data == 'Active'){
			self.searchType= "Active";
			self.apiCall();
		}
		else if(data == 'Rank'){
			self.searchType= "By Rank";
			self.apiCall();
		}
		else if(data == 'Year'){
			self.searchType= "By Year";
			self.apiCall();
		}
		else if(data == 'Belts'){
			self.searchType= "By Belts";
			self.apiCall();
		}
	}

	self.changePage=function(data){
		self.pageTypeSearch=data;
		if(data == false){
			self.refreshData();
		}
		else {
			self.recordNotInserted=false;
		}
	}

	getAllStudentRecord.getRecords(self.searchType)
	.then(function(data){
		console.log(data);
		self.studentRecord =data;
	})
	
	self.apiCall=function(){
		getAllStudentRecord.getRecords(self.searchType)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

});

})();