let cartId = Number(sessionStorage.getItem('cartId'));


function createCart() {
    fetch('http://localhost:8080/carts', {
        method: 'POST'
    })
        .then(r => r.json())
        .then(data => {
            sessionStorage.setItem('cartId', data.id);
        })

}

function addItemToCart(item) {
    fetch('http://localhost:8080/carts/' + cartId, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(item)
    });
}


function createItem(name, quantity, price) {
    let item = {
        product: name,
        quantity: quantity,
        price: price * quantity,
        cartId: cartId
    }

    fetch('http://localhost:8080/items', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item)
    })
        .then(r => r.json())
        .then(item => {
            addItemToCart(item);
        })



}


$(function() {
    createCart()

    $("#order").click(() => createItem("Bulgogi", 2, 14.99));
});

