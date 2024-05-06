
/*购票的页面*/
function calculateTotal() {
    let selectedProject = document.getElementById('selectedProject');
    let totalAmount = document.getElementById('totalAmount');
    let totalPrice = 0;
    selectedProject.innerHTML = '';

    let items = document.querySelectorAll('.item');
    items.forEach(item => {
        let quantity = item.querySelector('.quantity-input').value;
        let price = parseFloat(item.querySelector('.item .price').innerText.split('：')[1].replace('$', ''));
        if (quantity > 0) {
            selectedProject.innerHTML += `<p>${item.querySelector('.item .name').innerText} - ${item.querySelector('.item .time').innerText} - quantity：${quantity}</p>`;
            totalPrice += price * parseInt(quantity);
            totalAmount.innerHTML = `<p class="total">Total Money：$${totalPrice.toFixed(2)}</p>`;
        }
    });
}

// 定义倒计时时间（单位：秒）
const countdownTime = 5 * 60; // 5分钟

let countdownInterval;

// 打开模态框并生成二维码
function openModal() {
clearQRCode(); // 清空旧的二维码
const randomString = generateRandomString();
const qrcode = new QRCode(document.getElementById("qrcode"), {
text: randomString,
width: 200,
height: 200,
});
document.getElementById("myModal").style.display = "block";

// 启动倒计时
startCountdown();
}

// 清空二维码容器
function clearQRCode() {
document.getElementById("qrcode").innerHTML = '';
}

// 生成随机字符串作为二维码内容
function generateRandomString() {
return Math.random().toString(36).substring(7);
}

// 关闭模态框
function closeModal() {
clearInterval(countdownInterval); // 清除倒计时
document.getElementById("myModal").style.display = "none";
}

// 点击模态框外部区域关闭模态框
window.onclick = function(event) {
const modal = document.getElementById("myModal");
if (event.target == modal) {
closeModal();
}
}

// 倒计时函数
function startCountdown() {
let timeLeft = countdownTime;
updateCountdownDisplay(timeLeft);

countdownInterval = setInterval(() => {
timeLeft--;
updateCountdownDisplay(timeLeft);
if (timeLeft === 0) {
    clearInterval(countdownInterval);
    alert("The QR code has expired. Please refresh the page.");
    closeModal();
}
}, 1000);
}

// 更新倒计时显示
function updateCountdownDisplay(timeLeft) {
const minutes = Math.floor(timeLeft / 60);
const seconds = timeLeft % 60;
document.getElementById("countdown").innerText = `Time remaining: ${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
}
