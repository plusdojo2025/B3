<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Parfüm Note | Mytype</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <h2>香水の使用頻度</h2>
    <canvas id="myChart" width="400" height="400"></canvas>

    <script>
        // JavaのデータをJavaScriptに渡す
        const labels = [];
        const data = [];

        <% 
        List<Map<String, Object>> perfumeList = (List<Map<String, Object>>) request.getAttribute("perfumeList");
        for (Map<String, Object> perfume : perfumeList) {
            String name = (String) perfume.get("name");
            int count = (int) perfume.get("count");
        %>
            labels.push("<%= name %>");
            data.push(<%= count %>);
        <% } %>

        const ctx = document.getElementById('myChart').getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: '使用回数',
                    data: data
                }]
            },
            options: {
                responsive: true
            }
        });
    </script>
</body>
</html>