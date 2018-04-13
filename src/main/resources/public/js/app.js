(function() {

$("footer").append("4U Software");
var data = {};
data.author = "Guest";
data.message = 'Platform ' + navigator.platform
    + ',language ' + navigator.language + ', ' + window.screen.availHeight + 'x' +window.screen.availWidth;
$.ajax({
    url:'/message/',
    type: 'post',
    data:window.JSON.stringify(data),
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    dataType:'json'
});

function getMessages() {
    $.get("/message/", function(data) {
        $("footer").append('<p>'+data.length +'</p>');
    })
    }
setTimeout(function() {
    getMessages();
},2000);

navigator.vibrate(1000);
    $("#tools").hide();
$("#toolsBtn").click(function() {
    $("#main").hide();
    $("#tools").show();
    getTodoList();
});

function getTodoList(){
    $.get("/todo", function(data) {
        $(data).each(function(i){
            $("#tabela").append("<tr><td>"+data[i].text+"</td><td>"+new Date(data[i].created)+"</td></tr>");
        })
    })
}

$("#add").click(function () {
    var todo = {};
    todo.text = $("#comment").val();
    $.ajax({
        url:'/todo',
        type: 'post',
        data:window.JSON.stringify(todo),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType:'json'
    });
});


})();