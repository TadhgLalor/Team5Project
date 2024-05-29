document.getElementById('findId').addEventListener('click', function() {
    console.log("findOrder function called");
     findOrder();
 });

$(document).on('click', '#Cancel', function() {
    $('#findorder-model').modal('hide');
});

function findOrder() {
    console.log("findOrder function called2");
    $('#findorder-model').modal('show');
}