(function() {

$("footer").append("4U Software");
var data = {};
data.platform = navigator.platform;
$.post("/stats", data);

})();