<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
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
    <h2>香水の使用回数</h2>
    <canvas id="pieChart" width="400" height="400"></canvas>

    <script>
        // JavaのリストをJSの配列に変換
        const labels = [
            <% 
                List<String> labels = (List<String>) request.getAttribute("labels");
                for (int i = 0; i < labels.size(); i++) {
                    out.print("\"" + labels.get(i).replace("\"", "\\\"") + "\"");
                    if (i < labels.size() - 1) out.print(", ");
                }
            %>
        ];

        const data = [
            <% 
                List<Integer> counts = (List<Integer>) request.getAttribute("counts");
                for (int i = 0; i < counts.size(); i++) {
                    out.print(counts.get(i));
                    if (i < counts.size() - 1) out.print(", ");
                }
            %>
        ];

        const ctx = document.getElementById('pieChart').getContext('2d');
        const pieChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    label: '使用回数',
                    data: data,
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    title: {
                        display: true,
                        text: '香水使用回数'
                    },
                    legend: {
                        position: 'right'
                    }
                }
            }
        });
    </script>
</body>
</html>