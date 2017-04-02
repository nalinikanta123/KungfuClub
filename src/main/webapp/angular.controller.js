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
		self.isSearchByCombo=false;
		self.isSearchByRank=false;
		self.isSearchByYear=false;
		self.showStudentResult=false; // show the block of student search data
		self.addStudentPage=false;
		self.addClassPage=false;
		self.addSchedulePage=false;
		self.addRankPage=false;
		self.addRankReqPage=false;
		self.addPageSelected=false;
		self.showUpdatePage=false;
		self.showViewFullPage=false;

	//varibables to send data to backend
	self.studentStruct={
		"std_fname":"",
		"std_lname":"",
		"std_dob":"",
		"std_date_enroll":"",
		"std_phone":"",
		"std_email":"",
		"std_address_line1":"",
		"std_address_line2":"",
		"std_address_city":"",
		"std_address_prov":"",
		"std_address_zipcode":"",
		"rank": {
				"rk_code" : "",
				"rk_name": "",
				"rk_belt_color":""
				}
	};

	//structure to hold class info
	self.classStruct={
		"cls_description":"",
		"cls_level":"",
		"instructor":{
			"ins_number":""
		}

	};

	//structure to hold Schedule page
	self.scheduleStruct={
		"sch_dayweek":"",
		"start_time":"",
		"end_time":"",
		"classs":{
			"cls_code":"",
			"cls_description":""
		}
	};

	//struture to hold Rank Page
	self.rankStruct={
		"rk_code":"",
		"rk_name":"",
		"rk_belt_color":""
	};

	//structure to hold Rank Reg page
	self.rankReqStruct={
		"dt_achieved": "",
		"student":{
			"std_num": "",
			"std_fname":"",
		},
		"rank":{
			"rk_code" :""
		},
		"rank_req":{
			"req_num" :""
		}
	};

	//function to save student record
	self.saveStudent = function(){
		self.studentStruct.rank.rk_code=4;
		console.log(self.studentStruct);
		self.recordNotInserted=true;
		self.addStudentPage=false;
		submitStudentRecord.saveRecord(self.studentStruct)
		.then(function (argument) {
			console.log("Success");
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}
	//function to save class record
	self.saveClass = function(){
		
	}
	//function to save Schedule record
	self.saveSchedule = function(){
		
	}
	//function to save Rank record
	self.saveRank = function(){
		
	}
	//function to save Rank Reg record
	self.saveRankReq = function(){
		
	}

	//************UPDATE CALLS*************//
	self.showSearchPage=function(){
		//console.log("Call recieved to show search page");
		self.showUpdatePage=false;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
	}
	self.viewFullInfoPage=function(){
		//console.log("Call recieved to show update page");
		self.showUpdatePage=true;
		self.showViewFullPage=true;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
	}
	self.viewFullEditStudPage=function(){
		//console.log("Call recieved to show update page");
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=true;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
	}
	self.viewAddFeePage=function(){
		//console.log("Call recieved to show update page");
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=true;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
	}
	self.viewAddParentPage=function(){
		//console.log("Call recieved to show update page");
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=true;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
	}
	self.viewAddClassAttPage=function(){
		//console.log("Call recieved to show update page");
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=true;
		self.showAddRankReqCompPage=false;
	}
	self.viewAddRankReqCompPage=function(){
		//console.log("Call recieved to show update page");
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=true;
	}
	//*************End of Update function calls

	//initialise structure for next student insertion	
	self.refreshData = 	function(){
		self.studentStruct.std_fname = "";
		self.studentStruct.std_lname="";
		self.studentStruct.std_dob="";
		self.studentStruct.std_date_enroll="";
		self.studentStruct.std_phone="";
		self.studentStruct.std_email="";
		self.studentStruct.std_address_line1="";
		self.studentStruct.std_address_line2="";
		self.studentStruct.std_address_city="";
		self.studentStruct.std_address_prov="";
		self.studentStruct.std_address_zipcode="";
		self.studentStruct.rank.rk_code="";
		self.studentStruct.rank.rk_name="";
		self.studentStruct.rank.rk_belt_color="";
	}

	self.searchCall= function(data){
		if(data == 'All'){
			self.searchType= "All";	
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.isSearchByCombo=false;
			self.isSearchByRank=false;
			self.isSearchByYear=false;
			self.showStudentResult=true;
			self.apiCall();	
		}
		else if(data == 'Combo'){
			self.searchType= "Combo";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.isSearchByRank=false;
			self.isSearchByCombo=true;
			self.isSearchByYear=false;
			self.showStudentResult=false;
		}
		else if(data == 'Rank'){
			self.searchType= "By Rank";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=true;
			self.isSearchByCombo=false;
			self.isSearchByRank=true;
			self.isSearchByYear=false;
			self.showStudentResult=false;
		}
		else if(data == 'Year'){
			self.searchType= "By Year";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=true;
			self.isSearchByCombo=false;
			self.isSearchByRank=false;
			self.isSearchByYear=true;
			self.showStudentResult=false;
		}
		else if(data == 'Belts'){
			self.searchType= "By Belts";
			self.isSearchByBelts=true;
			self.searchByCatgory=true;
			self.isSearchByRank=false;
			self.isSearchByCombo=false;
			self.isSearchByYear=false;
			self.showStudentResult=false;
		}
	}
	self.changePage=function(data){
		self.pageTypeSearch=data;

		if(data == false){
			self.refreshData();
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=false;
		}
		else {
			self.refreshData();
			self.recordNotInserted=false;
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.isSearchByRank=false;
			self.isSearchByCombo=false;
			self.isSearchByYear=false;
			self.showStudentResult=false;
			self.addPageSelected=false;
		}
	}


	//function to handle switching of Add block
	self.addCallSwitch= function(data){
		if(data == 'Student'){
			self.recordNotInserted=false;
			self.addStudentPage=true;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
		}
		else if(data == 'Class'){
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=true;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
		}
		else if(data == 'Schedule'){
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=true;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
		}
		else if(data == 'Rank'){
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=true;
			self.addRankReqPage=false;
			self.addPageSelected=true;
		}
		else if(data == 'RankReq'){
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=true;
			self.addPageSelected=true;
		}
	}


	//function to call API to get all student for a belt
	self.searchByBelt=function(){
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a year
	self.searchByYear=function(){
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a year greater
	self.searchByYearGt=function(){
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a year less
	self.searchByYearLt=function(){
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a rank
	self.searchByRank=function(){
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a combo
	self.searchByCombo=function(){
		self.showStudentResult=true;
		//call API
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