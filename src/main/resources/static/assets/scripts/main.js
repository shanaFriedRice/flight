//$(document).ready(function() {
//
//    $.ajax({
//
//        url: '/api/flights',
//        method: 'get',
//        dataType: 'json',
//        success: function (data){
//
//        $('#datatable').DataTable( {
//                dom: 'Bfrtip',
//                buttons: [
//                    'csv','pdf'
//                ],
//                data: data,
//                columns: [
//
//                      {"data": "name" },
//                      {"data": "serialNumber" },
//                      {"data": "model" },
//                        ]
//                    });
//            }
//    });
//
//
//});

$(document).ready(function() {
    $('#datatable').DataTable({
        "processing" : true,
        "ajax" : {
            "url" : "/api/flights",
            dataSrc : ''
        },
        "columns" : [ {
            "data" : "name"
        }, {
            "data" : "serialNumber"
        }, {
            "data" : "model"
        }]
    });
});