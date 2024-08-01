import { createApp, ref, computed, onMounted } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';
import Axios from 'https://unpkg.com/axios@1.7.2/dist/esm/axios.min.js';

// (async () => {
//     await Axios
//         .get('http://localhost:8080/book')
//         .then(res => console.log(res.data))
//         // .then(res => resData.value = res.data)
//         .catch(error => console.log(error, "失敗"));
// })();

createApp({
    setup() {
        const TestMessage = ref('Hello vue!');

        const item = {
            checked: false,
            picture: "圖片",
            price: 100,
            amount: 3,
            total: 300
        };
        const items = ref([item, item, item]);

        const hello = ()=>console.log("hello world");

        return {
            TestMessage,
            items,
            hello
        }
    }
}).mount('#shopping-cart');
