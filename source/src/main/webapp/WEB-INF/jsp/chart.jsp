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
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" /> <!-- ヘッダー -->
	</header>

    <canvas id="pieChart" width="400" height="400"></canvas>

    <%
        List<String> labels = (List<String>) request.getAttribute("labels");
        List<Integer> counts = (List<Integer>) request.getAttribute("counts");
        Map<String, Double> radarData = (Map<String, Double>) request.getAttribute("radarData");
        String[] radarLabels = { "Simple-Complex", "Fresh-Sweet", "Light-Heavy", "Male-Women", "Mild-Spicy" };
    %>

    <script>
        const pieLabels = [<%
            for (int i = 0; i < labels.size(); i++) {
                out.print("\"" + labels.get(i).replace("\"", "\\\"") + "\"");
                if (i < labels.size() - 1) out.print(", ");
            }
        %>];

        const pieData = [<%
            for (int i = 0; i < counts.size(); i++) {
                out.print(counts.get(i));
                if (i < counts.size() - 1) out.print(", ");
            }
        %>];

        const pieChart = new Chart(document.getElementById('pieChart').getContext('2d'), {
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


    <canvas id="radarChart" width="400" height="400"></canvas>

    <script>
        const radarLabels = [<%
            for (int i = 0; i < radarLabels.length; i++) {
                out.print("\"" + radarLabels[i] + "\"");
                if (i < radarLabels.length - 1) out.print(", ");
            }
        %>];

        const radarValues = [<%
            for (int i = 0; i < radarLabels.length; i++) {
                out.print(String.format("%.2f", radarData.getOrDefault(radarLabels[i], 0.0)));
                if (i < radarLabels.length - 1) out.print(", ");
            }
        %>];

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
                        text: '全香水の平均的な傾向（5軸）'
                    }
                }
            }
        });
    </script>
</body>
</html>