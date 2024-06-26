  ///////////////////////////////////////
 ///////Find by Caller Id //////////////
///////////////////////////////////////

document.getElementById('findId').addEventListener('click', function() {
     $('#findorder-model').modal('show');
 });

$(document).on('click', '#Cancel', function() {
    $('#findorder-model').modal('hide');
});

$(document).on("click", "#Find_but", function() {
	var callerId = document.getElementById('userentry').value;
	findOrder(callerId);
});


function findOrder(callerId) {
    console.log("findOrder function called2"+callerId);

    var findIdUrl = "http://localhost:8081/api/failures/customer/"+callerId;
         $.ajax({
             type: 'GET',
             url: findIdUrl,
             dataType: "json",
             success: function(data) {
                 if (!data || data.length === 0) {
                     console.log("No data available");
                     alert("Invalid input, please try again!!!");
                 } else {
                 console.log(data)
                 $('#findorder-model').modal('hide');
                     let headings = ['Node Id', 'Network Id', 'Network Name', 'Caller Id', 'Caller Name', 'Fault Reason', 'Time'];
                     let query = 'Find By Caller Id: ';
                     let column_list = [
                         { data: 'nodeId' },
                         { data: 'networkId' },
                         { data: 'networkName' },
                         { data: 'callerId' },
                         { data: 'callerName' },
                         { data: 'faultReason' },
                         { data: 'faultTimestamp' }
                     ];
                     renderListOrderColumns(data, headings, query, column_list);
                 }
             },
             error: function(xhr, textStatus, errorThrown) {
                 console.error("AJAX request failed:", textStatus, errorThrown);
                 console.error("Status:", xhr.status);
                 console.error("Response:", xhr.responseText);
                 alert("Invalid input, please try again!!!");
             }
         });
     };

       ///////////////////////////////////////
      ///////Find by Node Id ////////////////
     ///////////////////////////////////////
document.getElementById('findNode').addEventListener('click', function() {
     $('#findNode-model').modal('show');
 });

$(document).on('click', '#Cancel2', function() {
    $('#findNode-model').modal('hide');
});

$(document).on("click", "#Find_but2", function() {
	var nodeId = document.getElementById('userEntry2').value;
	findNode(nodeId);
});


function findNode(nodeId) {
    console.log("find node id function called"+nodeId);

    var findNodeUrl = "http://localhost:8081/api/failures/node/"+nodeId;
         $.ajax({
             type: 'GET',
             url: findNodeUrl,
             dataType: "json",
             success: function(data) {
                 if (!data || data.length === 0) {
                     console.log("No data available");
                     alert("Invalid input, please try again!!!");
                 } else {
                 console.log(data)
                 $('#findNode-model').modal('hide');
                     let headings = ['Node Id', 'Network Id', 'Network Name', 'Caller Id', 'Caller Name', 'Fault Reason', 'Time'];
                     let query = 'Find By Node Id: ';
                     let column_list = [
                         { data: 'nodeId' },
                         { data: 'networkId' },
                         { data: 'networkName' },
                         { data: 'callerId' },
                         { data: 'callerName' },
                         { data: 'faultReason' },
                         { data: 'faultTimestamp' }
                     ];
                     renderListOrderColumns(data, headings, query, column_list);
                 }
             },
             error: function(xhr, textStatus, errorThrown) {
                 console.error("AJAX request failed:", textStatus, errorThrown);
                 console.error("Status:", xhr.status);
                 console.error("Response:", xhr.responseText);
                 alert("Invalid input, please try again!!!");
             }
         });
     };

            ///////////////////////////////////////
           ///////Find by Fault Reason ///////////
          ///////////////////////////////////////
     document.getElementById('findFault').addEventListener('click', function() {
          $('#findFault-model').modal('show');
      });

     $(document).on('click', '#Cancel3', function() {
         $('#findFault-model').modal('hide');
     });

     $(document).on("click", "#Find_but3", function() {
     	var fault = document.getElementById('userEntry3').value;
     	findFault(fault);
     });


     function findFault(fault) {
         console.log("find by fault ajax function called"+fault);

         var findFaultUrl = "http://localhost:8081/api/failures/reason/"+fault
              $.ajax({
                  type: 'GET',
                  url: findFaultUrl,
                  dataType: "json",
                  success: function(data) {
                      if (!data || data.length === 0) {
                          console.log("No data available");
                          alert("Invalid input, please try again!!!");
                      } else {
                      console.log(data)
                      $('#findFault-model').modal('hide');
                          let headings = ['Node Id', 'Network Id', 'Network Name', 'Caller Id', 'Caller Name', 'Fault Reason', 'Time'];
                          let query = 'Find By Fault Reason: ';
                          let column_list = [
                              { data: 'nodeId' },
                              { data: 'networkId' },
                              { data: 'networkName' },
                              { data: 'callerId' },
                              { data: 'callerName' },
                              { data: 'faultReason' },
                              { data: 'faultTimestamp' }
                          ];
                          renderListOrderColumns(data, headings, query, column_list);
                      }
                  },
                  error: function(xhr, textStatus, errorThrown) {
                      console.error("AJAX request failed:", textStatus, errorThrown);
                      console.error("Status:", xhr.status);
                      console.error("Response:", xhr.responseText);
                      alert("Invalid input, please try again!!!");
                  }
              });
          };

            ///////////////////////////////////////
           ///////Find By Node & Date/Time ///////
          ///////////////////////////////////////
     document.getElementById('nodeFD').addEventListener('click', function() {
          $('#NodeTimeFind').modal('show');
      });

     $(document).on('click', '#cancel4', function() {
         $('#NodeTimeFind').modal('hide');
     });

     $(document).on("click", "#SubmitQueryF", function() {
     	var IDFindND = document.getElementById('userEntryFD').value;
     	var startND= document.getElementById('start_datetimeF').value;
     	var endND= document.getElementById('end_datetimeF').value;
     	findByNodeNDateTime(IDFindND,startND,endND);
     });


     function findByNodeNDateTime(IDFindND,startND,endND) {

         var findFaultUrl = "http://localhost:8081/api/failures/node/"+IDFindND+"/timestamp/start/"+startND+"/end/"+endND
              $.ajax({
                  type: 'GET',
                  url: findFaultUrl,
                  dataType: "json",
                  success: function(data) {
                      if (!data || data.length === 0) {
                          console.log("No data available");
                          alert("Invalid input, please try again!!!");
                      } else {
                      console.log(data)
                      $('#findFault-model').modal('hide');
                          let headings = ['Node Id', 'Network Id', 'Network Name', 'Caller Id', 'Caller Name', 'Fault Reason', 'Time'];
                          let counter2 = data.length
                          let query = 'Find By Node & Time Period: Count ='+counter2;
                          let column_list = [
                              { data: 'nodeId' },
                              { data: 'networkId' },
                              { data: 'networkName' },
                              { data: 'callerId' },
                              { data: 'callerName' },
                              { data: 'faultReason' },
                              { data: 'faultTimestamp' }
                          ];
                          renderListOrderColumns(data, headings, query, column_list);
                      }
                  },
                  error: function(xhr, textStatus, errorThrown) {
                      console.error("AJAX request failed:", textStatus, errorThrown);
                      console.error("Status:", xhr.status);
                      console.error("Response:", xhr.responseText);
                      alert("Invalid input, please try again!!!");
                  }
              });
          };


  ///////////////////////////////////////
           ///////Find By Caller ID & Date/Time ///////
          ///////////////////////////////////////
     document.getElementById('callerIDFD').addEventListener('click', function() {
          $('#CallerTimeFind').modal('show');
      });

     $(document).on('click', '#cancelcaller', function() {
         $('#CallerTimeFind').modal('hide');
     });

     $(document).on("click", "#SubmitQueryFcaller", function() {
     	var IDFindND2 = document.getElementById('userEntryCallerFD').value;
     	var startND2= document.getElementById('start_datetimeFcaller').value;
     	var endND2= document.getElementById('end_datetimeFcaller').value;
     	findByCallerIDDateTime(IDFindND2,startND2,endND2);
     });


     function findByCallerIDDateTime(IDFindND2,startND2,endND2) {

         var findFaultUrl = "http://localhost:8081/api/failures/customer/"+IDFindND2+"/timestamp/start/"+startND2+"/end/"+endND2
              $.ajax({
                  type: 'GET',
                  url: findFaultUrl,
                  dataType: "json",
                  success: function(data) {
                      if (!data || data.length === 0) {
                          console.log("No data available");
                          $('#CallerTimeFind').modal('hide');
                          alert("Invalid input, please try again!!!");
                      } else {
                      console.log(data)
                      $('#findFault-model').modal('hide');
                          let headings = ['Node Id', 'Network Id', 'Network Name', 'Caller Id', 'Caller Name', 'Fault Reason', 'Time'];
                          let counter = data.length
                          let query = 'Find By Caller ID & Time Period: Count ='+counter;
                          let column_list = [
                              { data: 'nodeId' },
                              { data: 'networkId' },
                              { data: 'networkName' },
                              { data: 'callerId' },
                              { data: 'callerName' },
                              { data: 'faultReason' },
                              { data: 'faultTimestamp' }
                          ];
                          renderListOrderColumns(data, headings, query, column_list);
                      }
                  },
                  error: function(xhr, textStatus, errorThrown) {
                      console.error("AJAX request failed:", textStatus, errorThrown);
                      console.error("Status:", xhr.status);
                      console.error("Response:", xhr.responseText);
                      $('#CallerTimeFind').modal('hide');
                      alert("Invalid input, please try again!!!");
                  }
              });
          };


