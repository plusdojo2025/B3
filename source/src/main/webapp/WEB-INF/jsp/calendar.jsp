<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/calendar.css'/>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
    margin: 0;
    background: #f0f0f0;
    font-family: sans-serif;
}

/* ヘッダー下に配置されるように */
.calendar-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    }

/* カレンダー本体 */
.calendar {
    background: white;
    border-radius: 8px;
    padding: 20px;
    width: 320px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}

/* 上部のボタンと年月 */
.calendar-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
}

.calendar-header button {
    background: none;
    border: none;
    font-size: 20px;
    cursor: pointer;
    padding: 4px 10px;
}

#month-year {
    font-weight: bold;
    font-size: 1.2em;
    text-align: center;
    flex-grow: 1;
}

/* 曜日と日付 */
.weekdays, .days {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    margin-top: 10px;
}

.weekdays div {
    font-weight: bold;
    text-align: center;
}

.days div {
    text-align: center;
    padding: 10px 0;
    cursor: pointer;
    border-radius: 4px;
}

.days div.today {
    background-color: #2196F3;
    color: white;
}

.days div.selected {
    background-color: #4CAF50;
    color: white;
    font-weight: bold;
}
</style>
</head>
<body>

<!-- ヘッダー（上部固定などしたい場合はstyleで調整） -->
<header>
    <jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<!-- カレンダー中央配置用ラッパー -->
<div class="calendar-wrapper">
    <div class="calendar">
        <div class="calendar-header">
            <button id="prev">&#8249;</button>
            <div id="month-year"></div>
            <button id="next">&#8250;</button>
        </div>
        <div class="weekdays">
            <div>Sun</div><div>Mon</div><div>Tue</div><div>Wed</div>
            <div>Thu</div><div>Fri</div><div>Sat</div>
        </div>
        <div id="days" class="days"></div>

        <div id="perfume-list-section">
            <h3>つけた香水 <span id="selected-date-label">[Select a date]</span>:</h3>
            <ul id="perfume-list"></ul>
        </div>
    </div>
</div>

<script src="<c:url value='/js/calendar.js'/>"></script>

<script>
const daysContainer = document.getElementById("days");
const monthYear = document.getElementById("month-year");
const prevBtn = document.getElementById("prev");
const nextBtn = document.getElementById("next");
const selectedDateInput = document.getElementById("selectedDateInput");
const selectedDateLabel = document.getElementById("selected-date-label");
const perfumeList = document.getElementById("perfume-list");

let date = new Date();
let selectedDay = null;

function renderCalendar() {
    const year = date.getFullYear();
    const month = date.getMonth();
    const firstDay = new Date(year, month, 1).getDay();
    const lastDate = new Date(year, month + 1, 0).getDate();
    const today = new Date();

    monthYear.textContent = date.toLocaleString("default", { month: "long", year: "numeric" });
    daysContainer.innerHTML = "";

    for (let i = 0; i < firstDay; i++) {
        daysContainer.innerHTML += "<div></div>";
    }

    for (let i = 1; i <= lastDate; i++) {
        const day = document.createElement("div");
        day.textContent = i;

        if (i === today.getDate() && month === today.getMonth() && year === today.getFullYear()) {
            day.classList.add("today");
        }

        day.addEventListener("click", () => {
            if (selectedDay) selectedDay.classList.remove("selected");
            day.classList.add("selected");
            selectedDay = day;
            const selectedDate = new Date(year, month, i);
            const formattedDate = selectedDate.toISOString().split("T")[0]; // yyyy-mm-dd
            if (selectedDateInput) selectedDateInput.value = formattedDate;
            if (selectedDateLabel) selectedDateLabel.textContent = formattedDate;
            fetchPerfumes(formattedDate); // Call backend
        });

        daysContainer.appendChild(day);
    }
}

prevBtn.onclick = () => {
    date.setMonth(date.getMonth() - 1);
    selectedDay = null;
    renderCalendar();
};

nextBtn.onclick = () => {
    date.setMonth(date.getMonth() + 1);
    selectedDay = null;
    renderCalendar();
};

function fetchPerfumes(dateString) {
    fetch(`getPerfumes?date=${dateString}`)
        .then(response => {
            if (!response.ok) throw new Error("Network response was not ok");
            return response.json();
        })
        .then(data => {
            perfumeList.innerHTML = "";
            if (data.length === 0) {
                perfumeList.innerHTML = "<li>No perfumes used.</li>";
            } else {
                data.forEach(perfume => {
                    const li = document.createElement("li");
                    li.textContent = perfume.name;
                    perfumeList.appendChild(li);
                });
            }
        })
        .catch(err => {
            console.error("Failed to fetch perfumes:", err);
            perfumeList.innerHTML = "<li>Error loading perfumes.</li>";
        });
}

renderCalendar();
</script>

</body>
</html>