(function() {

$("footer").append("4U Software");
var data = {};
data.author = "Guest";
data.message = 'Platform' + navigator.platform;
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
        $("footer").append(data);
    })
    }
setTimeout(function() {
    getMessages();
},2000)

})();