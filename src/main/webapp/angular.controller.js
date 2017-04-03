(function(){
	var app= angular.module("Project2", []);

	app.controller('studentSearch', function(getAllStudentRecord,submitStudentRecord,getRecordsByBelt
		,getRecordsByRank,getRecordsByYear,getRecordsByCombo,submitExtraServices,getGeneralRecordsForForm){

		var self=this;
		self.searchType= "All";
		var studentRecord ;
		var classRecords;
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
		self.yearOptionSelected="=";

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
		"cls_code":"",
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

	//********************initialise******************//
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

	//initialise structure for next student insertion	
	self.refreshClassData = function(){
		self.classStruct.cls_code="";
		self.classStruct.cls_description = "";
		self.classStruct.cls_level="";
		self.classStruct.instructor.ins_number="";
	}

	self.refreshscheduleStruct= function(){
		self.scheduleStruct.sch_dayweek="";
		self.scheduleStruct.start_time="";
		self.scheduleStruct.end_time="";
		self.scheduleStruct.classs.cls_code="";
		self.scheduleStruct.classs.cls_description="";
		
	};

	//******************functions to save data **************//
	//function to save student record
	self.saveStudent = function(){
		self.studentStruct.rank.rk_code=4;
		console.log(self.studentStruct);
		self.recordNotInserted=true;
		self.addStudentPage=false;
		self.apiCallToSaveStudent(self.studentStruct);
		//self.refreshData();
	}
	//function to save class record
	self.saveClass = function(){
		console.log(self.classStruct);
		self.apiCallToSaveClass(self.classStruct);
		self.recordNotInserted=true;
		self.addClassPage=false;
		//flush the data
		//self.refreshClassData();
	}
	//function to save Schedule record
	self.saveSchedule = function(){
		self.apiCallToSaveClassSchedule(self.scheduleStruct);
		self.recordNotInserted=true;
		self.addSchedulePage=false;
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
			self.refreshData();
			self.studentRecord="";
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
			self.studentRecord="";
			self.yearOptionSelected="=";
			self.refreshData();
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
			self.studentRecord="";
			self.refreshData();
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
			self.studentRecord="";
			self.yearOptionSelected="=";
			self.refreshData();
		}
		else if(data == 'Belts'){
			self.searchType= "By Belts";
			self.isSearchByBelts=true;
			self.searchByCatgory=true;
			self.isSearchByRank=false;
			self.isSearchByCombo=false;
			self.isSearchByYear=false;
			self.showStudentResult=false;
			self.studentRecord="";
			self.refreshData();
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
			self.refreshData();
		}
		else if(data == 'Class'){
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=true;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.refreshClassData();
		}
		else if(data == 'Schedule'){
			//self.refreshClassData();
			self.refreshscheduleStruct();
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=true;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.apiCallToGetGeneralRecordsForClass();

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
	self.searchByBelt=function(data){
		//console.log("Call to searchByBelt recieved");
		self.showStudentResult=true;
		self.apiCallToGetStudByBelt(data);
	}
	//function to call API to get all student for a year
	self.searchByYear=function(data1,data2){
		console.log("mode recieved= " + data2);
		console.log("value recieved =" + data1);
		if(data2 == ">="){
			self.searchByYearGt(data1);
		}
		else if(data2=="<="){
			self.searchByYearLt(data1);
		}
		self.apiCallToGetStudByYear(data1);
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a year greater
	self.searchByYearGt=function(data1){
		console.log("Call recieved in searchByYearGt with data = " + data1);
		self.apiCallToGetStudByYearGt(data1);
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a year less
	self.searchByYearLt=function(data1){
		console.log("Call recieved in searchByYearLt with data = " + data1);
		self.apiCallToGetStudByYearLt(data1);
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a rank
	self.searchByRank=function(data){
		console.log("Data = " + data);
		self.showStudentResult=true;
		self.apiCallToGetStudByRank(data);
	}
	//function to call API to get all student for a combo
	self.searchByCombo=function(data1,data2,data3){
		console.log("Call recieved in searchByCombo with data = " + data1 + data2 +data3);
		self.showStudentResult=true;
		self.apiCallToGetStudByCombo(data1,data2,data3);
		//call API
	}



	//************API CALL Functions**************//
	//Api call to get all student
	self.apiCall=function(){
		getAllStudentRecord.getRecords(self.searchType)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}
	
	//Api call to get all by rank 
	self.apiCallToGetStudByRank=function(arg1){
		getRecordsByRank.getRecords(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all by belt 
	self.apiCallToGetStudByBelt=function(arg1){
		getRecordsByBelt.getRecords(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all by = year 
	self.apiCallToGetStudByYear=function(arg1){
		getRecordsByYear.getRecords(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}
	
	//Api call to get all by <= year 
	self.apiCallToGetStudByYearLt=function(arg1){
		getRecordsByYear.getRecordsLt(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all by >= year 
	self.apiCallToGetStudByYearGt=function(arg1){
		getRecordsByYear.getRecordsGt(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all by combo 
	self.apiCallToGetStudByCombo=function(arg1,arg2,arg3){
		getRecordsByCombo.getRecords(arg1,arg2,arg3)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all class records
	getGeneralRecordsForForm
	self.apiCallToGetGeneralRecordsForClass=function(){
		getGeneralRecordsForForm.getClassRecords()
		.then(function(data){
			console.log(data);
			self.classRecords =data;
		})
	}


	//*******************SAVE API Calls**************//
	//API to save Student information
	self.apiCallToSaveStudent=function(arg1){
		submitStudentRecord.saveRecord(arg1)
		.then(function (argument) {
			console.log("Success");
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	//Api call to save Class info
	self.apiCallToSaveClass=function(arg1){
		submitExtraServices.saveClass(arg1)
		.then(function (argument) {
			console.log("Success");
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	//Api call to save Class Schedule
	self.apiCallToSaveClassSchedule=function(arg1){
		submitExtraServices.saveClassSchedule(arg1)
		.then(function (argument) {
			console.log("Success");
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}



});

})();