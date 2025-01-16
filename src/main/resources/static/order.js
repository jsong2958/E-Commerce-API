function placeOrder() {
    let formData = {
        name: $("name").val(),
        email: $("email").val(),
        phoneNumber: $("phone_number").val(),
        address: $("address").val()
    }

    fetch("")

}

$(function() {

    $("#orderForm").on('submit', function(event) {
        event.preventDefault();
    });
});