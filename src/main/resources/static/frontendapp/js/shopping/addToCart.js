document.addEventListener('DOMContentLoaded', function() {
    // 加入購物車按鈕
    const addToCartBtn = document.querySelector('.btn-cart button');

    // 按鈕事件監聽
    addToCartBtn.addEventListener('click', function(event) {
        event.preventDefault(); // 防止表單提交
        console.log('按鈕被點擊');
        console.log('商品 ID:', this.getAttribute('value'));
        console.log('會員 ID:', document.getElementById('memberId').value);

        // 取得商品數量
        const proAmount = parseInt(document.querySelector('input[type="number"]').value);

        // 取得productId
        const productId = this.getAttribute('value');

        // 取得memberId
        const memberId = document.getElementById('memberId').value;

        // 取得localStorage內的購物車資料
        let localCartItems = JSON.parse(localStorage.getItem("localCartItems")) || [];

        // 查找是否已存在相同商品
        let existingItem = localCartItems.find(item => item.productId === productId);

        if (existingItem) {
            // 如果商品已存在，增加數量
            existingItem.proAmount += proAmount;
        } else {
            // 如果商品不存在，添加新項目
            localCartItems.push({
                productId: productId,
                proAmount: proAmount
            });
        }

        // 存入localStorage
        localStorage.setItem("localCartItems", JSON.stringify(localCartItems));
        console.log(localCartItems);

        // 向後端請求的資料
        const cartData = {
            cartId: null,
            memberId: parseInt(memberId),
            productId: productId,
            proAmount: proAmount,
            joinDt: null
        };

        // 發送POST請求至後端
        fetch(`/cart/${memberId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(cartData)
        })
            .then(response => response.json())
            .then(data => {
                console.log('伺服器回應:', data);
                alert('商品已成功加入購物車！');
            })
            .catch((error) => {
                console.error('錯誤:', error);
                alert('加入購物車失敗，請重試');
            });

        console.log("cartData =", cartData);
    });
});