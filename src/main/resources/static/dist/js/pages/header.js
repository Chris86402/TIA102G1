let { createApp, ref, computed, onMounted, toRaw  } = Vue;

console.log("this is header.js");



createApp({
    setup() {
        const carts = ref([{ proAmount: 1, proPrice: 200}, { proAmount: 3, proPrice: 170}]);
        const ttcount  = computed(()=>{
            return carts.value.reduce((acc,item) => acc + item.proAmount, 0);
        })
        const sum = computed(()=>{
            return carts.value.reduce((acc, item) => acc + (item.proPrice * item.proAmount), 0);
        })
        const checkoutHandler = ()=>{};
        const hideCartDropDown = ()=>{
            const element = $("#cart-dropdown").hide();
        };

        return {
            ttcount,
            carts,
            sum,
            checkoutHandler,
            hideCartDropDown
        }
    }
}).mount('#vue-header')