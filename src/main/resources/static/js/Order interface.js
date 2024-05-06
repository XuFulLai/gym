const dummyOrders = [
    { id: 1, name: "Basketball", time: "2024-04-24 10:00 AM", money: 100.00, status: "Confirmed" },
    { id: 2, name: "Tennis", time: "2024-04-24 11:00 AM", money: 150.00, status: "Pending" },
    { id: 3, name: "Gym", time: "2024-04-25 9:00 AM", money: 80.00, status: "Confirmed" },
    { id: 4, name: "Wushu", time: "2024-04-25 2:00 PM", money: 120.00, status: "Pending" },
    { id: 5, name: "Badminton", time: "2024-04-26 3:00 PM", money: 90.00, status: "Confirmed" },
    { id: 6, name: "Soccer", time: "2024-04-27 4:00 PM", money: 200.00, status: "Confirmed" },
    { id: 7, name: "Basketball", time: "2024-04-28 8:00 AM", money: 120.00, status: "Pending" },
    { id: 8, name: "Gym", time: "2024-04-29 6:00 PM", money: 80.00, status: "Confirmed" },
    { id: 10, name: "Tennis", time: "2024-05-01 10:00 AM", money: 70.00, status: "Confirmed" }
  ];
  function renderOrders(searchTerm) {
    const orderTableBody = document.getElementById("orderTableBody");
    orderTableBody.innerHTML = "";
  
    let totalMoney = 0;
    let found = false; 
    dummyOrders.forEach(order => {
  
      if (order.name.toLowerCase().includes(searchTerm.toLowerCase())) {
        const row = document.createElement("tr");
        row.innerHTML = `
          <td>${order.id}</td>
          <td>${order.name}</td>
          <td>${order.time}</td>
          <td>${order.money}</td>
          <td>${order.status}</td>
        `;
        orderTableBody.appendChild(row);
        totalMoney += order.money; 
        found = true;
      }
    });
    if (!found) {
      const noMatchRow = document.createElement("tr");
      noMatchRow.innerHTML = `
        <td colspan="5">No activities found. Please try a different search.</td>
      `;
      orderTableBody.appendChild(noMatchRow);
    }
    const totalRow = document.createElement("tr");
    totalRow.innerHTML = `
      <td colspan="3"></td>
      <td>Total: ${totalMoney.toFixed(2)}</td>
    `;
    orderTableBody.appendChild(totalRow);
  }
  renderOrders("");
  const searchInput = document.getElementById("searchInput");
  searchInput.addEventListener("input", function() {
    renderOrders(this.value);
  });

 
  function renderOrders(searchTerm) {
    const orderTableBody = document.getElementById("orderTableBody");
    orderTableBody.innerHTML = "";

    let totalMoney = 0;
    let found = false;

    // 发送AJAX请求到后端控制器的/list路径
    $.ajax({
        url: "/list",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({ orderName: searchTerm }), // 向后端发送搜索条件
        success: function(response) {
            response.list.forEach(order => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${order.id}</td>
                    <td>${order.name}</td>
                    <td>${order.time}</td>
                    <td>${order.money}</td>
                    <td>${order.status}</td>
                `;
                orderTableBody.appendChild(row);
                totalMoney += order.money;
                found = true;
            });

            if (!found) {
                const noMatchRow = document.createElement("tr");
                noMatchRow.innerHTML = `
                    <td colspan="5">No activities found. Please try a different search.</td>
                `;
                orderTableBody.appendChild(noMatchRow);
            }

            const totalRow = document.createElement("tr");
            totalRow.innerHTML = `
                <td colspan="3"></td>
                <td>Total: ${totalMoney.toFixed(2)}</td>
            `;
            orderTableBody.appendChild(totalRow);
        },
        error: function(xhr, status, error) {
            console.error("请求失败:", error);
        }
    });
}

// 初始化页面时，调用一次renderOrders函数，以显示所有订单
renderOrders("");

// 监听搜索输入框的输入事件，每次输入时重新渲染订单列表
const searchInput = document.getElementById("searchInput");
searchInput.addEventListener("input", function() {
    renderOrders(this.value);
});
