// 加入購物車按鈕
const addToCartBtn = document.querySelector('.btn-cart button');

// 按鈕事件監聽
addToCartBtn.addEventListener('click', function(event) {
    console.log('按鈕被點擊');
    console.log('商品 ID:', this.getAttribute('value'));
    console.log('會員 ID:', document.getElementById('memberId').value);
    // 取得商品數量
    const quantity = document.querySelector('input[type="number"]').value;

    // 取得poductId
    const productId = this.getAttribute('value');

    // 取得memberId
    const memberId = document.getElementById('memberId').value;

    // 請求的資料
    const cartData = {
        cartId: null,
        memberId: parseInt(memberId),
        productId: parseInt(productId),
        proAmount: parseInt(quantity),
        joinDt: null
    };

    // 發送POST请求至後端
    fetch(`/cart/${memberId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(cartData)
    })
        .then(response => response.json())
        .then(data => {

            alert('商品已成功加入購物車！');
            // 這裡可以更新購物車旁的數字顯示
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('加入購物車失敗, 請重試');
        });
    console.log("cartData = " + cartData);
});