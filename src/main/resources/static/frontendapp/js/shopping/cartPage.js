import { createApp, ref, computed, onMounted, toRaw } from 'https://unpkg.com/shopping@3/dist/shopping.esm-browser.prod.js';
import axios from 'https://unpkg.com/axios@1.7.2/dist/esm/axios.min.js';

/*
todo 判斷用戶->
     未登入: 存入sessionStorage
     登入: 透過cookie取得emberId
 */
let memberId = "1";
const cartURL = "http://localhost:8080/cart/";
const couponURL = "http://localhost:8080/coupon/";
const productURL = "frontendapp/img/products/";

const dumbProducts = {
    1001: {
        name: "巧克力餅乾",
        price: 300,
        picture: productURL + "04.jpg"
    },
    1002: {
        name: "巧克力蛋糕",
        price: 400,
        picture: productURL + "09.jpg"
    },
    1003: {
        name: "白巧克力餅乾",
        price: 500,
        picture: productURL + "07.jpg"
    },
    1004: {
        name: "白巧克力餅乾",
        price: 500,
        picture: productURL + "08.jpg"
    },
}
const dumbItems = [
    {cartId:1, picture: "圖片", productName: "巧克力餅乾", price: 100, proAmount: 1,},
    {cartId:2, picture: "圖片", productName: "牛奶糖餅乾", price: 200, proAmount: 2,}
];
let products = dumbProducts;


createApp({
    setup() {
        let items = ref(dumbItems);
        const isDiscount = ref(false);
        const codeInput = ref("");
        const discountAmount = ref(0);
        const coupons = ref([]);
        const selectedItems = ref([]); // 選擇的商品

        // 全選狀態的計算屬性
        const allSelected = computed({
            get() {
                return selectedItems.value.length === items.value.length && items.value.length > 0;
            },
            set(value) {
                if (value) {
                    selectedItems.value = items.value.map(item => item);
                } else {
                    selectedItems.value = [];
                }
            }
        });
        // 選中商品的總金額計算屬性
        const selectedSum = computed(() => {
            return selectedItems.value.reduce((acc, item) => acc + (item.price * item.proAmount), 0);
        });


        /**
         前端頁面資料推演，購物車，CartViewObject，需要什麼資料？
         Cart: CartId、MemberId、ProductId、ProAmount、JoinDt
         流水號PK、會員編號FK、商品編號FK、商品數量、加入日期

         CartViewObject:
         購物車項目 Id CartId、商品圖片、商品品項名、商品單價、商品數量、總計
         所屬會員 Id

         **/

        /** {
                response:{
                    data: {
                        productsInfos: [],
                            cartList: [],
                            coupons:[]
                    }
                }
            }**/
        onMounted( async() => {
            try {
                let cartResponse = await axios.get(cartURL + memberId);
                let couponResponse = await axios.get(couponURL);

                let { productInfos, cartList } = cartResponse.data;
                coupons.value.push(...couponResponse.data);
                console.log("couPonResponse = " + couponResponse);
                items.value = cartList.map(mapCallback);
                console.log(toRaw(items.value));
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        });

        //刪除商品
        const deleteItem = index => {
            let array = items.value;
            let itemToDelete = array[index];
            let cartId = itemToDelete.cartId;

            // array 裡需至少有一項才執行，否則短路不繼續運算，不短路則 spice 掉陣列裡第 i 個 item
            array.length > 0 && array.splice(index, 1);

            console.log("item = ", toRaw(itemToDelete));
            console.log("cartId =", cartId);

            // 送出刪除購物車的api請求
            axios.delete(cartURL + cartId)
                .then(res => console.log(res))
                .catch(err => console.log(err));
        };


        let couponChecked; // 套用優惠券成功與否的狀態
        const discountHandler = () => {

            // 檢查輸入的 codeInput.value 跟 coupons 裡的 couponCode 是否符合
            const isCodeInCoupons = coupons.value.some(coupon => coupon.couponCode === codeInput.value);
            if(isCodeInCoupons) {
                couponChecked= coupons.value.find(coupon => coupon.couponCode === codeInput.value);
                console.log(couponChecked);

                // 計算折價金額
                discountAmount.value = Math.round(selectedSum.value * (1 - couponChecked.discPercentage));
                console.log(discountAmount.value);
                isDiscount.value = !isDiscount.value;
            }
        };

        return {
            items,
            sum: selectedSum, //選中商品的總金額
            isDiscount,
            discountAmount,
            codeInput,
            deleteItem,
            discountHandler,
            selectedItems,
            allSelected
        }
    }
}).mount('#shopping-cart');

function reduceCallback(accumulator, current){
    accumulator[current.productId] = {
        name: current.proName,
        picture: productURL + "0" + (current.productId-1000) + ".jpg",
        price: current.proPrice,
        others: current
    };
    return accumulator;
}

function mapCallback(item){
    let id = item.productId;
    item.productName = products[id].name;
    item.price = products[id].price;
    item.picture = products[id].picture;
    item.sum = item.price * item.proAmount;
    item.url = "productDetails/" + item.cartId;
    return item;
}