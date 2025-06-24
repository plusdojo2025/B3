fetch("<%= request.getContextPath() %>/ChartServlet")
  .then(response => response.json())
  .then(data => {
    const labels = Object.keys(data);
    const counts = Object.values(data);

    const ctx = document.getElementById('pieChart').getContext('2d');
    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: "使用割合",
                data: counts
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: { position: 'bottom' }
            }
        }
    });
  });