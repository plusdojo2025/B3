<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Parfüm Note | Mytype</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
</head>
<body>
    <h2>香水別の使用割合</h2>
    <canvas id="pieChart" width="400" height="400"></canvas>

    <%
        List<String> labels = (List<String>) request.getAttribute("labels");
        List<Integer> counts = (List<Integer>) request.getAttribute("counts");
        Map<String, Double> radarData = (Map<String, Double>) request.getAttribute("radarData");
        List<String> barLabels = (List<String>) request.getAttribute("barLabels");
        List<Integer> barCounts = (List<Integer>) request.getAttribute("barCounts");
        String[] radarLabels = { "Simple-Complex", "Fresh-Sweet", "Light-Heavy", "Male-Women", "Mild-Spicy" };
    %>

    <script>
        // 円グラフ
        const pieLabels = [<% for (int i = 0; i < labels.size(); i++) {
            out.print("\"" + labels.get(i).replace("\"", "\\\"") + "\"");
            if (i < labels.size() - 1) out.print(", ");
        } %>];

        const pieData = [<% for (int i = 0; i < counts.size(); i++) {
            out.print(counts.get(i));
            if (i < counts.size() - 1) out.print(", ");
        } %>];

        new Chart(document.getElementById('pieChart').getContext('2d'), {
            type: 'pie',
            data: {
                labels: pieLabels,
                datasets: [{
                    label: '使用回数',
                    data: pieData,
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    title: {
                        display: true,
                        text: '香水の使用回数'
                    },
                    legend: {
                        position: 'right'
                    }
                }
            }
        });
    </script>

    <h2>所持香水の傾向</h2>
    <canvas id="radarChart" width="400" height="400"></canvas>

    <script>
        const radarLabels = [<% for (int i = 0; i < radarLabels.length; i++) {
            out.print("\"" + radarLabels[i] + "\"");
            if (i < radarLabels.length - 1) out.print(", ");
        } %>];

        const radarValues = [<% for (int i = 0; i < radarLabels.length; i++) {
            out.print(String.format("%.2f", radarData.getOrDefault(radarLabels[i], 0.0)));
            if (i < radarLabels.length - 1) out.print(", ");
        } %>];

        new Chart(document.getElementById('radarChart').getContext('2d'), {
            type: 'radar',
            data: {
                labels: radarLabels,
                datasets: [{
                    label: '全香水の平均傾向',
                    data: radarValues,
                    fill: true,
                    borderColor: 'rgba(54, 162, 235, 1)',
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    pointBackgroundColor: 'rgba(54, 162, 235, 1)'
                }]
            },
            options: {
                responsive: true,
                scales: {
                    r: {
                        min: 0,
                        max: 10,
                        ticks: { stepSize: 1 }
                    }
                },
                plugins: {
                    title: {
                        display: true,
                        text: '全香水の平均的な傾向'
                    }
                }
            }
        });
    </script>

    <h2>好みの匂いの系統</h2>
    <canvas id="barChart" width="400" height="400"></canvas>

    <script>
        const barLabels = [<% for (int i = 0; i < barLabels.size(); i++) {
            out.print("\"" + barLabels.get(i).replace("\"", "\\\"") + "\"");
            if (i < barLabels.size() - 1) out.print(", ");
        } %>];

        const barData = [<% for (int i = 0; i < barCounts.size(); i++) {
            out.print(barCounts.get(i));
            if (i < barCounts.size() - 1) out.print(", ");
        } %>];

        new Chart(document.getElementById('barChart').getContext('2d'), {
            type: 'bar',
            data: {
                labels: barLabels,
                datasets: [{
                    label: '使用回数',
                    data: barData,
                    backgroundColor: 'rgba(255, 159, 64, 0.6)',
                    borderColor: 'rgba(255, 159, 64, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                plugins: {
                    title: {
                        display: true,
                        text: 'よく使われる匂いの系統上位5件）'
                    }
                }
            }
        });
    </script>
</body>
</html>