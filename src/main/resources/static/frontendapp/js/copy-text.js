// copy-code.js
document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('copy-btn').addEventListener('click', function() {
        // 獲取折扣碼元素的文本內容
        var discountCode = document.getElementById('discount-code').innerText;

        // 使用 navigator.clipboard API 複製文本
        navigator.clipboard.writeText(discountCode).then(() => {
            // 複製成功時的提示
            alert('折扣碼已複製: ' + discountCode);
        }).catch(err => {
            // 複製失敗時的提示
            console.error('Failed to copy text: ', err);
        });
    });
});
