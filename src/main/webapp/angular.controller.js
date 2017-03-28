(function(){
	var app= angular.module("Project2", []);

	app.controller('studentSearch', function(getAllStudentRecord,submitStudentRecord,getRecordsByRank){

		var self=this;
		self.searchType= "All";
		var studentRecord ;
		self.pageTypeSearch=true;
		self.recordNotInserted=false;
		self.recInsertedSuccessfully=true;
		self.isSearchByBelts=false;  //search for belts only
		self.searchByCatgory=false;

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
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.apiCall();	
		}
		else if(data == 'Active'){
			self.searchType= "Active";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.apiCall();
		}
		else if(data == 'Rank'){
			self.searchType= "By Rank";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=true;
			self.apiCall();
		}
		else if(data == 'Year'){
			self.searchType= "By Year";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=true;
			self.apiCall();
		}
		else if(data == 'Belts'){
			self.searchType= "By Belts";
			self.isSearchByBelts=true;
			self.searchByCatgory=true;
			//get all records of particular belts
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

	self.callSearchByBelt=function(){
		self.apiCall2();
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
	
	self.apiCall2=function(){
		getRecordsByRank.getRecords(self.studentStruct.belts)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}
	

});

})();