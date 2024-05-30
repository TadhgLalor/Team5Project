////////////////////////////////////
//Button functionality on side bar//
////////////////////////////////////
window.addEventListener('DOMContentLoaded', event => {
     // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }
});

 document.getElementById('findAll').addEventListener('click', function() {
     findAll();
 });


 /////////////////////////////////////////
 // Query for Ajax front to backend points //
 /////////////////////////////////////////
 function findAll() {
     var findAllUrl = "http://localhost:8081/api/failures";
     $.ajax({
         type: 'GET',
         url: findAllUrl,
         dataType: "json",
         success: function(data) {
             if (!data || data.length === 0) {
                 console.log("No data available");
                 alert("Invalid input, please try again!!!");
             } else {
             console.log(data)
                 let headings = ['Node Id', 'Network Id', 'Network Name', 'Caller Id', 'Caller Name', 'Fault Reason', 'Time'];
                 let query = 'All Radio Failures: ';
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
 //Add Data Table with data to html UI//
///////////////////////////////////////

renderListOrderColumns = function(list, headings, query, column_list) {
     // Inside renderListOrderColumns function
        console.log("Render entered");
        console.log("Column List:", column_list);
        console.log("Data:", list);
        console.log("Headings:", headings);
        console.log("Query:", query);
    // Check if the element with ID 'addHere' exists
    var div2 = document.getElementById('addHere');
    if (!div2) {
        console.error("Element with ID 'addHere' not found.");
        return; // Exit the function if the element is not found
    }

    // Clear the content of the div
    div2.innerHTML = '';

    // Construct HTML for the table
    let html = '<div class="container-fluid"><div class="row mb-5"><div class="col-xl-10 col-lg-9 col-md-8 ml-auto">'
        + '<div class="row align-items-left"><div class="col-xl-8 col-12 mb-4 mb-xl-0">'
        + '<h3 id="queryTitle" class="text-muted text-left mb-3"'
        + ' style="position: sticky; top: 56px; background-color: #eee; padding: 10px; box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1); z-index: 1000; width: 140% ">'
        + query + '</h3><table id="table_id" class="table table-striped bg-light text-left" style="display= flex; table-layout: auto;  width: 125% ">'
        + '<thead><tr>';

    // Add table headings
    headings.forEach(function(item, index) {
        html += '<th style="text-align: left;">' + item + '</th>';
    });

    html += '</tr></thead><tbody id="table_body">';

    // Add table rows
    list.forEach(function(row) {
        html += '<tr>';
        column_list.forEach(function(column) {
            html += '<td>' + row[column.data] + '</td>';
        });
        html += '</tr>';
    });

    html += '</tbody></table></div></div></div></div>';

    // Set the HTML content
    div2.innerHTML = html;
};


 // Alert message box
 alertMessage = function() {
  	var htmlStr = '<div class="modal fade" id="alert-message-modal">';
  	htmlStr += '<div class="modal-dialog modal-dialog-centered">';
  	htmlStr += '<div class="modal-content">';
  	htmlStr += '<div class="modal-header">';
  	htmlStr += '<form id="alert-message-form">';
  	htmlStr += '<h4 class="modal-title text-danger">Warning!!</h4>';
  	htmlStr += '<div class="d-flex modal-body justify-content-center" id="warning-message">';
  	htmlStr += '<p>Invalid input, please try again!!!</p>';  // Added line
  	htmlStr += '</div></form>';
  	htmlStr += '<button type="button" class="close closeAlertMessageButton" data-dismiss="modal">&times;</button></div>';
  	htmlStr += '<div class="modal-footer"><button type="button" class="btn btn-danger closeAlertMessageButton" data-dismiss="modal">Close</button></div>';
  	htmlStr += '</div></div></div>';
  	$('#theBody').append(htmlStr);
 };


