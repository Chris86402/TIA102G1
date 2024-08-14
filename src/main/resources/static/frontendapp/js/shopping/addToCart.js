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

    //取得localStorage內的購物車資料
    let localCartItems = JSON.parse(localStorage.getItem("localCartItems"));

    //判斷使用者的localStorage是否有 key= localCartItems 的資料
    if (localCartItems !== []){
        // 如果有, 用迴圈去判斷裡面的productId是否 = 使用者請求的productId
        // for (let i = 0; i < localCartItems.length; i++) {
        //     //如果productId一樣
        //     if(localCartItems[i].productId === productId){
        //         //將此productId原本的數量 + 請求的數量
        //         localCartItems[i].productId += quantity;
        //
        //     } else {
        //         //如果productId不一樣, 就加入商品
        //         localCartItems.push({
        //             productId: productId,
        //             quantity: parseInt(quantity)
        //         });
        //     }
        // }

        localCartItems.foreach(item => {
            if(item.productId !== productId) localCartItems.push({
                productId: productId,
                quantity: parseInt(quantity)
            });
            else {
                localCartItems[i].proAmount += quantity;
            }
        })
    } else {
        // 如果沒有localCartItems, 就直接加入商品
        localCartItems.push({
            productId: productId,
            quantity: parseInt(quantity)
        });
    }

    //存入localStorage
    localStorage.setItem("localCartItems", JSON.stringify(localCartItems));

    // 向後端請求的資料
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
            // todo 這裡可以更新購物車旁的數字顯示
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('加入購物車失敗, 請重試');
        });
    console.log("cartData = " + cartData);
});